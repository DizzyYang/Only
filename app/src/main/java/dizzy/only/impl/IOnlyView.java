package dizzy.only.impl;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：IOnlyView
 */
public interface IOnlyView {

    /**
     * 设置根布局颜色
     *
     * @return 颜色值
     */
    int onlyBackground();

    /**
     * 设置状态栏颜色
     *
     * @return 颜色值
     */
    int onlyStatusBarColor();

    /**
     * 设置标题栏颜色
     *
     * @return 颜色值
     */
    int onlyToolbarColor();

    /**
     * 加载布局
     *
     * @return 加载Id
     */
    int onlyLoadingId();

    /**
     * 缺省布局
     *
     * @return 缺省Id
     */
    int onlyEmptyId();

    /**
     * 错误布局
     *
     * @return 错误Id
     */
    int onlyErrorId();

}
