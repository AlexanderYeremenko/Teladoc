package step_defintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ProcractorPage;
import step_impl.ProcractorPageImpl;
import utils.CucumberUtils;

import java.util.Map;

public class ProcractorPageTest {

    ProcractorPage procractorPage = new ProcractorPage();
    private final ProcractorPageImpl pageImpl;
    public ProcractorPageTest(ProcractorPageImpl pageImpl) {
        this.pageImpl = pageImpl;
    }

    @Given("I open webtable page")
    public void I_open_webtable_page() {

    }

    @Given("I enter following data:")
    public void i_enter_following_data(Map<String, String> dataTable) {
        pageImpl.fillRegistrationForm(dataTable);
    }

    @Then("I verify an additional line was added to the table")
    public void iVerifyAnAdditionalLineWasAddedToTheTable() {
        int rowCount = procractorPage.tableRows.size();
        Assert.assertEquals(rowCount, 8);
        CucumberUtils.logInfo("Number of rows verified and equals: "+rowCount, false);
    }


    @Then("I verify new UserName {string} was added to the table")
    public void iVerifyNewUserNameWasAddedToTheTable(String userName) {
        Assert.assertEquals(procractorPage.newUserName.getText(), userName);
        CucumberUtils.logInfo("UserName: "+ userName+" is verified", true);

    }

    @Then("I verify a line was removed from the table")
    public void iVerifyALineWasRemovedFromTheTable() {
        int rowCount = procractorPage.tableRows.size();
        Assert.assertEquals(rowCount, 6);
        CucumberUtils.logInfo("Number of rows verified and equals: "+rowCount, false);
    }

    @Then("I verify UserName {string} is no longer in the table")
    public void iVerifyUserNameIsNoLongerInTheTable(String str) {
        Assert.assertTrue(pageImpl.userNameIsNotPresent(str));

    }
}
