package org.example.model;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;


public class TestLogin {

    private final String EMAIL = "SlavaTestLogin@ya.ru";
    private final String PASSWORD = "SlavaTestLogin";
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginUsingButtonOnMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEntryAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        assertTrue(mainPage.placeOrderIsPresent());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginUsingButtonPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        assertTrue(mainPage.placeOrderIsPresent());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginUsingRegistrationForm() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickEntryButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.placeOrderIsPresent());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginUsingForgotRegistrationForm() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickEntryButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.placeOrderIsPresent());
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
