package dizzy.only.impl;

import android.content.Intent;
import android.os.Bundle;
import dizzy.only.OnlyPresenter;
import dizzy.only.prompt.OnlyPromptDialog;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：IOnlyActivity
 */
public interface IOnlyActivity<P extends OnlyPresenter> {

    /**
     * 提示对话框
     *
     * @return 提示对话框
     */
    OnlyPromptDialog onlyPromptDialog();

    /**
     * 初始化业务
     *
     * @return 业务
     */
    P onlyPresenter();

    /**
     * 获取意图
     *
     * @param intent
     */
    void onlyIntent(Intent intent);

    /**
     * 获取传值
     *
     * @param bundle
     */
    void onlyExtras(Bundle bundle);

    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 显示内容
     */
    void showContent();

    /**
     * 显示缺省
     */
    void showEmpty();

    /**
     * 显示缺省
     *
     * @param id
     * @param stringId
     */
    void showEmpty(int id, int stringId);

    /**
     * 显示缺省
     *
     * @param id
     * @param string
     */
    void showEmpty(int id, String string);

    /**
     * 显示错误
     */
    void showError();

    /**
     * 显示错误
     *
     * @param id
     * @param stringId
     */
    void showError(int id, int stringId);

    /**
     * 显示错误
     *
     * @param id
     * @param string
     */
    void showError(int id, String string);

    /**
     * 获取显示状态
     *
     * @return 状态
     */
    int getShowState();

    /**
     * 焦点回调
     */
    void onlyFocus();

    /**
     * 缺省回调
     */
    void onlyEmpty();

    /**
     * 错误回调
     */
    void onlyError();

}
