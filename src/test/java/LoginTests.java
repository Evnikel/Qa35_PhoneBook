import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
       }
    }


    @Test
    public void loginSuccess() {

        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("evnikel@gmail.com" ,"Elena1234$@");
        app.getHelperUser().sabmitLogin();


    }

}
