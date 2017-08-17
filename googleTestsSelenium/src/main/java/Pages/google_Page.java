package Pages;

import Utils.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;



/**
 * Created by f.pucciarelli on 8/17/2017.
 */
public class google_Page {
    public static final String PAGE_TITLE = "Google";
    public static final String PAGE_URL = "https://www.google.com.ar/";
    public static final String COMPANY_SEARCH = "Seleniumhq";//Garbarino
    public static final String PRODUCT_SEARCH = "Licuadora Atma";


    @FindBy(name = "q")
    private static WebElement search_Box;

    @FindBy(xpath = "//div[@class='kno-ecr-pt kno-fb-ctx']")//data-ved="0ahUKEwikyoKN7v7TAhXITZAKHR_TCckQ3B0IvAEoATAR"
    private static WebElement knowledgePanel;

    @FindBy(xpath = ".//*[@id='rso']/div[3]/div")
    private static WebElement secondRelults;

    @FindBy(xpath = ".//*[@id='tads']")
    private static WebElement advertisementLinksRelults;

    @FindBy(xpath = ".//*[@id='resultStats']")
    private static WebElement resulStatus;

    @FindBy(xpath = ".//*[@id='rso']/div[1]/div")
    private static WebElement firstRelults;



    static WebDriver driver;

    public google_Page(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        Utils.writeFile("Open google page--- DONE");
    }

    //Verify page status
    public static void verifyPage(WebDriver driver, String url, String title) {
        Assert.assertEquals(driver.getTitle(), title);
        Utils.writeFile("Google page Title--- OK");
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.writeFile("Google URL--- OK");
    }

    //Set search
    public static void setCompanySearch() {
        search_Box.clear();
        search_Box.sendKeys(COMPANY_SEARCH);
        Utils.writeFile("Set Company Search OK: " + COMPANY_SEARCH);
    }

    //Set search
    public static void setProductSearch() {
        search_Box.clear();
        search_Box.sendKeys(PRODUCT_SEARCH);
        search_Box.sendKeys(Keys.ENTER);
        Utils.writeFile("Set Product Search: " + PRODUCT_SEARCH);
    }

    //check knowledge panel
    public static void check_knowledgepanel() {
        Assert.assertEquals(knowledgePanel.getText(), COMPANY_SEARCH);
        Utils.writeFile("Knowledge panel: OK" + COMPANY_SEARCH);
    }

    //‘advertisement links’.
    public static void advertisementLinks() {

        if (advertisementLinksRelults.getText().contains(COMPANY_SEARCH)) {
            Utils.writeFile("Advertisement Results found: " + COMPANY_SEARCH);
        } else {
            Utils.writeFile("Advertisement Results NOT found: " + COMPANY_SEARCH + " Actual values: " + advertisementLinksRelults.getText());
        }

        Assert.assertTrue(advertisementLinksRelults.getText().contains(COMPANY_SEARCH),
                "Advertisement Results don't contains " + COMPANY_SEARCH);
    }

    //Check first results
    public static void checkFirstResults() {
        if (firstRelults.getText().contains(COMPANY_SEARCH)) {
            Utils.writeFile("Firts Results found: " + COMPANY_SEARCH);
        } else {
            Utils.writeFile("Firts Results NOT found: " + COMPANY_SEARCH + " Actual values: " + firstRelults.getText());
        }
        Assert.assertTrue(firstRelults.getText().contains(COMPANY_SEARCH),
                "First Results don't contains " + COMPANY_SEARCH);
    }

    //Check second results
    public static void checksecondResults() {

        if (secondRelults.getText().contains(COMPANY_SEARCH)) {
            Utils.writeFile("Second Results found: " + COMPANY_SEARCH);
        } else {
            Utils.writeFile("Second Results NOT found: " + COMPANY_SEARCH + " Actual values: " + secondRelults.getText());
        }
        Assert.assertTrue(secondRelults.getText().contains(COMPANY_SEARCH),
                "second Results don't contains " + COMPANY_SEARCH);

    }

}
