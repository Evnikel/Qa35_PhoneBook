import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        logger.info("Start checking authorization");
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Test was needed in logout ");
        }else {
            logger.info("Test was not needed in logout ");
        }
    }

    @Test
    public void loginSuccessModel() {


        User user =new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@");

        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        //app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());


    }
    @Test(dataProvider = "dataModelUser",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Login scenario success was used data"+user.toString());
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("Test start loginSuccessModels - run with username and password"   +user.toString());
        app.getHelperUser().submitLogin();
        //app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());


    }


    @Test(dataProvider = "datalogin", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Test LoginTests start with name ----->email   :"+ email+" & password  :" +password);
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        logger.info("User login data: email evnikel@gmail.com & password Elena1234$@ ");
        app.getHelperUser().submitLogin();
        //app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info(" Assert check is Sign Out button Present");


    }
    @Test(enabled = false)
    public void NegativeWrongEmailFormat() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().withEmail("evnikelgmail.com").withPassword("Elena1234$@"));
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());


    }

}
