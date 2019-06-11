package dizzy.only.impl;

import okhttp3.OkHttpClient;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：IOnly
 */
public interface IOnly {

    /**
     * 控制LOG是否显示
     *
     * @return true：显示、false：不显示
     */
    boolean onlyLogState();

    /**
     * 控制Toast是否显示
     *
     * @return true：显示、false：不显示
     */
    boolean onlyToastState();

    /**
     * @return OkHttpClient
     */
    OkHttpClient onlyOkHttpClient();

}
