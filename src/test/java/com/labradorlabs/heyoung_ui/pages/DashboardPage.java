package com.labradorlabs.heyoung_ui.pages;

import com.labradorlabs.heyoung_ui.utilities.BrowserUtils;
import com.labradorlabs.heyoung_ui.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    //  (//div[@class='gnb-menu-wrap']/a)[#] 1,2,3,4,5,6

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@class='gnb-menu-wrap']/a/span")
    public List<WebElement> allModules;

    public List<String> getActualModules(){
        List<String> actualModules = BrowserUtils.getElementsText(allModules);
        return actualModules;
    }

    public void goToTheModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("(//a[contains(@aria-label,'" + moduleName+"')])[1]")).click();
    }


}
