package dizzy.only.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：SDUtils
 */
public class SDUtils {

    /**
     * 判断SDCard状态
     *
     * @return
     */
    public static boolean isSDCardEnable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取SDCard路径
     *
     * @return
     */
    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    /**
     * 获取程序外部目录
     *
     * @param context
     * @param dirName
     * @return
     */
    public static File getExternalDir(Context context, String dirName) {
        String cacheDir = "/Android/data/" + context.getPackageName() + "/";
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + cacheDir + dirName + "/");
    }

}
