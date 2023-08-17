package com.braiant.selenium.patronesdediseño.pagepom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StudentPage extends MainPage{
    private By rdnGenderRadio = By.name("s_gender");
    private By txtFirstName = By.id("firstname");
    private By txtLastName = By.id("lastname");
    private By dtpDateOfBirth = By.name("s_dob");
    private By tdSelectDay = By.className("day");
    private By txtCurrentAddress = By.id("current_address");
    private By drpCountry = By.name("s_country");
    private By txtEmail = By.id("Email");
    private By txtUsername = By.id("Username");
    private By txtPassword = By.id("Password");
    private By txtConfirmPass = By.id("ConfirmPassword");
    private By txtRollNumber = By.id("Rollno");
    private By trStudentRows = By.xpath("//tr[@role='row']");


    public void selectGender(String Gender){
        List<WebElement> gender = driver.findElements(rdnGenderRadio);
        for(WebElement optGender:gender){
            if(optGender.getAttribute("value").equals(gender)){
                optGender.click();
                break;
            }
        }
    }

    private void type(By element, String strType) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(strType);
    }
    public void typeFirstName(String firstName){
        driver.findElement(txtFirstName).clear();
        driver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void typeLastName(String lastName){
        driver.findElement(txtLastName).clear();
        driver.findElement(txtLastName).sendKeys(lastName);
    }

    public void selectDateOfBirth(String selectDay){
        driver.findElement(dtpDateOfBirth).click();
        List<WebElement> days = driver.findElements(tdSelectDay);
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dtpDateOfBirth));

        for(WebElement day:days){
            if(day.getText().equals(selectDay)){
                day.click();
                break;
            }
        }
    }

    public void slectCountry(String country){
        new Select(driver.findElement(drpCountry)).selectByVisibleText(country);
    }
    public void typecurrentAddress(String currentAddress){
        driver.findElement(txtCurrentAddress).clear();
        driver.findElement(txtCurrentAddress).sendKeys(currentAddress);
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
        type(txtUsername, userName);
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
        driver.findElement(txtRollNumber).submit();
    }

    public void validateStudentIsAdded(String studentName) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(trStudentRows));

        List<WebElement> students = driver.findElements(trStudentRows);

        WebElement newStudentRow = students.get(students.size() - 1);
        Assert.assertTrue(newStudentRow.getText().contains(studentName));
        System.out.println(newStudentRow.getText() + " contains " + studentName);
    }

    public void deleteStudent() {
        deleteRow();
        confirmWindow();
    }

}
