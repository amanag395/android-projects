package craterzone.thered;

import android.app.Application;
import android.os.Handler;

/**
 * Created by aMAN GUPTA on 3/7/2017.
 */

public class MyApplication extends Application {
    private Handler handler;
    private static MyApplication application;

    public MyApplication() {
        handler = new Handler();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static MyApplication getApplication() {
        return application;
    }

    public void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }
}
