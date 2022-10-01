import models.Contact;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@"));
        }
    }


    @Test
    public void AddContact(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Lisa"+i)
                .lastName("Boi")
                .phone("12345"+i)
                .email("lisa@gmail.com")
                .address("Israel")
                .description("My best friend")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().clickTab();
        app.helperContact().saveContact();
        app.helperContact().pause(2000);
        app.helperContact().openContactForm();
    }
    @Test
    public void AddContact2(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Lisa"+i)
                .lastName("Boi")
                .phone("12345"+i)
                .email("lisa@gmail.com")
                .address("Israel")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().clickTab();

    }
}
