import java.time.Duration;
import java.time.LocalDateTime;

public class RegistroParqueo {
    private Vehiculo vehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public RegistroParqueo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now();
    }

    public long getHorasEstacionado() {
        if (horaSalida == null) return 0;
        Duration duracion = Duration.between(horaEntrada, horaSalida);
        return Math.max(1, duracion.toHours()); // cobra al menos 1 hora
    }

    public double calcularTarifa() {
        long horas = getHorasEstacionado();
        double tarifaPorHora;

        switch (vehiculo.getTipo()) {
            case "Automovil":
                tarifaPorHora = 2.5;
                break;
            case "Moto":
                tarifaPorHora = 1.0;
                break;
            case "Camion":
                tarifaPorHora = 5.0;
                break;
            default:
                tarifaPorHora = 2.0; // genérico
        }

        return horas * tarifaPorHora;
    }

    @Override
    public String toString() {
        return vehiculo.getTipo() + " - Placa: " + vehiculo.getPlaca() +
                ", Entrada: " + horaEntrada +
                (horaSalida != null ? ", Salida: " + horaSalida + ", Tarifa: $" + calcularTarifa() : "");
    }
}
