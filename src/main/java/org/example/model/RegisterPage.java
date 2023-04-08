package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;

    //поле "Имя"
    private final By inputNameLoc = By.xpath(".//*[text()='Имя']/../input");
    //надпись "Некорректный пароль"
    private final By incorrectPasswordLoc = By.xpath(".//*[text()='Некорректный пароль']");
    //поле "Почта"
    private final By inputEmailLoc = By.xpath(".//*[text()='Email']/../input");
    //поле "Пароль"
    private final By inputPasswordLoc = By.xpath(".//*[text()='Пароль']/../input");
    //кнопка "Зарегестрироваться"
    private final By registerButtonLoc = By.xpath(".//*[text()='Зарегистрироваться']");
    //кнопка "Уже зарегистрированы? Войти"
    private final By entryButtonLoc = By.xpath(".//*[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввести "Имя"
    public void inputName(String name) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(inputNameLoc)).sendKeys(name);
    }

    //Ввести "Почта"
    public void inputEmail(String email) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(inputEmailLoc)).sendKeys(email);
    }

    //Ввести "Пароль"
    public void inputPassword(String password) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(inputPasswordLoc)).sendKeys(password);
    }

    //нажать на кнопку "Регистрация"
    public void clickRegisterButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(registerButtonLoc)).click();
    }

    //нажать на кнопку "Уже зарегистрированы? Войти"
    public void clickEntryButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(entryButtonLoc)).click();
    }

    //проверка видимости надписи "Некорректный пароль"
    public boolean incorrectPasswordIsPresent() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordLoc));
        return driver.findElement(incorrectPasswordLoc).isDisplayed();
    }

}


