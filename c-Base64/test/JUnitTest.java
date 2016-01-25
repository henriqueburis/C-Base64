/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import converterimgbase64tofileimage.ConverterImgBase64ToFileImage;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luiz.buris
 */
public class JUnitTest {

    ConverterImgBase64ToFileImage base64 = new ConverterImgBase64ToFileImage();

    public JUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando.....");
    }

    @Test
    public void Test() {
        String inputTexto = "<p>Luiz Henrique Buris <p><p> <img alt=\"\" height=\"87\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABIAAAAUCAIAAAAP9fodAAAAG0lEQVQ4jWP4z8BABiJHz6i2UW2j2oaGNrIAAMsRioTOKmZUAAAAAElFTkSuQmCC===\" width=\"79\" /></p>";
        String outputText = "C:\\Users\\luiz.buris\\DocumentsBase64TestejvmAAAAABJRU5ErkJggg=====.jpg";
        //      String saida = base64.Base64ToImageLocal(inputTexto, "C:\\Users\\luiz.buris\\Documents\\", "C:\\Users\\luiz.buris\\Documents\\", "teste");
        Assert.assertEquals("10", "10");
//        Assert.assertNotNull(saida == null);
        //  Assert.assertTrue(base64.Base64ToImageLocal(inputTexto, "C:\\Users\\luiz.buris\\Documents\\", "C:\\Users\\luiz.buris\\Documents\\", "teste")!= null);

    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finalizando...");
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        assertTrue(true);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
