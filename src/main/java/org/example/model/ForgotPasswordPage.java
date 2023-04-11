package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    private final WebDriver driver;

    //локатор кнопки "Вспомнили пароль? Войти"
    private final By entryButtonLoc = By.xpath(".//*[text()='Войти']");
    //локатор кнопки "Личный кабинет"

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //нажать на кнопку "Вспомнили пароль? Войти"
    public void clickEntryButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(entryButtonLoc)).click();
    }
}


