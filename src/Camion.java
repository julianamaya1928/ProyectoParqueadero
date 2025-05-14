public class Camion extends Vehiculo {
    public Camion(String placa, String color, String modelo, Cliente propietario) {
        super(placa, color, modelo, propietario);
    }

    @Override
    public String getTipo() {
        return "Camion";
    }
}
