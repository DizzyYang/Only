package dizzy.only;

import java.lang.reflect.ParameterizedType;
import dizzy.only.impl.IOnlyView;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyHelper
 */
class OnlyHelper {

    private static IOnlyView mIOnlyView;

    public static void setIOnlyView(IOnlyView iOnlyView) {
        mIOnlyView = iOnlyView;
    }

    public static IOnlyView getIOnlyView() {
        return mIOnlyView != null ? mIOnlyView : new IOnlyView() {
            @Override
            public int onlyBackground() {
                return 0;
            }

            @Override
            public int onlyStatusBarColor() {
                return 0;
            }

            @Override
            public int onlyToolbarColor() {
                return 0;
            }

            @Override
            public int onlyLoadingId() {
                return 0;
            }

            @Override
            public int onlyEmptyId() {
                return 0;
            }

            @Override
            public int onlyErrorId() {
                return 0;
            }
        };
    }

    public static <P extends OnlyPresenter> P getOnlyPresenter(Class clazz) {
        try {
            ParameterizedType pType = (ParameterizedType) clazz.getGenericSuperclass();
            Class<P> pClass = (Class<P>) pType.getActualTypeArguments()[0];
            return pClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
