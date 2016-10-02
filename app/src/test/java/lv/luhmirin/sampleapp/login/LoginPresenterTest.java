package lv.luhmirin.sampleapp.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginPresenterTest {

    @Mock LoginViewContract mockContract;

    LoginPresenter subject;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        subject = new LoginPresenter(mockContract);
    }

    @Test
    public void proceedLogin_whenCorrectInput() throws Exception {
        subject.login("a@b.c", "1234");

        verify(mockContract).cleanErrors();
        verify(mockContract).loginSuccess();

    }

    @Test
    public void showError_whenEmptyEmail() throws Exception {
        subject.login("", "1234");

        verify(mockContract, never()).loginSuccess();
        verify(mockContract).noEmailError();
    }

    @Test
    public void showError_whenEmptyPassword() throws Exception {
        subject.login("a@b.c", "");

        verify(mockContract, never()).loginSuccess();
        verify(mockContract).noPasswordError();
    }

    @Test
    public void showError_whenNotAnEmail() throws Exception {
        subject.login("aaaaaa", "1234");

        verify(mockContract, never()).loginSuccess();
        verify(mockContract).invalidEmailError();
    }

    @Test
    public void showError_whenEmailTooShort() throws Exception {
        subject.login("a@a", "1233");

        verify(mockContract, never()).loginSuccess();
        verify(mockContract).invalidEmailError();
    }

    @Test
    public void showError_whenPasswordTooShort() throws Exception {
        subject.login("a@a.a", "123");

        verify(mockContract, never()).loginSuccess();
        verify(mockContract).invalidPasswordError();
    }
}