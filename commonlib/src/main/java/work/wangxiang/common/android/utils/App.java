package work.wangxiang.common.android.utils;

import android.app.Application;

/**
 * custom application class
 * 参考：
 * https://nfrolov.wordpress.com/2014/07/12/android-using-context-statically-and-in-singletons/
 * Created by wangxiang on 2018/2/27.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        appCtx = this;
        super.onCreate();
    }

    public static Application getCtx() {
        return appCtx;
    }

    private static App appCtx;
}
