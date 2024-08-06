package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.AllureLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Grazie  {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(Grazie.class));

    // private final Logger LOG = LoggerFactory.getLogger(Grazie.class);
    WebDriver driver;

    @FindBy(css = "[aria-label='Play video']")
    private WebElement playVideoButton;

    @FindBy(css = "[href='/ai/#plans-and-pricing']")
    private WebElement tafifButton;

    @FindBy(css = "[aria-label='Open language selection']")
    private WebElement languageButtonAbove;

    @FindBy(xpath = "//span[contains(text(),'Deutsch')]")
    private WebElement DeutschButton;

    @FindBy(css = "p.jb-offset-top-sm-24")
    private WebElement textInPage;

    @FindBy(css = "[data-test='site-logo']")
    private WebElement mainPageButton;

    @FindBy(css = "[href='/store/']")
    private WebElement storeButton;

    public Boolean checkIfPlayVideoButtonIsClickable() {
        LOG.info("Проверка активности кнопки запуска видео");
        return playVideoButton.isEnabled();
    }

    public Grazie(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void tafifButtonClick() {
        tafifButton.click();
        LOG.info("Перешли на страницу тарифа");
    }

    public void switchToStoreTab(int num) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num - 1));
    }

    public String languageButtonAboveClick() {
        languageButtonAbove.click();
        LOG.info("Нажали кнопку смены языка сверху");
        DeutschButton.click();
        LOG.info("Нажали кнопку немецкого языка");
        return textInPage.getText();
    }

    public void mainPageButtonClick() {
        mainPageButton.click();
        LOG.info("Переход на главную страницу");
    }

    public void storeButtonClick() {
        storeButton.click();
        LOG.info("Переход в магазин");
    }




}
