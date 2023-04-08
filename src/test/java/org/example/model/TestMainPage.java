package org.example.model;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;


public class TestMainPage {
    private final String NAME = "SlavaTestLogin";
    private final String EMAIL = "SlavaTestLogin@ya.ru";
    private final String PASSWORD = "SlavaTestLogin";
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу: Начинки")
    public void goToFilling() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFilling();
        assertTrue(mainPage.fillingIsCurrent());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу: Булки")
    public void goToBun() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauce();
        assertTrue(mainPage.sauceIsCurrent());
        Thread.sleep(1000);
        mainPage.clickBun();
        assertTrue(mainPage.bunIsCurrent());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу: Соусы")
    public void goToSauce() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauce();
        assertTrue(mainPage.sauceIsCurrent());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
