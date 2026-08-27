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

package tests;

import config.Ambiente;
import pages.LocatorsLogin;
import pages.SeleniumWrappers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class IniciarSesion_CredencialesCorrectas {

    private WebDriver driver;
    private SeleniumWrappers wrappers;

    @BeforeTest
    @Parameters({"navegador"})
    public void setUp(String navegador) {
        // Inicialización de navegador parametrizado y apertura de la URL
        driver = Ambiente.inicializarNavegador(navegador, LocatorsLogin.URL_LOGIN);
        wrappers = new SeleniumWrappers(driver);
    }

    @Test(description = "Validar inicio de sesión exitoso con credenciales correctas")
    public void testLoginExitoso() {
        // Ejecución de pasos estándar con credenciales válidas
        wrappers.ejecutarPasoLogin("student", "Password123");

        // Verificación de cambio de URL de sesión
        String urlActual = driver.getCurrentUrl();
        Assert.assertTrue(urlActual.contains("practicetestautomation.com/logged-in-successfully/"),
                "La URL actual no corresponde a la página de bienvenida tras el login.");

        // Verificación del encabezado de confirmación
        String encabezadoObtenido = wrappers.obtenerTexto(LocatorsLogin.LBL_TITULO_EXITO);
        Assert.assertEquals(encabezadoObtenido, "Logged In Successfully",
                "El título de confirmación no coincide con el esperado.");

        // Verificación de la visibilidad del botón de cierre de sesión (Log out)
        Assert.assertTrue(wrappers.estaVisible(LocatorsLogin.BTN_LOGOUT),
                "El botón de 'Log out' debería estar disponible en pantalla tras iniciar sesión exitosamente.");
    }

    @AfterTest
    public void tearDown() {
        // Cierre y liberación del navegador
        Ambiente.cerrarNavegador();
    }
}