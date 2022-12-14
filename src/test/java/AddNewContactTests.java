import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {
    @BeforeMethod(enabled = false)
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@"));
        }
    }


    @Test(enabled = false)
    public void AddContact(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Lisa"+i)
                .lastName("Boi")
                .phone("12345"+i)
                .email("lisa" + i +"@gmail.com")
                .address("Israel")
                .description("My best friend")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactAllForm(contact);
        app.helperContact().clickTab();
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().inContactAddedByPhone(contact.getPhone()));
    }
    @Test(enabled = false)
    public void AddContact2(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Lisa"+i)
                .lastName("Boi")
                .phone("12345"+i)
                .email("lisa" + i +"@gmail.com")
                .address("Israel")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactAllForm(contact);
        app.helperContact().clickTab();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().inContactAddedByPhone(contact.getPhone()));

    }

    @Test(dataProvider = "contactValidData",dataProviderClass = DataProviderContact.class,enabled = false)
    public void AddContactDP(Contact contact){
        logger.info("The test used contact : " +contact.toString());
        app.helperContact().openContactForm();
        app.helperContact().fillContactAllForm(contact);
        app.helperContact().clickTab();
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().inContactAddedByPhone(contact.getPhone()));
    }
    @Test(enabled = false)
    public void AddNewContactWrongName(){

        Contact contact = Contact.builder()
                .name("Lisa")
                .phone("12345678904568")
                .email("lis@gmail.com")
                .address("Israel")
                .description("Friend")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactAllForm(contact);
        app.helperContact().clickTabNegativ();

        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());


    }
}
