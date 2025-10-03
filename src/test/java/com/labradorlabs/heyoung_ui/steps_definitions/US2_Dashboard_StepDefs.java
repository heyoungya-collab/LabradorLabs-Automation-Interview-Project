package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US2_Dashboard_StepDefs {
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(io.cucumber.datatable.DataTable dataTable) {
        // Get expected modules from DataTable
        List<String> expectedModules = new ArrayList<>(dataTable.asList());

        // Get actual modules from the page (adjust the CSS selector to your module elements)
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//div[@class='gnb-menu-wrap']/a/span"));
        List<String> actualModules = new ArrayList<>();
        for (WebElement element : moduleElements) {
            actualModules.add(element.getText().trim());
        }

        // Check if actual modules contain all expected modules
        for (String module : expectedModules) {
            if (!actualModules.contains(module)) {
                Assert.fail("Missing module: " + module);
            }
        }
    }
}
