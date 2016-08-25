package com.xshen.databindingguide.samples.loginform;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.xshen.databindingguide.BR;

/**
 * 说明：提交的表单
 *
 * @author shengj
 * @version 创建时间：2016-08-01 13:47
 */
public class LoginFormBean extends BaseObservable {
    private String email;
    private String password;
    private emailChangeListener emailChangeListener;

    public interface emailChangeListener {
        void onEmailChange(String email);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
        emailChangeListener.onEmailChange(email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public LoginFormBean.emailChangeListener getEmailChangeListener() {
        return emailChangeListener;
    }

    public void setEmailChangeListener(LoginFormBean.emailChangeListener emailChangeListener) {
        this.emailChangeListener = emailChangeListener;
    }
}
