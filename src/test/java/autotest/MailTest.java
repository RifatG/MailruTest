package autotest;

import autotest.HomePage.LoginPage;
import autotest.HomePage.MailPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MailTest extends WebdriverSetting {

    private String userName = "user@mail.ru";                   //Почтовый адрес для авторизации
    private String userPassword = "********";                   //Пароль для авторизации
    private String toUserName = "user@*****";                   //Почтовый адрес получателя
    private String themeOfMail = "theme";                       //Тема письма
    private String bodyOfMail = "body\nbody\nbody";             //Содержание письма
    private MailPage mailPage;
    private LoginPage loginPage;

    @Test(priority = 1)
    public void loginTest(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mailPage = loginPage.login(userName, userPassword);
        Assert.assertEquals(userName, mailPage.getUserNAme());

    }

    @Test(priority = 2)
    public void sendMail(){
        String result = mailPage.sendMail(toUserName, themeOfMail, bodyOfMail);
        Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие", result);
    }

}
