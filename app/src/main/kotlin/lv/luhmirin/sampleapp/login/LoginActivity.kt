package lv.luhmirin.sampleapp.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.IntentFor
import com.pawegio.kandroid.start
import kotlinx.android.synthetic.main.activity_login.*
import lv.luhmirin.sampleapp.R
import lv.luhmirin.sampleapp.getString
import lv.luhmirin.sampleapp.list.ListActivity
import lv.luhmirin.sampleapp.removeError
import lv.luhmirin.sampleapp.setErrorString


class LoginActivity : AppCompatActivity(), LoginViewContract {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)

        login_sign_in_button.setOnClickListener {
            val email = login_email.getString()
            val password = login_password.getString()
            presenter.login(email, password)
        }
    }

    override fun cleanErrors() {
        login_email_layout.removeError()
        login_password_layout.removeError()
    }

    override fun noEmailError() {
        login_email_layout.setErrorString(this, R.string.error_field_required)
    }

    override fun noPasswordError() {
        login_password_layout.setErrorString(this, R.string.error_field_required)
    }

    override fun invalidEmailError() {
        login_email_layout.setErrorString(this, R.string.error_invalid_email)
    }

    override fun invalidPasswordError() {
        login_password_layout.setErrorString(this, R.string.error_invalid_password)
    }

    override fun loginSuccess() {
        IntentFor<ListActivity>(this).start(this)
    }

}

