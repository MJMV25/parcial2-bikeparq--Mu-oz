package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TarifaTest {

    @Test
    void cp01CarroQuePermaneceSesentaMinutosPagaTresMil() {
        int minutos = 60;
        String tipo = "carro";

        int cobro = Tarifa.calcularTarifa(minutos, tipo);

        assertEquals(3000, cobro);
    }

    @Test
    void cp02MotoEnElUltimoMinutoDeGraciaNoPaga() {
        int minutos = 10;
        String tipo = "moto";

        int cobro = Tarifa.calcularTarifa(minutos, tipo);

        assertEquals(0, cobro);
    }

    @Test
    void cp03TipoDeVehiculoInvalidoLanzaError() {
        int minutos = 60;
        String tipo = "bicicleta";

        assertThrows(IllegalArgumentException.class, () -> Tarifa.calcularTarifa(minutos, tipo));
    }

    @Test
    void minutosNegativosLanzanError() {
        assertThrows(IllegalArgumentException.class, () -> Tarifa.calcularTarifa(-1, "carro"));
    }

    @Test
    void minutosMayoresAlMaximoLanzanError() {
        assertThrows(IllegalArgumentException.class, () -> Tarifa.calcularTarifa(1441, "carro"));
    }
}
