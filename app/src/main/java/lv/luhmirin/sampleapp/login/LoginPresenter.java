package lv.luhmirin.sampleapp.login;

import android.support.annotation.NonNull;

class LoginPresenter {

    private final LoginViewContract contract;

    LoginPresenter(@NonNull LoginViewContract contract) {
        this.contract = contract;
    }

    void login(@NonNull String email, @NonNull String password) {
        contract.cleanErrors();

        if (checkEmail(email) && checkPassword(password)) {
            contract.loginSuccess();
        }
    }


    private boolean checkEmail(@NonNull String email) {
        if (email.isEmpty()) {
            contract.noEmailError();
            return false;
        } else if (notValidEmail(email)) {
            contract.invalidEmailError();
            return false;
        }
        return true;
    }

    private boolean notValidEmail(@NonNull String email) {
        return !email.contains("@") || email.length() < 5;
    }


    private boolean checkPassword(@NonNull String password) {
        if (password.isEmpty()) {
            contract.noPasswordError();
            return false;
        } else if (notValidPassword(password)) {
            contract.invalidPasswordError();
            return false;
        }
        return true;
    }

    private boolean notValidPassword(@NonNull String password) {
        return password.length() < 4;
    }
}
