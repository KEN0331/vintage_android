package vintage.vintage.account;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vintage.vintage.DebugLog;
import vintage.vintage.R;
import vintage.vintage.VintageDefinition;

public class LoginActivity extends Activity {
    // クラス名
    private static final String CLASS_NAME = "LoginActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        DebugLog.enter(CLASS_NAME, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((Button) findViewById(R.id.loginBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugLog.enter(CLASS_NAME, "onClick");

                // ログイン
                login();
                finish();

                DebugLog.exit(CLASS_NAME, "onClick");
                return;
            }
        });

        DebugLog.exit(CLASS_NAME, "onCreate");
    }

    /**
     * ログイン処理
     */
    private void login(){
        DebugLog.enter(CLASS_NAME, "login");

        LoginUtils.login(this);

        DebugLog.exit(CLASS_NAME, "login");
    }
}
