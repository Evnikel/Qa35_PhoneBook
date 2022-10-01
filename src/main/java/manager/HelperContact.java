package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase {


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        pause(500);
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"),contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"),contact.getAddress());
        type(By.cssSelector("[placeholder='description']"),contact.getDescription());
    }

    public void saveContact() {
        click(By.cssSelector("button b"));
    }

    public void clickTab() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.ENTER);

    }
}
