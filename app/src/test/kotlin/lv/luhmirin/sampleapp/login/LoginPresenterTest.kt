package lv.luhmirin.sampleapp.login

import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class LoginPresenterTest {

    @Mock internal lateinit var mockContract: LoginViewContract

    internal lateinit var subject: LoginPresenter

    @Before
    fun setUp() {
        initMocks(this)

        subject = LoginPresenter(mockContract!!)
    }

    @Test
    fun proceedLogin_whenCorrectInput() {
        subject.login("a@b.c", "1234")

        Verify on mockContract that mockContract.cleanErrors() was called
        Verify on mockContract that mockContract.loginSuccess() was called
    }

    @Test
    fun showError_whenEmptyEmail() {
        subject.login("", "1234")

        1 `should not equal` 3

        Verify on mockContract that mockContract.cleanErrors() was called
        Verify on mockContract that mockContract.noEmailError() was called
        VerifyNoFurtherInteractions on mockContract
    }

    @Test
    fun showError_whenEmptyPassword() {
        subject.login("a@b.c", "")

        Verify on mockContract that mockContract.cleanErrors() was called
        Verify on mockContract that mockContract.noPasswordError() was called
        VerifyNoFurtherInteractions on mockContract
    }

    @Test
    fun showError_whenNotAnEmail() {
        subject.login("aaaaaa", "1234")

        Verify on mockContract that mockContract.cleanErrors() was called
        Verify on mockContract that mockContract.invalidEmailError() was called
        VerifyNoFurtherInteractions on mockContract
    }

    @Test
    fun showError_whenEmailTooShort() {
        subject.login("a@a", "1233")

        Verify on mockContract that mockContract.cleanErrors() was called
        Verify on mockContract that mockContract.invalidEmailError() was called
        VerifyNoFurtherInteractions on mockContract
    }

    @Test
    fun showError_whenPasswordTooShort() {
        subject.login("a@a.a", "123")

        Verify on mockContract that mockContract.cleanErrors() was called
        Verify on mockContract that mockContract.invalidPasswordError() was called
        VerifyNoFurtherInteractions on mockContract
    }
}