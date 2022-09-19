import models.User;
import org.testng.Assert;
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
    public void loginSuccessModel() {
//User user =new User();
//        user.setEmail("noa");
//        user.setPassword("Nnoa");

        User user =new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@");

        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().sabmitLogin();
        //app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());


    }


    @Test
    public void loginSuccess() {

        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("evnikel@gmail.com" ,"Elena1234$@");
        app.getHelperUser().sabmitLogin();
        //app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());


    }
    @Test
    public void loginNegativeWrongEmailFormat() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().withEmail("evnikelgmail.com").withPassword("Elena1234$@"));
        app.getHelperUser().sabmitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }

    @Test
    public void loginNegativeWrongPasswordFormat() {


    }

}
