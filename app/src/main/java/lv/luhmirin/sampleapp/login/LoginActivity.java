package lv.luhmirin.sampleapp.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lv.luhmirin.sampleapp.R;
import lv.luhmirin.sampleapp.list.ListActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginViewContract {

    // UI references.
    @BindView(R.id.login_email) protected EditText emailInput;
    @BindView(R.id.login_email_layout) protected TextInputLayout emailLayout;
    @BindView(R.id.login_password) protected EditText passwordInput;
    @BindView(R.id.login_password_layout) protected TextInputLayout passwordLayout;


    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.login_sign_in_button)
    public void onLoginClicked() {
        String email = nullToEmpty(emailInput.getText());
        String password = nullToEmpty(passwordInput.getText());
        presenter.login(email, password);

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @NonNull
    private String nullToEmpty(@Nullable Editable text) {
        return text == null ? "" : text.toString();
    }

    @Override
    public void cleanErrors() {
        emailLayout.setError(null);
        passwordLayout.setError(null);
    }

    @Override
    public void noEmailError() {
        emailLayout.setError(getString(R.string.error_field_required));
    }

    @Override
    public void noPasswordError() {
        passwordLayout.setError(getString(R.string.error_field_required));
    }

    @Override
    public void invalidEmailError() {
        emailLayout.setError(getString(R.string.error_invalid_email));
    }

    @Override
    public void invalidPasswordError() {
        passwordLayout.setError(getString(R.string.error_invalid_password));
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, ListActivity.class));
    }
}

