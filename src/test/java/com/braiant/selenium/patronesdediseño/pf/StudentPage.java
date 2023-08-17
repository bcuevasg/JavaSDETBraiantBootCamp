package com.braiant.selenium.patronesdediseño.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StudentPage extends MainPage {
    @FindBy(name = "s_gender")
    private List<WebElement> rdnGenders;
    @FindBy(id = "firstname")
    private WebElement txtFirstName;
    @FindBy(id = "lastname")
    private WebElement txtLastName;
    @FindBy(name = "s_dob")
    private WebElement dtpDateOfBirth;
    @FindBy(className = "day")
    private List<WebElement> tdSelectDays;
    @FindBy(id = "current_address")
    private WebElement txtCurrentAddress;
    @FindBy(name = "s_pcountry")
    private WebElement drpCountry;
    @FindBy(id = "Email")
    private WebElement txtEmail;
    @FindBy(name = "Username")
    private WebElement txtUserName;
    @FindBy(id = "Password")
    private WebElement txtPassword;
    @FindBy(id = "ConfirmPassword")
    private WebElement txtConfirmPass;
    @FindBy(id = "Rollno")
    private WebElement txtRollNumber;
    @FindBy(xpath = "//tr[@role='row']")
    private List<WebElement> trStudentRows;


    public void selectGender(String Gender){
        for(WebElement optGender:rdnGenders){
            if(optGender.getAttribute("value").equals(rdnGenders)){
                optGender.click();
                break;
            }
        }
    }

    private void type(WebElement element, String strType) {
        element.clear();
        element.sendKeys(strType);
    }
    public void typeFirstName(String firstName){
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }

    public void typeLastName(String lastName){
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void selectDateOfBirth(String selectDay){
        dtpDateOfBirth.click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElements(dtpDateOfBirth));

        for(WebElement day:tdSelectDays){
            if(day.getText().equals(selectDay)){
                day.click();
                break;
            }
        }
    }

    public void slectCountry(String country){
        new Select(drpCountry).selectByVisibleText(country);
    }
    public void typecurrentAddress(String currentAddress){
        txtCurrentAddress.clear();
        txtCurrentAddress.sendKeys(currentAddress);
    }

    public void studentPersonalDetails(String ... detail){
        selectGender(detail[0]);
        typeFirstName(detail[1]);
        typeLastName(detail[2]);
        selectDateOfBirth(detail[3]);
        slectCountry(detail[4]);
        typecurrentAddress(detail[5]);
    }

    private void typeEmailAddress(String email) {
        type(txtEmail, email);
    }

    private void typeUserName(String userName) {
        type(txtUserName, userName);
    }

    private void typePassword(String pass) {
        type(txtPassword, pass);
    }

    private void typeConfirmPassword(String confirmPass) {
        type(txtConfirmPass, confirmPass);
    }

    public void accountInformation(Map<String, String> accountInfo) {
        typeEmailAddress(accountInfo.get("email"));
        typeUserName(accountInfo.get("user"));
        typePassword(accountInfo.get("password"));
        typeConfirmPassword(accountInfo.get("password"));
    }

    public void schoolDetails(String rolNumber) {
        type(txtRollNumber, rolNumber);
        txtRollNumber.submit();
    }

    public void validateStudentIsAdded(String studentName) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElements(trStudentRows));


        WebElement newStudentRow = trStudentRows.get(trStudentRows.size() - 1);
        Assert.assertTrue(newStudentRow.getText().contains(studentName));
        System.out.println(newStudentRow.getText() + " contains " + studentName);
    }

    public void deleteStudent() {
        deleteRow();
        confirmWindow();
    }

}
