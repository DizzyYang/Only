package dizzy.only;

import android.app.Application;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import dizzy.only.impl.IOnly;
import dizzy.only.impl.IOnlyView;
import dizzy.only.utils.LogUtils;
import dizzy.only.utils.ToastUtils;
import okhttp3.OkHttpClient;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：Only
 */
public class Only extends Application implements IOnly, IOnlyView {

    @Override
    public void onCreate() {
        super.onCreate();
        OnlyHelper.setOnly(this);
        OnlyHelper.setIOnlyView(this);
        LogUtils.init(onlyLogState(), "Only");
        ToastUtils.init(onlyToastState(), this);
        OkGo.getInstance().init(this).setOkHttpClient(onlyOkHttpBuilder().build());
    }

    @Override
    public boolean onlyLogState() {
        return false;
    }

    @Override
    public boolean onlyToastState() {
        return false;
    }

    @Override
    public OkHttpClient.Builder onlyOkHttpBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        if (onlyLogState()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("Only");
            loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
            loggingInterceptor.setColorLevel(Level.INFO);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder;
    }

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

}
