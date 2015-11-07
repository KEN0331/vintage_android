package vintage.vintage.account;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import vintage.vintage.DebugLog;
import vintage.vintage.VintageDefinition;

public class AccountPreference {
    // クラス名
    private static final String CLASS_NAME = "AccountPreference";
    // AccountPreferenceインスタンス
    private static SharedPreferences mAccountPreference;

    /**
     * AccountPreferenceインスタンス取得
     * @param activity
     */
    public static void getAccountPreference(Activity activity) {
        DebugLog.enter(CLASS_NAME, "getAccountPreference");

        mAccountPreference = activity.getSharedPreferences(VintageDefinition.PREFERENCES_NAME_ACCOUNT_PREFERENCE, Context.MODE_PRIVATE);

        DebugLog.exit(CLASS_NAME, "getAccountPreference");
    }

    /**
     * ログインステータスを設定
     * @param loggedInStatus
     */
    public static void setLoggedInStatus(int loggedInStatus) {
        DebugLog.enter(CLASS_NAME, "setLoggedInStatus");

        if(mAccountPreference == null) {
            DebugLog.trace(CLASS_NAME, "setLoggedInStatus", "mAccountPreference is empty");
            DebugLog.exit(CLASS_NAME, "setLoggedInStatus");
            return;
        }
        SharedPreferences.Editor editor = mAccountPreference.edit();
        editor.putInt(VintageDefinition.LOGGED_IN_STATUS, loggedInStatus);
        editor.commit();

        DebugLog.exit(CLASS_NAME, "setLoggedInStatus");
        return;
    }

    /**
     * ログインステータスを判定
     * @return
     */
    public static int getLoggedInStatus() {
        DebugLog.enter(CLASS_NAME, "getLoggedInStatus");

        int loggedInStatus = VintageDefinition.LOGGED_OFF;
        if(mAccountPreference != null) {
            // AccountPreferenceインスタンスが空でなければログインステータス判定
            loggedInStatus = mAccountPreference.getInt(VintageDefinition.LOGGED_IN_STATUS, VintageDefinition.LOGGED_OFF);
        }

        DebugLog.exit(CLASS_NAME, "getLoggedInStatus");
    return loggedInStatus;
    }
}
