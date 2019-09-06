package dizzy.only;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dizzy.only.impl.IOnlyFragment;
import dizzy.only.prompt.OnlyPromptDialog;
import dizzy.only.state.OnlyStateView;
import dizzy.only.utils.KeyUtils;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyFragment
 */
public abstract class OnlyFragment<P extends OnlyPresenter> extends Fragment implements IOnlyFragment<P> {

    private OnlyPromptDialog mOnlyPromptDialog;
    private View mView;
    private Unbinder mUnbinder;
    private boolean mOnlyLayoutState;
    private OnlyStateView mOnlyStateView;
    private P mOnlyPresenter;
    private boolean mOnlyCreate;

    protected abstract OnlyBuilder onlyBuilder(OnlyBuilder onlyBuilder);

    @Override
    public OnlyPromptDialog onlyPromptDialog() {
        if (mOnlyPromptDialog == null) {
            mOnlyPromptDialog = new OnlyPromptDialog(getActivity());
        }
        return mOnlyPromptDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnlyPresenter = onlyPresenter();
        if (mOnlyPresenter != null) {
            mOnlyPresenter.onlyAttach(this);
            mOnlyPresenter.onlyCreate();
        }
        Bundle bundle = getArguments();
        if (bundle != null) {
            onlyExtras(bundle);
            if (mOnlyPresenter != null) {
                mOnlyPresenter.onlyExtras(bundle);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
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
            mView = onlyBuilder(onlyBuilder).create(getActivity());
            if (mView != null) {
                mUnbinder = ButterKnife.bind(this, mView);
                mOnlyLayoutState = onlyBuilder.getOnlyLayoutState();
                mOnlyStateView = onlyBuilder.getOnlyStateView();
            }
        } else {
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
        }
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mOnlyCreate) {
            return;
        }
        onlyCreate(savedInstanceState);
        mOnlyCreate = true;
        if (getUserVisibleHint()) {
            onlyLazyLoad();
        }
    }

    @Override
    public P onlyPresenter() {
        if (mOnlyPresenter == null) {
            mOnlyPresenter = OnlyHelper.getOnlyPresenter(getClass());
        }
        return mOnlyPresenter;
    }

    @Override
    public void onlyExtras(Bundle bundle) {
    }

    protected abstract void onlyCreate(Bundle savedInstanceState);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint() && mOnlyCreate) {
            onlyLazyLoad();
        }
    }

    @Override
    public void onlyLazyLoad() {
    }

    @Override
    public <A extends OnlyActivity> A onlyActivity() {
        return (A) getActivity();
    }

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
    public void onDestroy() {
        super.onDestroy();
        if (mOnlyPresenter != null) {
            mOnlyPresenter.onlyDestroy();
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        KeyUtils.closeKey(getActivity());
    }

}
