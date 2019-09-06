package dizzy.only;

import android.app.Application;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import dizzy.only.impl.IOnlyView;
import leo.android.cglib.proxy.Enhancer;
import leo.android.cglib.proxy.MethodInterceptor;
import leo.android.cglib.proxy.MethodProxy;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyHelper
 */
public class OnlyHelper {

    private static Application mApplication;
    private static IOnlyView mIOnlyView;

    public static void setOnly(Application application) {
        mApplication = application;
    }

    public static Application getOnly() {
        return mApplication;
    }

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
            Class pClass = getGenericClass(clazz);
            if (pClass != null) {
                return (P) pClass.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <V> V getOnlyView(Class clazz) {
        Enhancer enhancer = new Enhancer(getOnly());
        enhancer.setSuperclass(getGenericClass(clazz));
        enhancer.setInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Object[] objects, MethodProxy methodProxy) throws Exception {
                return null;
            }
        });
        return (V) enhancer.create();
    }

    public static Class getGenericClass(Class clazz) {
        Type type = clazz.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType pType = (ParameterizedType) type;
        Type[] types = pType.getActualTypeArguments();
        if (types.length < 1) {
            return null;
        }
        return (Class) types[0];
    }

}
