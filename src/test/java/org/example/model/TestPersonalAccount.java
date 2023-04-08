package org.example.model;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestPersonalAccount {
    private final String NAME = "SlavaTestLogin";
    private final String EMAIL = "SlavaTestLogin@ya.ru";
    private final String PASSWORD = "SlavaTestLogin";
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    @DisplayName("Проверка перехода по клику в личный кабинет")
    public void goToPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        assertTrue(mainPage.placeOrderIsPresent());
        mainPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.getStringName();
        assertEquals(personalAccountPage.getStringName(), NAME);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета по кнопке 'Конструктор'")
    public void goToKonstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        assertTrue(mainPage.placeOrderIsPresent());
        mainPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickKonstruktorButton();
        assertTrue(mainPage.makeBurgersIsPresent());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета по логотипу 'Stellar Burgers'")
    public void goToLogoStellar() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        assertTrue(mainPage.placeOrderIsPresent());
        mainPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogo();
        assertTrue(mainPage.makeBurgersIsPresent());
    }

    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    public void logoutPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickEntryButton();
        assertTrue(mainPage.placeOrderIsPresent());
        mainPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();
        loginPage.entryIsPresent();
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
