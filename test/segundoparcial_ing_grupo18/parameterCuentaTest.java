
package segundoparcial_ing_grupo18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class parameterCuentaTest {
    
    private double monto;
    private Cuenta cuenta;
    private double esperado;
    
    public parameterCuentaTest(double monto, Cuenta cuenta, double esperado) {
            this.monto = monto;
            this.cuenta = cuenta;
            this.esperado = esperado;
        }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Parameterized.Parameters
    public static Collection<Object[]> tomarDatos() {
        return Arrays.asList(new Object[][] {
            {500.0, new Cuenta(1500.0), 1000.0},       // ÉXITO
            {300.5, new Cuenta(333.0), 32.5},          // FALLO
            {9999.0, new Cuenta(2000.0), -1.0}         // ERROR
        });
}   
    @Test
public void testRetirarDinero() throws Exception {
    try {
        cuenta.retirarDinero(monto);
        assertEquals(esperado, cuenta.getSaldo(), 0.01); // 0.01 tolerancia decimal
    } catch (IllegalArgumentException e) {
        assertEquals("OJO! No hay saldo suficiente.", e.getMessage());
    }
}
    


         
    

}
