import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess() {
        System.out.println(System.currentTimeMillis());
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("evnikel" + i + "@gmail.com").withPassword("Elena1234$@");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }


}
