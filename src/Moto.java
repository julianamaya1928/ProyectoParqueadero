public class Moto extends Vehiculo {
    public Moto(String placa, String color, String modelo, Cliente propietario) {
        super(placa, color, modelo, propietario);
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}
