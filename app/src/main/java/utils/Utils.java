package utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by nick on 2017/9/11.
 */

public class Utils {
    private static Context sAppContext;

    public static void startActivity(Context context, Class targetName){
        Intent intent = new Intent(context, targetName);
        context.startActivity(intent);
    }

    public static Context getsAppContext() {
        return sAppContext;
    }

    public static void setsAppContext(Context sAppContext) {
        Utils.sAppContext = sAppContext;
    }


}
