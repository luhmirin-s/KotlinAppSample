package lv.luhmirin.sampleapp.login;

interface LoginViewContract {

    void cleanErrors();

    void noEmailError();

    void noPasswordError();

    void invalidEmailError();

    void invalidPasswordError();

    void loginSuccess();

}
