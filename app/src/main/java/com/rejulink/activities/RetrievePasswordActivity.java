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
import com.loopj.android.http.TextHttpResponseHandler;
import com.rejulink.R;
import com.rejulink.protocols.CMServerAccountProtocol;
import com.rejulink.protocols.bean.ResponseCMSNormal;
import com.rejulink.utils.CodeDefine;
import com.rejulink.utils.GlobalDefine;
import com.rejulink.utils.RegDefine;
import com.rejulink.utils.SharedPreferenceHelper;

import org.apache.http.Header;

/**
 * Created by danielzhang on 15/7/1.
 */
public class RetrievePasswordActivity extends BaseActivity implements OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TextView text_view_title_bar_text_back;
    private EditText edit_text_retrieve_password_account;
    private EditText edit_text_retrieve_password_sms_code;
    private EditText edit_text_retrieve_password_new_password;
    private Button button_retrieve_password_sms_code;
    private Button button_retrieve_password_done;
    private CheckBox check_box_layout_retrieve_password_new_password;

    public static void lunchActivity(Context context) {
        context.startActivity(new Intent(context, RetrievePasswordActivity.class));
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_retrieve_password);
        text_view_title_bar_text_back = (TextView) findViewById(R.id.text_view_title_bar_text_back);
        text_view_title_bar_text_back.setText(R.string.title_activity_retrieve_password);
        text_view_title_bar_text_back.setOnClickListener(this);
        edit_text_retrieve_password_account = (EditText) findViewById(R.id.edit_text_retrieve_password_account);
        edit_text_retrieve_password_sms_code = (EditText) findViewById(R.id.edit_text_retrieve_password_sms_code);
        edit_text_retrieve_password_new_password = (EditText) findViewById(R.id.edit_text_retrieve_password_new_password);
        button_retrieve_password_sms_code = (Button) findViewById(R.id.button_retrieve_password_sms_code);
        button_retrieve_password_sms_code.setOnClickListener(this);
        button_retrieve_password_done = (Button) findViewById(R.id.button_retrieve_password_done);
        button_retrieve_password_done.setOnClickListener(this);
        check_box_layout_retrieve_password_new_password = (CheckBox) findViewById(R.id.check_box_layout_retrieve_password_new_password);
        check_box_layout_retrieve_password_new_password.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_view_title_bar_text_back:
                finish();
                break;
            case R.id.button_retrieve_password_sms_code:
                requestResetPasswordByPhone();
                break;
            case R.id.button_retrieve_password_done:
                resetPassword();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            edit_text_retrieve_password_new_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            edit_text_retrieve_password_new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        Selection.setSelection(edit_text_retrieve_password_new_password.getText(), edit_text_retrieve_password_new_password.getText().length());
    }

    private void requestResetPasswordByPhone() {
        String account = edit_text_retrieve_password_account.getText().toString();
        if (account == null || account.isEmpty()) {
            return;
        } else if (!account.matches(RegDefine.PHONE_NUMBER_REG)) {
            return;
        }
        // 请求验证码
        CMServerAccountProtocol.request_reset_password_by_phone(this, account, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {

            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {

            }
        });
    }

    private void resetPassword() {
        String account = edit_text_retrieve_password_account.getText().toString();
        String sms_code = edit_text_retrieve_password_sms_code.getText().toString();
        String password = edit_text_retrieve_password_new_password.getText().toString();
        if (account == null || account.isEmpty()) {
            return;
        } else if (!account.matches(RegDefine.PHONE_NUMBER_REG)) {
            return;
        } else if (sms_code == null || sms_code.isEmpty()) {
            return;
        } else if (!sms_code.matches(RegDefine.SMS_CODE_REG)) {
            return;
        } else if (password == null || password.isEmpty()) {
            return;
        } else if (!password.matches(RegDefine.PASSWORD_REG)) {
            return;
        }
        // 请求修改密码
        CMServerAccountProtocol.reset_password(this, account, password, sms_code, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {

            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                ResponseCMSNormal res = JSON.parseObject(s, ResponseCMSNormal.class);
                if (res.getCode() == CodeDefine.SUCCESS_DONE) {
                    clearOldPassword();
                    nextActivity = SIGN_IN_ACTIVITY;
                    next();
                    finish();
                }
            }
        });
    }

    //虽然没有太大必要
    private void clearOldPassword(){
        SharedPreferenceHelper.remove(this, GlobalDefine.SavedPassword);
    }
}
