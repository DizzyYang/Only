package dizzy.only.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：ToastUtils
 */
public class ToastUtils {

    private static boolean mIsShow;
    private static Context mContext;
    private static Toast toast;

    public static void init(boolean isShow, Context context) {
        mIsShow = isShow;
        mContext = context;
    }

    /**
     * LENGTH_SHORT
     *
     * @param stringId
     */
    public static void showShort(int stringId) {
        if (mContext != null) {
            showShort(mContext.getString(stringId));
        }
    }

    /**
     * LENGTH_SHORT
     *
     * @param message
     */
    public static void showShort(String message) {
        if (mIsShow && mContext != null) {
            if (toast == null) {
                toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
            } else {
                if (toast.getDuration() == Toast.LENGTH_LONG) {
                    toast.setDuration(Toast.LENGTH_SHORT);
                }
                toast.setText(message);
            }
            toast.show();
        }
    }

    /**
     * LENGTH_LONG
     *
     * @param stringId
     */
    public static void showLong(int stringId) {
        if (mContext != null) {
            showLong(mContext.getString(stringId));
        }
    }

    /**
     * LENGTH_LONG
     *
     * @param message
     */
    public static void showLong(String message) {
        if (mIsShow && mContext != null) {
            if (toast == null) {
                toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
            } else {
                if (toast.getDuration() == Toast.LENGTH_SHORT) {
                    toast.setDuration(Toast.LENGTH_LONG);
                }
                toast.setText(message);
            }
            toast.show();
        }
    }

}
