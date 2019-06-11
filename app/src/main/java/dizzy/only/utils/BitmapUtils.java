package dizzy.only.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：BitmapUtils
 */
public class BitmapUtils {

    /**
     * 图片写入
     *
     * @param bitmap
     * @param dir
     * @param name
     * @param quality
     */
    public static void compressBitmap(Bitmap bitmap, File dir, String name, int quality) {
        if (SDUtils.isSDCardEnable()) {
            try {
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, name);
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取图片旋转度数
     *
     * @param path
     * @return
     */
    public static int getPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 旋转图片
     *
     * @param degree
     * @param bitmap
     * @return
     */
    public static Bitmap rotaingBitmap(int degree, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

}
