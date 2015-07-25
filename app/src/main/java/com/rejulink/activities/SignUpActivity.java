package com.rejulink.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;
import com.rejulink.R;
import com.rejulink.protocols.CMServerAccountProtocol;
import com.rejulink.protocols.bean.ResponseCMSNormal;
import com.rejulink.utils.CodeDefine;
import com.rejulink.utils.GlobalDefine;
import com.rejulink.utils.RegDefine;
import com.rejulink.utils.SharedPreferenceHelper;
import com.rejulink.utils.ShowMessage;

import org.apache.http.Header;

@SuppressWarnings("deprecation")
public class SignUpActivity extends BaseActivity implements OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText edit_text_sign_up_account;
    private EditText edit_text_sign_up_sms_code;
    private EditText edit_text_sign_up_new_password;
    private Button button_sign_up_sms_code;
    private Button button_sign_up_done;
    private TextView text_view_title_bar_text_back;
    private CheckBox check_box_sign_up_new_password;

    public static void launchActivity(Context context, Bundle bundle) {
        context.startActivity(new Intent(context, SignUpActivity.class), bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        text_view_title_bar_text_back = (TextView) findViewById(R.id.text_view_title_bar_text_back);
        edit_text_sign_up_account = (EditText) findViewById(R.id.edit_text_sign_up_account);
        edit_text_sign_up_sms_code = (EditText) findViewById(R.id.edit_text_sign_up_sms_code);
        edit_text_sign_up_new_password = (EditText) findViewById(R.id.edit_text_sign_up_new_password);
        button_sign_up_sms_code = (Button) findViewById(R.id.button_sign_up_sms_code);
        button_sign_up_done = (Button) findViewById(R.id.button_sign_up_done);
        check_box_sign_up_new_password = (CheckBox) findViewById(R.id.check_box_sign_up_new_password);
        text_view_title_bar_text_back.setOnClickListener(this);
        text_view_title_bar_text_back.setText(R.string.title_activity_sign_in);
        button_sign_up_sms_code.setOnClickListener(this);
        button_sign_up_done.setOnClickListener(this);
        check_box_sign_up_new_password.setOnCheckedChangeListener(this);
        nextActivity = ActivityEnum.MAIN_ACTIVITY;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_text_sign_up_sms_code:
                requestRegisterSMS();
                break;
            case R.id.button_sign_up_done:
                smsRegister();
                break;
            case R.id.text_view_title_bar_text_back:
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            edit_text_sign_up_new_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            edit_text_sign_up_new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        Selection.setSelection(edit_text_sign_up_new_password.getText(), edit_text_sign_up_new_password.getText().length());
    }

    private void requestRegisterSMS() {
        String account = edit_text_sign_up_account.getText().toString();
        if (account.isEmpty()) {
            ShowMessage.showMessage(this, "手机号不能为空");
        } else if (!account.matches(RegDefine.PHONE_NUMBER_REG)) {
            ShowMessage.showMessage(this, "手机号格式不正确");
        } else {
            CMServerAccountProtocol.request_register_sms(this, account, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    ResponseCMSNormal res = JSON.parseObject(responseString, ResponseCMSNormal.class);
                    if (res.getCode() == CodeDefine.SUCCESS_DONE) {
                        ShowMessage.showMessage(SignUpActivity.this, "已发送验证码");
                    }
                }
            });
        }
    }

    private void smsRegister() {
        String account = edit_text_sign_up_account.getText().toString();
        String sms_code = edit_text_sign_up_sms_code.getText().toString();
        String password = edit_text_sign_up_new_password.getText().toString();
        if (account.isEmpty()) {
            ShowMessage.showMessage(this, "手机号不能为空");
        } else if (!account.matches(RegDefine.PHONE_NUMBER_REG)) {
            ShowMessage.showMessage(this, "手机号格式不正确");
        } else if (sms_code.isEmpty()) {
            ShowMessage.showMessage(this, "短信验证码不能为空");
        } else if (!sms_code.matches(RegDefine.SMS_CODE_REG)) {
            ShowMessage.showMessage(this, "短信验证码格式不正确");
        } else if (password.isEmpty()) {
            ShowMessage.showMessage(this, "密码不能为空");
        } else if (!password.matches(RegDefine.PASSWORD_REG)) {
            ShowMessage.showMessage(this, "密码格式不正确");
        } else {
            CMServerAccountProtocol.sms_register(this, account, password, sms_code, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int i, Header[] headers, String s, Throwable throwable) {

                }

                @Override
                public void onSuccess(int i, Header[] headers, String s) {
                    ResponseCMSNormal res = JSON.parseObject(s, ResponseCMSNormal.class);
                    if (res.getCode() == CodeDefine.SUCCESS_DONE) {
                        login();
                    }
                }
            });
        }
    }

    private void login() {
        CMServerAccountProtocol.login(this, edit_text_sign_up_account.getText().toString(), edit_text_sign_up_new_password.getText().toString(), "123456", new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String s) {
                ResponseCMSNormal res = JSON.parseObject(s, ResponseCMSNormal.class);
                if (res.getCode() == CodeDefine.SUCCESS_DONE) {
                    saveAccountInfo();
                    nextActivity = ActivityEnum.MAIN_ACTIVITY;
                    next();
                    finish();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String s, Throwable throwable) {
            }
        });
    }

    /**
     * 保存用户账户信息 登陆成功后调用
     */
    private void saveAccountInfo() {
        SharedPreferenceHelper.put(this, GlobalDefine.SavedAccount, edit_text_sign_up_account.getText().toString());
        SharedPreferenceHelper.put(this, GlobalDefine.SavedPassword, edit_text_sign_up_new_password.getText().toString());
    }

}
