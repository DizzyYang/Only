package dizzy.only.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：KeyUtils
 */
public class KeyUtils {

    /**
     * 关闭键盘
     *
     * @param activity
     */
    public static void closeKey(Activity activity) {
        if (activity == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 显示键盘
     *
     * @param activity
     * @param editText
     */
    public static void openKey(Activity activity, EditText editText) {
        if (activity == null || editText == null) {
            return;
        }
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(editText, InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    /**
     * 延迟显示键盘
     *
     * @param activity
     * @param editText
     */
    public static void openKeyDelay(final Activity activity, final EditText editText) {
        editText.postDelayed(new Runnable() {

            @Override
            public void run() {
                openKey(activity, editText);
            }
        }, 500);
    }

    /**
     * 是否显示
     *
     * @param activity
     * @return
     */
    public static boolean isOpenKey(Activity activity) {
        if (activity == null) {
            return false;
        }
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm != null && imm.isActive();
    }

}
