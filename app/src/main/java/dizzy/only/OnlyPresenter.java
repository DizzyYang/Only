package dizzy.only;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import dizzy.only.impl.IOnlyPresenter;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyPresenter
 */
public class OnlyPresenter<V> implements IOnlyPresenter<V> {

    private WeakReference<V> mOnlyView;

    @Override
    public void onlyAttach(V onlyView) {
        mOnlyView = new WeakReference<>(onlyView);
    }

    @Override
    public void onlyCreate() {
    }

    @Override
    public void onlyExtras(Bundle bundle) {
    }

    @Override
    public V onlyView() {
        if(isOnlyAttached()){
            return mOnlyView.get();
        }
        return OnlyHelper.getOnlyView(getClass());
    }

    @Override
    public boolean isOnlyAttached() {
        return mOnlyView != null && mOnlyView.get() != null;
    }

    @Override
    public void onlyDestroy() {
    }

    @Override
    public void onlyDetach() {
        if (mOnlyView != null) {
            mOnlyView.clear();
            mOnlyView = null;
        }
    }

}
