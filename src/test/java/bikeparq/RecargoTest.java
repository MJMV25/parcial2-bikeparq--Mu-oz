package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RecargoTest {

    @Test
    void r1EntradaALas22SumaRecargo() {
        int tarifa = 3000;
        int horaEntrada = 22;

        int total = Recargo.aplicarRecargoNocturno(tarifa, horaEntrada);

        assertEquals(5000, total);
    }
}
