public class Automovil extends Vehiculo {
    public Automovil(String placa, String color, String modelo, Cliente propietario) {
        super(placa, color, modelo, propietario);
    }

    @Override
    public String getTipo() {
        return "Automovil";
    }
}
