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
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().clickTab();
        //app.getContact().saveContact();
    }
}
