package com.google.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import Pages.google_Page;
import Utils.Utils;

public class generalTests {
    public WebDriver driver;
    google_Page gPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        Utils.openFile("Report");
        this.driver = new FirefoxDriver();
        gPage = PageFactory.initElements(driver, google_Page.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod()
    public void upPage() {
        this.driver.get(google_Page.PAGE_URL);
        google_Page.verifyPage(driver,google_Page.PAGE_URL,google_Page.PAGE_TITLE);
}

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.close();
        Utils.CloseFile("Report");
    }

    @Test(groups = "p1")
    public void loadMainPage() {
        google_Page.setCompanySearch();
        google_Page.check_knowledgepanel();
    }


    @Test(groups = "p1")
    public void searchFirstResults() {
        google_Page.setProductSearch();
        google_Page.checkFirstResults();

    }

    @Test(groups = "p1")
    public void searchSecondResults() {
        google_Page.setProductSearch();
        google_Page.checksecondResults();

    }

    @Test(groups = "p2")
    public void searchAdvertisementResults() {
        google_Page.setProductSearch();
        google_Page.advertisementLinks();

    }

}
