
package segundoparcial_ing_grupo18;

import java.time.LocalDate;
import java.time.Month;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;



public class CuentaTest {
    
    private Cuenta micuenta;
    private Cuenta c3;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Fecha de transacción: " + LocalDate.of(2020, Month.NOVEMBER, 13));
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("FIN de la transacción");
    }

    @Before
    public void setUp() {   
        micuenta = new Cuenta("123", 2000.0);
        c3 = new Cuenta("789", 2000.0);
    }

    @After
    public void tearDown() {
        System.out.println("Saldo final de la cuenta: " + micuenta.getSaldo());
    }

    @Test(expected = Exception.class)
    public void testRetirarFallo() throws Exception {
        micuenta.retirarDinero(9000.0);
    }

    @Test
    public void testRetirarExito() throws Exception {
        micuenta.retirarDinero(500.0);
        assertEquals(1500.0, micuenta.getSaldo(), 0.2);
    }

    @Test
    public void testDepositarDinero() {
        assertNotNull(micuenta);
        micuenta.depositarDinero(200.0);
        assertEquals(2200.0, micuenta.getSaldo(), 0.2);
    }

    @Test
    public void testTransferirCuentaNoNula() throws Exception {
        Cuenta c2 = new Cuenta("456", 5000.0);
        assertNotNull(c2);
        micuenta.transferirDinero(c2, 1000.0);
    }

    @Test
    public void testCuentasDiferentes() {
        assertNotSame("Son la misma cuenta!! origen y destino", micuenta, micuenta); 
    }

    @Test
    public void testCuentasIguales() {
        assertSame("Las cuentas son diferentes:", micuenta, c3); 
    }

    @Test(timeout = 60)
    public void testOperacionTildada1() throws InterruptedException {
        micuenta.OperacionTildada(40); 
    }

    @Test(timeout = 60)
    public void testOperacionTildada2() throws InterruptedException {
        micuenta.OperacionTildada(70);
    }
}
