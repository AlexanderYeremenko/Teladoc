package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;

public class ProcractorPage {
    public ProcractorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    public WebElement addUserBtn;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement saveBtn;

    @FindBy(xpath = "//table/tbody/tr[3]/td[11]/button")
    public WebElement deleteNovakUserBtn;

    @FindBy(name = "FirstName")
    public WebElement firstNameField;

    @FindBy(name = "LastName")
    public WebElement lastNameField;

    @FindBy(name = "UserName")
    public WebElement userNameField;

    @FindBy(name = "Password")
    public WebElement passwordField;

    @FindBy(name = "RoleId")
    public WebElement selectRoleElement;

    @FindBy(name = "Email")
    public WebElement emailField;

    @FindBy(name = "Mobilephone")
    public WebElement mobilephoneField;

    public void selectRole(String roleType){
        Select select = new Select(selectRoleElement);
        select.selectByVisibleText(roleType);
    }
    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr[1]/td[3]")
    public WebElement newUserName;

    @FindBy(xpath = "//button[@class='btn ng-scope ng-binding btn-primary']")
    public WebElement confirmationDelBtn;



}
