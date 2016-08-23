package com.xshen.databindingguide.samples.loginform;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.LoginBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private LoginFormBean formBean = new LoginFormBean();
    private ArrayAdapter<String> mAdapter;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String[] EMAIL_SUFFIX = new String[]{
            "@163.com", "@126.com", "@yeah.net", "@188.com", "@vip.163.com",
            "@vip.126.com", "@vip.188.com"
    };

    private List<String> emailArray = new ArrayList<>(Arrays.asList(EMAIL_SUFFIX));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setFormData(formBean);

        mAdapter = new ArrayAdapter<>(this, R.layout.item_dropdown_line, emailArray);
        binding.editEmail.setAdapter(mAdapter);
        formBean.setEmailChangeListener(new LoginFormBean.emailChangeListener() {
            @Override
            public void onEmailChange(String email) {
                int index = email.indexOf("@");
                String subMail = email;
                if (index != -1) {
                    subMail = email.substring(0, index);
                }
                mAdapter.clear();
                for (String aEMAIL_SUFFIX : EMAIL_SUFFIX) {
                    mAdapter.add(subMail + aEMAIL_SUFFIX);
                }
            }
        });

    }

    public static boolean isValidEmail(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            return pattern.matcher(text).matches();
        } else {
            return false;
        }
    }

    public void formSubmit(View view) {
        Toast.makeText(view.getContext(),
                String.format("Email: %s, Password: %s", formBean.getEmail(), formBean.getPassword()),
                Toast.LENGTH_SHORT).show();
    }
}
