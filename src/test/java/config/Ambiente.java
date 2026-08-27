/**
 * ========================================================================
 * DATOS DE IDENTIFICACIÓN:
 * Nombre de la Universidad: Universidad Virtual del Estado de Guanajuato (UVEG)
 * Nombre del estudiante: Emmanuel Martinez Zavaleta
 * Número de matrícula: 24026867
 * Nombre de Asesora o Asesor: Gabriela Garibay Mendoza
 * Nombre del Módulo: Calidad y Pruebas de Software
 * Nombre del Reto: Reto 5. Automatización de una pantalla login
 * Fecha de elaboración: 26/08/2026
========================================================================
 */

package config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Clase encargada de inicializar y configurar el WebDriver de acuerdo al navegador indicado.
 */
public class Ambiente {
    public static WebDriver driver;

    public static WebDriver inicializarNavegador(String navegador, String url) {
        if (navegador.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (navegador.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (navegador.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(url);
        return driver;
    }

    public static void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
