package dizzy.only.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：DeviceUtils
 */
public class DeviceUtils {

    /**
     * 获取设备版本
     *
     * @return
     */
    public static int getVersionSDK() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取设备名称
     *
     * @return
     */
    public static String getDeviceName() {
        return android.os.Build.DEVICE;
    }

    /**
     * 获取设备品牌
     *
     * @return
     */
    public static String getBrandName() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取设备型号
     *
     * @return
     */
    public static String getModelName() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取ANDROID_ID
     *
     * @param context
     * @return
     */
    public static String getAndroidID(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取设备的IMEI
     *
     * @param context
     * @return
     */
    public static String getDeviceIMEI(Context context) {
        try {
            TelephonyManager telecomManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return telecomManager.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取设备的IMSI
     *
     * @param context
     * @return
     */
    public static String getDeviceIMSI(Context context) {
        try {
            TelephonyManager telecomManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return telecomManager.getSubscriberId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
