package autotest.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public String getUserNAme() {
        return driver.findElement(By.id("PH_user-email")).getText();
    }

    public String sendMail(String to, String theme, String body) {
        driver.findElement(By.id("b-toolbar__left")).findElement(By.className("b-toolbar__btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-toolbar__right")));
        driver.findElement(By.xpath("//textarea[@data-original-name='To']")).sendKeys(to);
        driver.findElement(By.xpath("//input[@class='b-input']")).sendKeys(theme);
        //driver.findElement(By.xpath("//iframe[@tabindex='10']")).sendKeys(body);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='10']")));
        driver.switchTo().activeElement().sendKeys(body);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("b-toolbar__right")).findElement(By.xpath("//div[@data-name='send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-compose__sent")));
        return driver.findElement(By.id("b-compose__sent")).findElement(By.xpath("//div[@class='message-sent__title']")).getText();
    }
}
