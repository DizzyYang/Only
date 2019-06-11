package dizzy.only;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
            mOnlyPresenter = OnlyHelper.getOnlyPresenter(this.getClass());
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
    protected void onDestroy() {
        super.onDestroy();
        if (mOnlyPresenter != null) {
            mOnlyPresenter.onlyDestroy();
            mOnlyPresenter.onlyDetach();
        }
        KeyUtils.closeKey(this);
    }

}
