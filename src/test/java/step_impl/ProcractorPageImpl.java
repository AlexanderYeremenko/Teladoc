package step_impl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ProcractorPage;
import utils.ConfigReader;
import utils.CucumberUtils;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Map;

public class ProcractorPageImpl {
    ProcractorPage procractorPage = new ProcractorPage();

    private static String propertyPath = "src/test/resources/conf/configuration.properties";


    public void fillRegistrationForm(Map<String, String> map) {
        for (String key : map.keySet()) {
            switch (key.toLowerCase()) {
                case "first name":
                    SeleniumUtils.sendKeys(procractorPage.firstNameField, map.get(key));
                    break;
                case "last name":
                    SeleniumUtils.sendKeys(procractorPage.lastNameField, map.get(key));
                    break;
                case "user name":
                    SeleniumUtils.sendKeys(procractorPage.userNameField, map.get(key));
                    break;
                case "password":
                    SeleniumUtils.sendKeys(procractorPage.passwordField, map.get(key));
                    break;
                case "role":
                    procractorPage.selectRole(map.get(key));
                    break;
                case "email":
                    SeleniumUtils.sendKeys(procractorPage.emailField, map.get(key));
                    break;
                case "cell phone":
                    SeleniumUtils.sendKeys(procractorPage.mobilephoneField, map.get(key));
                    break;

                default:
                    System.out.println("Invalid field type");
            }
            CucumberUtils.logInfo("Entered data: " + map.get(key), false);
        }
        CucumberUtils.logInfo("", true);
    }


    @Given("I open WebTable page")
    public void iOpenWebTablePage() {
        Driver.getDriver().get(ConfigReader.readProperty("url",propertyPath));
        CucumberUtils.logInfo("Title of the opened site is: " + Driver.getDriver().getTitle(), true);


    }

    @When("I click {string} button")
    public void iClickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "add user":
                SeleniumUtils.click(procractorPage.addUserBtn);
                break;
            case "save":
                SeleniumUtils.click(procractorPage.saveBtn);
                break;
            case "delete user":
                SeleniumUtils.click(procractorPage.addUserBtn);
                break;
            case "delete novak user":
                SeleniumUtils.waitForClickability(procractorPage.deleteNovakUserBtn);
                SeleniumUtils.click(procractorPage.deleteNovakUserBtn);
                SeleniumUtils.switchToActiveElement();
                SeleniumUtils.click(procractorPage.confirmationDelBtn);

                break;
            default:
                System.out.println("Invalid button name");
        }
        CucumberUtils.logInfo("Clicked a button: " + buttonName, false);
    }


    public boolean userNameIsNotPresent(String str) {
        for(WebElement row : procractorPage.tableRows) {
            if(row.getText().contains(str)) {
                return false;
            }
        }
        return true;
    }
}

