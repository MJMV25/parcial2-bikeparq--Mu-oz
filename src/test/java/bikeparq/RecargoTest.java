package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecargoTest {

    @Test
    void r1EntradaALas22SumaRecargo() {
        int tarifa = 3000;
        int horaEntrada = 22;

        int total = Recargo.aplicarRecargoNocturno(tarifa, horaEntrada);

        assertEquals(5000, total);
    }

    @Test
    void r1LimiteALas20EmpiezaLaNoche() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 20));
    }

    @Test
    void r1LimiteALas5TodaviaEsNoche() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 5));
    }

    @Test
    void r2EntradaALas10NoTieneRecargo() {
        int tarifa = 3000;
        int horaEntrada = 10;

        int total = Recargo.aplicarRecargoNocturno(tarifa, horaEntrada);

        assertEquals(3000, total);
    }

    @Test
    void r2LimiteALas19TodaviaEsDia() {
        assertEquals(3000, Recargo.aplicarRecargoNocturno(3000, 19));
    }

    @Test
    void r2LimiteALas6EmpiezaElDia() {
        assertEquals(3000, Recargo.aplicarRecargoNocturno(3000, 6));
    }

    @Test
    void r3TarifaCeroDeNocheNoTieneRecargo() {
        int tarifa = 0;
        int horaEntrada = 23;

        int total = Recargo.aplicarRecargoNocturno(tarifa, horaEntrada);

        assertEquals(0, total);
    }

    @Test
    void r4Hora24LanzaError() {
        int tarifa = 3000;
        int horaEntrada = 24;

        assertThrows(IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(tarifa, horaEntrada));
    }

    @Test
    void r4HoraNegativaLanzaError() {
        assertThrows(IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, -1));
    }
}
