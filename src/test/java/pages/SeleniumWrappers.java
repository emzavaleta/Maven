package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Clase con métodos wrapper reutilizables y pasos estándar de interacción.
 */
public class SeleniumWrappers {
    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumWrappers(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wrapping de comandos Selenium
    public void escribir(By localizador, String texto) {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        elemento.clear();
        elemento.sendKeys(texto);
    }

    public void darClic(By localizador) {
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(localizador));
        elemento.click();
    }

    public String obtenerTexto(By localizador) {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        return elemento.getText().trim();
    }

    public boolean estaVisible(By localizador) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(localizador)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Paso Estándar para flujo completo de login
    public void ejecutarPasoLogin(String usuario, String password) {
        escribir(LocatorsLogin.TXT_USUARIO, usuario);
        escribir(LocatorsLogin.TXT_PASSWORD, password);
        darClic(LocatorsLogin.BTN_SUBMIT);
    }
}