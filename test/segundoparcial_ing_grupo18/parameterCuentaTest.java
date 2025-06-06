
package segundoparcial_ing_grupo18;


import java.util.Arrays;
import java.util.Collection;
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
    
    
        @Parameterized.Parameters
        public static Collection<Object[]> tomarDatos() {
            return Arrays.asList(new Object[][] {
                {500.0, new Cuenta(1500.0), 1000.0},       
                {300.5, new Cuenta(333.0), 1199.5},          
                {9999.0, new Cuenta(2000.0), -1.0}         
            });
    }   
        
        
        @Test
    public void testRetirarDinero() throws Exception {
        try {
            cuenta.retirarDinero(monto);
            assertEquals(esperado, cuenta.getSaldo(), 0.01); 
        } catch (IllegalArgumentException e) {
            assertEquals("OJO! No hay saldo suficiente.", e.getMessage());
        }
    }
    


         
    

}
