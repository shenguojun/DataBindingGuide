package com.xshen.databindingguide.samples.loginform.nodatabinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.xshen.databindingguide.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LoginNoDatabindingActivity extends AppCompatActivity implements View.OnClickListener {
    private LoginFormBeanNoDatabinding formBean = new LoginFormBeanNoDatabinding();
    private ArrayAdapter<String> adapter;
    private AutoCompleteTextView editEmail;
    private EditText editPass;
    private ImageView imgEmailCheck;
    private Button submitButton;

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
        setContentView(R.layout.activity_login_nodatabinding);
        editEmail = (AutoCompleteTextView) findViewById(R.id.edit_email);
        editPass = (EditText) findViewById(R.id.edit_pass);
        editPass.addTextChangedListener(new TextWatcher() {
            private String pass;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pass = charSequence.toString();
                formBean.setPassword(pass);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                updateSubmitButtonState();
            }
        });
        imgEmailCheck = (ImageView) findViewById(R.id.img_email_check);
        submitButton = (Button) findViewById(R.id.login_button);
        submitButton.setOnClickListener(this);
        adapter = new ArrayAdapter<>(this, R.layout.item_dropdown_line, emailArray);
        editEmail.setAdapter(adapter);
        editEmail.addTextChangedListener(new TextWatcher() {
            private String email;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email = charSequence.toString();
                formBean.setEmail(email);
                int index = email.indexOf("@");
                String subMail = email;
                if (index != -1) {
                    subMail = email.substring(0, index);
                }
                adapter.clear();
                for (String aEMAIL_SUFFIX : EMAIL_SUFFIX) {
                    adapter.add(subMail + aEMAIL_SUFFIX);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                updateSubmitButtonState();
                updateEmailCheckImg();
            }
        });

    }

    private void updateEmailCheckImg() {
        if (TextUtils.isEmpty(formBean.getEmail())) {
            imgEmailCheck.setVisibility(View.GONE);
        } else if (isValidEmail(formBean.getEmail())) {
            imgEmailCheck.setVisibility(View.VISIBLE);
            imgEmailCheck.setBackgroundResource(R.drawable.ic_done_green_200_18dp);
        } else {
            imgEmailCheck.setVisibility(View.VISIBLE);
            imgEmailCheck.setBackgroundResource(R.drawable.ic_error_outline_red_300_18dp);
        }
    }

    private void updateSubmitButtonState() {
        if (isValidEmail(formBean.getEmail()) && !TextUtils.isEmpty(formBean.getPassword())) {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }

    public static boolean isValidEmail(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            return pattern.matcher(text).matches();
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                Toast.makeText(view.getContext(),
                        String.format("Email: %s, Password: %s", formBean.getEmail(), formBean.getPassword()),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}