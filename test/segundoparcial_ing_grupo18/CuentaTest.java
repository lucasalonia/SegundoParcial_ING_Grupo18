/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package segundoparcial_ing_grupo18;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matias
 */
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
        cuenta c2 = new Cuenta("456", 5000.0);
        assertNotNull(c2);
        micuenta.transferirDinero(c2, 1000.0);
    }

    @Test
    public void testCuentasDiferentes() {
        assertNotSame("SON la MISMA cuenta!! origen y destino", micuenta, micuenta); // esto DEBE FALLAR
    }

    @Test
    public void testCuentasIguales() {
        assertSame("Las cuentas son diferentes---", micuenta, c3); // esto DEBE FALLAR
    }

    @Test(timeout = 60)
    public void testOperacionTildada1() throws InterruptedException {
        micuenta.OperacionTildada(40); // debe ÉXITO
    }

    @Test(timeout = 60)
    public void testOperacionTildada2() throws InterruptedException {
        micuenta.OperacionTildada(70); // debe lanzar TIMEOUT
    }
}
