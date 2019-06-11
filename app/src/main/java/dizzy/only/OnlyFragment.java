package dizzy.only;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        View view = onlyBuilder(onlyBuilder).create(getActivity());
        if (view != null) {
            mUnbinder = ButterKnife.bind(this, view);
            mOnlyLayoutState = onlyBuilder.getOnlyLayoutState();
            mOnlyStateView = onlyBuilder.getOnlyStateView();
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        onlyCreate(savedInstanceState);
        mOnlyCreate = true;
        if (getUserVisibleHint()) {
            onlyLazyLoad();
        }
    }

    @Override
    public P onlyPresenter() {
        if (mOnlyPresenter == null) {
            mOnlyPresenter = OnlyHelper.getOnlyPresenter(this.getClass());
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
    public void onDetach() {
        super.onDetach();
        if (mOnlyPresenter != null) {
            mOnlyPresenter.onlyDestroy();
            mOnlyPresenter.onlyDetach();
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        KeyUtils.closeKey(getActivity());
    }

}
