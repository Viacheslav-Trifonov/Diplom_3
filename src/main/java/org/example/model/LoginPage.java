package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    //надпись "Вход"
    private final By entryTitleLoc = By.xpath(".//*[text()='Вход']");
    //поле "Почта"
    private final By inputEmailLoc = By.xpath(".//*[text()='Email']/../input");
    //поле "Пароль"
    private final By inputPasswordLoc = By.xpath(".//*[text()='Пароль']/../input");
    //кнопка "Войти"
    private final By entryButtonLoc = By.xpath(".//*[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввести "Почта"
    public void inputEmail(String email) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(inputEmailLoc)).sendKeys(email);
    }

    //Ввести "Пароль"
    public void inputPassword(String password) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(inputPasswordLoc)).sendKeys(password);
    }

    //проверка видимости надписи "Вход"
    public boolean entryIsPresent() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(entryTitleLoc));
        return driver.findElement(entryTitleLoc).isDisplayed();
    }

    //нажать на кнопку "Войти"
    public void clickEntryButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(entryButtonLoc)).click();
    }


}


