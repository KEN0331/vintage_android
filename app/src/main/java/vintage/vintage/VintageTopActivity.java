package vintage.vintage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import vintage.vintage.account.LoginActivity;
import vintage.vintage.account.LoginUtils;

public class VintageTopActivity extends ActionBarActivity {
    // クラス名
    private static final String CLASS_NAME = "VintageTopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DebugLog.enter(CLASS_NAME, "onCreate");

        super.onCreate(savedInstanceState);
        onCreateExecution();

        DebugLog.exit(CLASS_NAME, "onCreate");
    }

    /**
     * onCreate()実行処理
     */
    private void onCreateExecution() {
        DebugLog.enter(CLASS_NAME, "onCreateExecution");

        setContentView(R.layout.activity_vintage_top);

        DebugLog.exit(CLASS_NAME, "onCreateExecution");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        DebugLog.enter(CLASS_NAME, "onCreateOptionsMenu");

        // 現状処理なし

        DebugLog.exit(CLASS_NAME, "onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        DebugLog.enter(CLASS_NAME, "onPrepareOptionsMenu");

        super.onPrepareOptionsMenu(menu);
        // オプションメニュー生成処理
        createOptionMenu(menu);

        DebugLog.exit(CLASS_NAME, "onPrepareOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        DebugLog.enter(CLASS_NAME, "onOptionsItemSelected");

        int id = item.getItemId();
        int groupId = item.getGroupId();

        switch(id) {
            case R.id.action_account_settings:
                // 「アカウント設定」タップ時
                DebugLog.trace(CLASS_NAME, "onOptionsItemSelected", "action_account_settings: 「アカウント設定」");

                break;
            case R.id.action_sign_out:
                // 「ログアウト」タップ時
                DebugLog.trace(CLASS_NAME, "onOptionsItemSelected", "action_sign_out: 「ログアウト」");
                LoginUtils.logout(this);
                break;
            case R.id.action_sign_up:
                // 「会員登録」タップ時
                DebugLog.trace(CLASS_NAME, "onOptionsItemSelected", "action_sign_up: 「会員登録」");

                break;
            case R.id.action_sign_in:
                // 「ログイン」タップ時
                DebugLog.trace(CLASS_NAME, "onOptionsItemSelected", "action_sign_in: 「ログイン」");

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }

        DebugLog.exit(CLASS_NAME, "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        DebugLog.enter(CLASS_NAME, "onResume");

        super.onResume();
        onResumeExecution();

        DebugLog.exit(CLASS_NAME, "onResume");
    }

    /**
     * onResume()実行処理
     */
    private void onResumeExecution() {
        DebugLog.enter(CLASS_NAME, "onResumeExecution");
        // 現状処理なし

        DebugLog.exit(CLASS_NAME, "onResumeExecution");
    }

    /**
     * オプションメニュー生成処理
     * @param menu
     */
    private void createOptionMenu(Menu menu) {
        DebugLog.enter(CLASS_NAME, "createOptionMenu");

        // メニュー初期化
        menu.clear();
        //ユーザーログイン状態判定
        boolean signedIn = LoginUtils.isSignedIn();
        if(signedIn) {
            // ログイン中表示用メニュー
            DebugLog.trace(CLASS_NAME, "createOptionMenu", "isSignedIn():" + signedIn + "「ログイン中」");

            getMenuInflater().inflate(R.menu.menu_vintage_top_signed_in, menu);
        } else {
            // ログオフ中表示用メニュー
            DebugLog.trace(CLASS_NAME, "createOptionMenu", "isSignedIn():" + signedIn + "「ログオフ中」");

            getMenuInflater().inflate(R.menu.menu_vintage_top_unsigned_in, menu);
        }

        DebugLog.exit(CLASS_NAME, "createOptionMenu");
    }


}
