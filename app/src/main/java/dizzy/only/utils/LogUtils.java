package dizzy.only.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：LogUtils
 */
public class LogUtils {

    private static boolean mIsDebug;
    private static String mTag;

    public static void init(boolean isDebug, String tag) {
        mIsDebug = isDebug;
        mTag = tag;
    }

    /**
     * INFO
     *
     * @param msg
     */
    public static void i(String msg) {
        if (mIsDebug && !TextUtils.isEmpty(mTag)) {
            i(mTag, msg);
        }
    }

    /**
     * INFO
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (mIsDebug) {
            Log.i(tag, msg);
        }
    }

    /**
     * DEBUG
     *
     * @param msg
     */
    public static void d(String msg) {
        if (mIsDebug && !TextUtils.isEmpty(mTag)) {
            d(mTag, msg);
        }
    }

    /**
     * DEBUG
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (mIsDebug) {
            Log.d(tag, msg);
        }
    }

    /**
     * ERROR
     *
     * @param msg
     */
    public static void e(String msg) {
        if (mIsDebug && !TextUtils.isEmpty(mTag)) {
            e(mTag, msg);
        }
    }

    /**
     * ERROR
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (mIsDebug) {
            Log.e(tag, msg);
        }
    }

    /**
     * WARN
     *
     * @param msg
     */
    public static void w(String msg) {
        if (mIsDebug && !TextUtils.isEmpty(mTag)) {
            w(mTag, msg);
        }
    }

    /**
     * WARN
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        if (mIsDebug) {
            Log.w(tag, msg);
        }
    }

    /**
     * VERBOSE
     *
     * @param msg
     */
    public static void v(String msg) {
        if (mIsDebug && !TextUtils.isEmpty(mTag)) {
            v(mTag, msg);
        }
    }

    /**
     * VERBOSE
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (mIsDebug) {
            Log.v(tag, msg);
        }
    }

}
