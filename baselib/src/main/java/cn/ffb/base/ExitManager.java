package cn.ffb.base;

import android.content.Context;
import android.content.Intent;

/**
 * 退出管理
 *
 * @author lingfei 2017-6-5
 */
public class ExitManager {

    public static void home(Context context) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
    }

    public static void finishApplication(Context context) {
        ActivityManager.getInstance().finishAllActivity();
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
    }

    public static void exit(Context context) {
        finishApplication(context);
        home(context);
    }


}
