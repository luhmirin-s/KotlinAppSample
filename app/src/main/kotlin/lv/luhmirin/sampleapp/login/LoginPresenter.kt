package lv.luhmirin.sampleapp.login

internal class LoginPresenter(private val contract: LoginViewContract) {

    fun login(email: String, password: String) {
        contract.cleanErrors()

        if (email.checkEmail() && password.checkPassword()) {
            contract.loginSuccess()
        }
    }

    private fun String.checkEmail(): Boolean {
        if (this.isEmpty()) {
            contract.noEmailError()
            return false
        } else if (this.isNotValidEmail()) {
            contract.invalidEmailError()
            return false
        }
        return true
    }

    private fun String.isNotValidEmail() = !this.contains("@") || this.length < 5


    private fun String.checkPassword(): Boolean {
        if (this.isEmpty()) {
            contract.noPasswordError()
            return false
        } else if (this.isNotValidPassword()) {
            contract.invalidPasswordError()
            return false
        }
        return true
    }

    private fun String.isNotValidPassword() = this.length < 4

}
