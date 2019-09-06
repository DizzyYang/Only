package dizzy.only;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import butterknife.ButterKnife;
import dizzy.only.impl.IOnlyActivity;
import dizzy.only.prompt.OnlyPromptDialog;
import dizzy.only.state.OnlyStateView;
import dizzy.only.utils.KeyUtils;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyActivity
 */
public abstract class OnlyActivity<P extends OnlyPresenter> extends AppCompatActivity implements IOnlyActivity<P> {

    private OnlyPromptDialog mOnlyPromptDialog;
    private boolean mOnlyLayoutState;
    private boolean mOnlySwipeBack;
    private VelocityTracker mVelocityTracker;
    private MotionEvent mMotionEvent;
    private OnlyStateView mOnlyStateView;
    private P mOnlyPresenter;

    protected abstract OnlyBuilder onlyBuilder(OnlyBuilder onlyBuilder);

    @Override
    public OnlyPromptDialog onlyPromptDialog() {
        if (mOnlyPromptDialog == null) {
            mOnlyPromptDialog = new OnlyPromptDialog(this);
        }
        return mOnlyPromptDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnlyBuilder onlyBuilder = new OnlyBuilder(OnlyHelper.getIOnlyView(),
                new OnlyStateView.OnFocusListener() {
                    @Override
                    public void onFocus() {
                        onlyFocus();
                    }
                },
                new OnlyStateView.OnEmptyListener() {
                    @Override
                    public void onEmpty() {
                        onlyEmpty();
                    }
                },
                new OnlyStateView.OnErrorListener() {
                    @Override
                    public void onError() {
                        onlyError();
                    }
                });
        View view = onlyBuilder(onlyBuilder).create(this);
        if (view != null) {
            setContentView(view);
            ButterKnife.bind(this);
            mOnlyLayoutState = onlyBuilder.getOnlyLayoutState();
            mOnlySwipeBack = onlyBuilder.getOnlySwipeBack();
            mOnlyStateView = onlyBuilder.getOnlyStateView();
        }
        mOnlyPresenter = onlyPresenter();
        if (mOnlyPresenter != null) {
            mOnlyPresenter.onlyAttach(this);
            mOnlyPresenter.onlyCreate();
        }
        Intent intent = getIntent();
        if (intent != null) {
            onlyIntent(intent);
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                onlyExtras(bundle);
                if (mOnlyPresenter != null) {
                    mOnlyPresenter.onlyExtras(bundle);
                }
            }
        }
        onlyCreate(savedInstanceState);
    }

    @Override
    public P onlyPresenter() {
        if (mOnlyPresenter == null) {
            mOnlyPresenter = OnlyHelper.getOnlyPresenter(getClass());
        }
        return mOnlyPresenter;
    }

    @Override
    public void onlyIntent(Intent intent) {
    }

    @Override
    public void onlyExtras(Bundle bundle) {
    }

    protected abstract void onlyCreate(Bundle savedInstanceState);

    @Override
    public void showLoading() {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showLoading();
    }

    @Override
    public void showContent() {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showContent();
    }

    @Override
    public void showEmpty() {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showEmpty();
    }

    @Override
    public void showEmpty(int id, int stringId) {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showEmpty(id, stringId);
    }

    @Override
    public void showEmpty(int id, String string) {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showEmpty(id, string);
    }

    @Override
    public void showError() {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showError();
    }

    @Override
    public void showError(int id, int stringId) {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showError(id, stringId);
    }

    @Override
    public void showError(int id, String string) {
        if (!mOnlyLayoutState || mOnlyStateView == null) {
            return;
        }
        mOnlyStateView.showError(id, string);
    }

    @Override
    public int getShowState() {
        if (mOnlyStateView == null) {
            return -1;
        }
        return mOnlyStateView.getShowState();
    }

    @Override
    public void onlyFocus() {
    }

    @Override
    public void onlyEmpty() {
    }

    @Override
    public void onlyError() {
    }

    @Override
    public boolean onlySwipeBack() {
        return mOnlySwipeBack;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!onlySwipeBack()) {
            return super.dispatchTouchEvent(ev);
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            if (mMotionEvent != null) {
                mMotionEvent.recycle();
            }
            mMotionEvent = MotionEvent.obtain(ev);
        } else if (ev.getActionMasked() == MotionEvent.ACTION_UP) {
            int pointerId = ev.getPointerId(0);
            ViewConfiguration configuration = ViewConfiguration.get(this);
            int minimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            int maximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
            mVelocityTracker.computeCurrentVelocity(1000, maximumFlingVelocity);
            float xVelocity = mVelocityTracker.getXVelocity(pointerId);
            if (mMotionEvent.getX() <= 50 && ev.getX() - mMotionEvent.getX() >= 250
                    && Math.abs(xVelocity) >= minimumFlingVelocity) {
                onBackPressed();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mOnlyPresenter != null) {
            mOnlyPresenter.onlyDestroy();
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
        }
        KeyUtils.closeKey(this);
    }

}
