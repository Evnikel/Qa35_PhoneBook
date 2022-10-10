package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        pause(500);
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactAllForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveContact() {
        click(By.cssSelector("button b"));
    }

    public void clickTab() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.ENTER);

    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }

        return false;
    }

    public boolean inContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }

        return false;

    }

    public boolean isAddPageStillDisplayed() {
        return wd.findElements(By.cssSelector("a.active[href='/add']")).size() > 0;
    }

//    public int removeOneContact() {
//        int before =countOfContact();
//
//        if(!isCountListEmpty()) {
//            removeContact();
//        }
//
//        int after =countOfContact();
//        return before-after;
//    }
//
//    private boolean isCountListEmpty() {
//        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
//    }
//
//    private void removeContact() {
//        click(By.cssSelector(".contact-item_card__2SOIM"));
//        click(By.xpath("//button[text()='Remove']"));
//        pause(500);
//    }
//
//    private int countOfContact() {
//        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
//    }
//
//    public void removeAllContacts() {
////        List <WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
////        for (int i = 0; i < list.size(); i++) {
////            click(By.cssSelector(".contact-item_card__2SOIM"));
////            click(By.xpath("//button[text()='Remove']"));
////            pause(500);
////        }
//
//        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
//            removeContact();
//        }
//
//
//
//    }
//
//    public boolean isNoContactHere() {
//        return new WebDriverWait(wd, Duration.ofSeconds(5))
//                .until(ExpectedConditions
//                        .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")),"No Contacts here!" ));
//    }
//
//    public void providerOfContacts() {
//
//        // check count of contacts <3 ---> add contact 3
//    }


    public int removeFirstContact() {
        int countBefore = countOfContacts();
        logger.info("Count before remove is " + countBefore);
        if (!isContactListEmpty()) {
            logger.info("List of Contact not Empty");
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            logger.info("Count after remove -1");
            pause(500);

        }

        int countAfter = countOfContacts();
        logger.info("Count after remove is " + countAfter);
        return countBefore - countAfter;
    }


    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();

    }

    private boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void removeAllContacts() {
        while (countOfContacts() != 0) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            logger.info("Count after remove is " + countOfContacts());
            pause(500);
        }
    }


    public boolean isNoContactsHere() {
        return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")), "No Contacts here!"));

    }


    public void providerOfContacts() {
        Random random = new Random();
        if(countOfContacts()<4) {
            for (int i = 0; i < 3; i++) { // Цикл for, который повторяет определенное действие нужное количество раз
                int index = random.nextInt(100) + 100;
                Contact contact = Contact.builder()
                        .name("Lisa" + index)
                        .lastName("Boi")
                        .phone("12345" + index)
                        .email("lisa" + index + "@gmail.com")
                        .address("Israel")
                        .description("My best friend")
                        .build();
                openContactForm();
                fillContactAllForm(contact);
                clickTab();
                saveContact();
                logger.info("Added Contacts" + contact.toString());
            }
        }
    }

    public void clickTabNegativ() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.ENTER);

    }
}

