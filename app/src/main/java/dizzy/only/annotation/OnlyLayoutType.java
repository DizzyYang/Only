package dizzy.only.annotation;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyLayoutType
 */
@IntDef({OnlyLayoutType.NONE, OnlyLayoutType.LINEAR, OnlyLayoutType.FRAME})
@Retention(RetentionPolicy.SOURCE)
public @interface OnlyLayoutType {

    public static final int NONE = 0;
    public static final int LINEAR = 1;
    public static final int FRAME = 2;

}
