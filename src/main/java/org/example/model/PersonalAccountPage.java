package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private final WebDriver driver;


    //локатор кнопки "Выйти"
    private final By logoutAccountLoc = By.xpath(".//*[text()='Выход']");
    //локатор с именем в личном аккаунте
    private final By namePersonalAccountLoc = By.xpath(".//*[text()='Имя']/../input");
    //кнопка "Конструктор"
    private final By konstructorButtonLoc = By.xpath(".//*[text()='Конструктор']");
    //логотип "Stellar Burgers"
    private final By logoStellarLoc = By.xpath(".//*[text()='Конструктор']");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //получить значение имени в личном кабинете
    public String getStringName() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(namePersonalAccountLoc)).getAttribute("value");
        return driver.findElement(namePersonalAccountLoc).getAttribute("value");
    }

    //нажать на кнопку "Выйти"
    public void clickLogoutButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(logoutAccountLoc)).click();
    }

    //нажать на кнопку "Конструктор"
    public void clickKonstruktorButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(konstructorButtonLoc)).click();
    }

    //нажать на логотип "StellarBurgers"
    public void clickLogo() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(logoStellarLoc)).click();
    }


}


