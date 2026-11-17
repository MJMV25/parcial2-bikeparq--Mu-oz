package bikeparq;

import java.util.List;

/** Reportes de caja del día. */
public final class Reportes {

    private static final String CARRO = "carro";
    private static final String MOTO = "moto";

    private Reportes() {
    }

    public static Resumen resumenDelDia(List<Registro> registros) {
        int total = 0;
        int carros = 0;
        int motos = 0;
        for (Registro registro : registros) {
            boolean esCarro = CARRO.equals(registro.tipo());
            boolean esMoto = MOTO.equals(registro.tipo());
            if (esCarro) {
                carros++;
            }
            if (esMoto) {
                motos++;
            }
            if (esCarro || esMoto) {
                total += registro.valor();
            }
        }
        return new Resumen(total, carros, motos);
    }

    public static int mayorCobro(List<Registro> registros) {
        int mayor = 0;
        for (Registro registro : registros) {
            mayor = Math.max(mayor, registro.valor());
        }
        return mayor;
    }
}
