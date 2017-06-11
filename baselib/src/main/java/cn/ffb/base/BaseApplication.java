package cn.ffb.base;

import android.app.Application;

import com.orhanobut.logger.Logger;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cn.ffb.base.log.FileLogAdapter;
import timber.log.Timber;

/**
 * Created by lingfei on 2017/6/4.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 异常处理
        CustomActivityOnCrash.install(this);
        // 日志打印
        Logger.init().methodCount(10).logAdapter(new FileLogAdapter(this));
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected void log(int priority, String tag, String message, Throwable t) {
                Logger.log(priority, tag, message, t);
            }
        });
    }

}
