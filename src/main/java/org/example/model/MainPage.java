package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;


    //локатор кнопки "Войти в аккаунт"
    private final By entryAccountLoc = By.xpath(".//*[text()='Войти в аккаунт']");
    //локатор кнопки "Личный кабинет"
    private final By personalAccountLoc = By.xpath(".//*[text()='Личный Кабинет']");
    //надпись "Оформить заказ"
    private final By placeOrderLoc = By.xpath(".//*[text()='Оформить заказ']");
    //надпись "Соберите бургер"
    private final By makeBurgersLoc = By.xpath(".//*[text()='Соберите бургер']");
    //локатор контейнера с булками
    private final By bunLoc = By.xpath(".//*[text()='Булки']/..");
    ;
    //локатор контейнера с начинками
    private final By fillingLoc = By.xpath(".//*[text()='Соусы']/..");
    //локатор контейнера с соусами
    private final By sauceLoc = By.xpath(".//*[text()='Начинки']/..");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //нажать на кнопку "Войти в аккаунт"
    public void clickEntryAccount() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(entryAccountLoc)).click();
    }

    //нажать на кнопку "Личный кабинет"
    public void clickPersonalAccount() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(personalAccountLoc)).click();
    }

    //проверка видимости надписи "Оформить заказ"
    public boolean placeOrderIsPresent() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(placeOrderLoc));
        return driver.findElement(placeOrderLoc).isDisplayed();
    }

    //проверка видимости надписи "Соберите бургер"
    public boolean makeBurgersIsPresent() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(makeBurgersLoc));
        return driver.findElement(makeBurgersLoc).isDisplayed();
    }

    //нажать на кнопку "Булки"
    public void clickBun() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(bunLoc)).click();
    }

    //нажать на кнопку "Начинки"
    public void clickFilling() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(fillingLoc)).click();
    }

    //нажать на кнопку "Соусы"
    public void clickSauce() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(sauceLoc)).click();
    }

    public boolean bunIsCurrent() {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.attributeContains(bunLoc, "class", "current"));
    }

    public boolean sauceIsCurrent() {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.attributeContains(sauceLoc, "class", "current"));
    }

    public boolean fillingIsCurrent() {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.attributeContains(fillingLoc, "class", "current"));
    }
}


