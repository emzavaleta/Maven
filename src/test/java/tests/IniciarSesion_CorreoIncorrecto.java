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


public class IniciarSesion_CorreoIncorrecto {

    private WebDriver driver;
    private SeleniumWrappers wrappers;

    @BeforeTest
    @Parameters({"navegador"})
    public void setUp(String navegador) {
        // Inicialización de navegador parametrizado y apertura de la URL
        driver = Ambiente.inicializarNavegador(navegador, LocatorsLogin.URL_LOGIN);
        wrappers = new SeleniumWrappers(driver);
    }

    @Test(description = "Validar que se muestre un mensaje de error al ingresar un usuario o correo incorrecto")
    public void testLoginUsuarioIncorrecto() {
        // Ejecución de pasos estándar con credencial de usuario inválida
        wrappers.ejecutarPasoLogin("usuarioInvalido123", "Password123");

        // Verificación de visualización del mensaje de error
        Assert.assertTrue(wrappers.estaVisible(LocatorsLogin.LBL_ERROR), 
                "El mensaje de error debería ser visible tras ingresar un usuario no registrado.");

        // Verificación del texto del resultado esperado mediante Aserción
        String mensajeObtenido = wrappers.obtenerTexto(LocatorsLogin.LBL_ERROR);
        String mensajeEsperado = "Your username is invalid!";
        
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, 
                "El mensaje de validación no coincide con el resultado esperado.");
    }

    @AfterTest
    public void tearDown() {
        // Cierre y liberación del navegador
        Ambiente.cerrarNavegador();
    }
}
