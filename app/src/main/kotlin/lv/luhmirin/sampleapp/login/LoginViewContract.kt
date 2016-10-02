package lv.luhmirin.sampleapp.login

internal interface LoginViewContract {

    fun cleanErrors()

    fun noEmailError()

    fun noPasswordError()

    fun invalidEmailError()

    fun invalidPasswordError()

    fun loginSuccess()

}
