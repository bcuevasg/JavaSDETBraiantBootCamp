package com.braiant.selenium.patronesdediseño.pf;

import com.braiant.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage{
    WebDriver driver = DriverFactory.getInstance().getDriver();

    //private By spnSchoolTitle = By.className("wpsp-schoolname");
    @FindBy(className = "wpsp-schoolname")
    private WebElement spnSchoolTitle;
    //private By btnCreateNew = By.linkText("Create New");
    @FindBy(linkText = "Create New")
    private WebElement btnCreateNew;

    //private By icnTrash = By.id("d_teacher");
    @FindBy(id = "d_teacher")
    private List<WebElement> icnTrash;

    //private By btoOk = By.xpath("//*[text()='Ok']");
    @FindBy(xpath = "//*[text()='Ok']")
    private WebElement btoOk;

    protected MainPage() {
        PageFactory.initElements(driver,this);
    }

    private String getSchoolName() {
        return spnSchoolTitle.getText();
    }

    public void verifySchoolName() {
        Assert.assertEquals(getSchoolName(), "Titanium School");
    }

    public void clickCreateNew(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnCreateNew));
        btnCreateNew.click();
    }

    protected void deleteRow() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElements(icnTrash));
        WebElement delete = icnTrash.get(icnTrash.size() - 1);
        delete.click();
    }

    protected void confirmWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(btoOk));
        btoOk.click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.invisibilityOf(btoOk));
    }
}
