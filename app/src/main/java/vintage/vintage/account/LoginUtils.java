package vintage.vintage.account;

import android.app.Activity;

import vintage.vintage.DebugLog;
import vintage.vintage.VintageDefinition;

public class LoginUtils {
    // クラス名
    private static final String CLASS_NAME = "LoginUtils";

    /**
     * ログイン処理
     * @param activity
     */
    public static void login(Activity activity){
        DebugLog.enter(CLASS_NAME, "login");

        // プリファレンスにログイン状態を設定
        AccountPreference.getAccountPreference(activity);
        AccountPreference.setLoggedInStatus(VintageDefinition.LOGGED_ON);

        DebugLog.exit(CLASS_NAME, "login");
    }

    /**
     * ログアウト処理
     * @param activity
     */
    public static void logout(Activity activity){
        DebugLog.enter(CLASS_NAME, "logout");

        // プリファレンスにログオフ状態を設定
        AccountPreference.getAccountPreference(activity);
        AccountPreference.setLoggedInStatus(VintageDefinition.LOGGED_OFF);

        DebugLog.exit(CLASS_NAME, "logout");
    }

    /**
     * ログイン状態取得
     * @return
     */
    public static boolean isSignedIn() {
        DebugLog.enter(CLASS_NAME, "isSignedIn");

        boolean ret = false;
        // プリファレンスからログインステータス取得
        int loggedInStatus = AccountPreference.getLoggedInStatus();
        if(loggedInStatus == VintageDefinition.LOGGED_ON) {
            ret = true;
        }

        DebugLog.exit(CLASS_NAME, "isSignedIn");
        return ret;
    }
}
