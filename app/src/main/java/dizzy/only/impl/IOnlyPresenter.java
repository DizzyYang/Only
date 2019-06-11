package dizzy.only.impl;

import android.os.Bundle;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：IOnlyPresenter
 */
public interface IOnlyPresenter<V> {

    /**
     * 设置视图
     *
     * @param view
     */
    void onlyAttach(V view);

    /**
     * 创建
     */
    void onlyCreate();

    /**
     * 获取传值
     *
     * @param bundle
     */
    void onlyExtras(Bundle bundle);

    /**
     * 获取视图
     *
     * @return 视图
     */
    V onlyView();

    /**
     * 是否设置视图
     *
     * @return true：设置、false：未设置
     */
    boolean isOnlyAttached();

    /**
     * 销毁
     */
    void onlyDestroy();

    /**
     * 移除视图
     */
    void onlyDetach();

}
