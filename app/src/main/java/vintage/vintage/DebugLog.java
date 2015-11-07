package vintage.vintage;

import android.util.Log;


public class DebugLog {
    private static final String ENTER = "<<";
    private static final String EXIT = ">>";

    /**
     * メソッド開始ログ
     * @param className
     * @param method
     */
    public static void enter(String className, String method) {
        Log.d(VintageDefinition.APPLICATION_NAME + ":" + className + "." + method, ENTER);
        return;
    }

    /**
     * メソッド終了ログ
     * @param className
     * @param method
     */
    public static void exit(String className, String method) {
        Log.d(VintageDefinition.APPLICATION_NAME + ":" + className + "." + method, EXIT);
        return;
    }

    /**
     * トレースログ
     * @param className
     * @param method
     * @param message
     */
    public static void trace(String className, String method, String message) {
        Log.d(VintageDefinition.APPLICATION_NAME + ":" + className + "." + method, message);
        return;
    }
}
