import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@"));
            logger.info("User login data: email evnikel@gmail.com & password Elena1234$@ ");
        }

        app.helperContact().AddCountContacts();

    }

    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.helperContact().removeFirstContact(),1);
        logger.info("Assert removeFirstContact ----> CountAfter");

    }

    @Test
    public void removeAllContacts(){
        app.helperContact().removeAllContacts();
        Assert.assertTrue(app.helperContact().isNoContactsHere());
        logger.info("Assert -removeAllContacts----> NoContactsHere ");


    }
}
