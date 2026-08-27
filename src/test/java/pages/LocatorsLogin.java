package pages;

import org.openqa.selenium.By;

/**
 * Clase que almacena todos los localizadores (By) de la pantalla de inicio de sesión.
 */
public class LocatorsLogin {
    // URL base de prueba
    public static final String URL_LOGIN = "https://practicetestautomation.com/practice-test-login/";

    // Elementos del formulario de Login
    public static final By TXT_USUARIO = By.id("username");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By BTN_SUBMIT = By.id("submit");

    // Elementos de validación de resultados
    public static final By LBL_ERROR = By.id("error");
    public static final By LBL_TITULO_EXITO = By.tagName("h1");
    public static final By BTN_LOGOUT = By.xpath("//a[contains(text(),'Log out')]");
}
