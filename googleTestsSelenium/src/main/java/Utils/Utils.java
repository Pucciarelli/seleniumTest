package Utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;//no olviden importar esta librerÃ­a al inicio de su programa

public class Utils {
    private static final long TIMEOUT = 20;
    static File f;
    static BufferedWriter bw;
    static PrintWriter wr;

    // esto es solo un mÃ©todo, no una clase, el mÃ©todo deberÃ¡ ser incluido en
    // una clase java para su uso

    public static void openFile(String fileName) {
        try {
            f = new File(fileName + ".txt");
            FileWriter w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);
        } catch (IOException e) {
        }
        ;
    }

    public static void writeFile(String myTextFile) {
        wr.append(myTextFile + "\n");
        emergencyWait(1);

    }

    public static void CloseFile(String fileName) {
        try {
            wr.close();
            bw.close();
        } catch (IOException e) {
        }

    }

    public static void Write(String fileName, String myText)

    {
        File f;
        f = new File(fileName + ".txt");
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            wr.append(" ");

            wr.close();
            bw.close();
        } catch (IOException e) {
        }
        ;

    }

    /**
     * Set browser to a zoom level 90%
     */
    public static void zoomOut(WebDriver driver) {
        for (int i = 0; i < 1; i++) {
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        }
    }

    /**
     * Set browser to default zoom level 100%
     */
    public static void ZoomDefault(WebDriver driver) {
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void waitForClickeableElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void emergencyWait(int segToSleep) {
        try {
            segToSleep = segToSleep * 1000;
            Thread.sleep(segToSleep);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
