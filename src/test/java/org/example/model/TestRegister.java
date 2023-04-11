package org.example.model;


import io.qameta.allure.junit4.DisplayName;
import org.example.model.api.ClearingUser;
import org.example.model.api.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;


public class TestRegister {
    private final String NAME = "SlavaTestRegister";
    private final String EMAIL = "SlavaTestRegister@ya.ru";
    private final String WRIGHT_PASSWORD = "SlavaTestRegister";
    private final String WRONG_PASSWORD = "aaa";
    public ClearingUser clearingUser;
    public String token;
    User user = new User(EMAIL, WRIGHT_PASSWORD, NAME);
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Проверка успешности регистрации, если после регистрации есть надпись 'Вход', то регистрация успешна")
    public void registerWithRightPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputName(NAME);
        registerPage.inputEmail(EMAIL);
        registerPage.inputPassword(WRIGHT_PASSWORD);
        registerPage.clickRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.entryIsPresent();
        assertTrue(loginPage.entryIsPresent());
    }

    @Test
    @DisplayName("Проверка невозможности регистрации с невалидным паролем")
    public void registerWithWrongPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputName(NAME);
        registerPage.inputEmail(EMAIL);
        registerPage.inputPassword(WRONG_PASSWORD);
        registerPage.clickRegisterButton();
        assertTrue(registerPage.incorrectPasswordIsPresent());
    }

    @After
    public void teardown() {
        driver.quit();
        // удалить созданного пользователя
        clearingUser = new ClearingUser();
        token = clearingUser.loginUser(user).then().extract().path("accessToken");
        if (token != null) {
            clearingUser.deleteUser(token);
        }
    }
}
