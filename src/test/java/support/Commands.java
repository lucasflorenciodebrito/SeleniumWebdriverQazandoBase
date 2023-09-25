package support;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import static org.junit.Assert.assertEquals;

public class Commands extends RunCucumber {
    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        try {
            waitElementBeClickable(element, 10000);
            getDriver().findElement(element).click();
        } catch (Exception error) {
            System.out.println("Erro ao tentar clicar no elemento: " + element);

        }
    }

    public static void fillField(By element, String text){
        try {
            waitElementBeClickable(element, 10000);
            getDriver().findElement(element).sendKeys(text);
        } catch (Exception error) {
            System.out.println("Erro ao tentar preencher o elemento : " + element);

        }
    }

    public static void checkMessage(By element,String expectedMessage){
        try {
            waitElementBeVisible(element, 10000);
            String actualMessage = getDriver().findElement(element).getText();
            assertEquals(expectedMessage, actualMessage);
        } catch (Exception error) {
            System.out.println("Erro ao tentar validar mensagem com do elemento : " + element);
        }
    }
}
