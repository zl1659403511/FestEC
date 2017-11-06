package com.abc.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.abc.latte.delegate.LetteDelegate;
import com.abc.latte.ec.R;
import com.abc.latte.ec.R2;
import com.abc.latte.net.RestClient;
import com.abc.latte.net.callback.ISuccess;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2017/8/10.
 */

public class SignUpDelegate extends LetteDelegate {
    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_pwd)
    TextInputEditText mPwd = null;
    @BindView(R2.id.edit_sign_up_re_pwd)
    TextInputEditText mRepwd = null;
    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener= (ISignListener)activity;
        }
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        /*checkForm();*/
        RestClient.builder()
                .url("user_profile.php")
                .params("name", mName.getText().toString().trim())
                .params("password", mPwd.getText().toString().trim())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String resonse) {
                        Logger.json(resonse);
                     SignHandler.onSingUp(resonse,mISignListener);

                    }
                })
                .build()
                .post();

    }

    private boolean checkForm() {
        final String name = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String phone = mPhone.getText().toString().trim();
        final String pwd = mPwd.getText().toString().trim();
        final String repwd = mRepwd.getText().toString().trim();
        boolean isPass = true;
        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }
       /* if (email.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
        } else {
            mEmail.setError(null);
        }*/

        if (phone.isEmpty() || phone.length() != 11) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 6) {
            mPwd.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPwd.setError(null);
        }

        if (repwd.isEmpty() || repwd.length() < 6 || !(repwd.equals(pwd))) {
            mRepwd.setError("密码验证错误");
            isPass = false;
        } else {
            mRepwd.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {

    }
}
