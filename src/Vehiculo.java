public abstract class Vehiculo {
    private String placa;
    private String color;
    private String modelo;
    private Cliente propietario;

    public Vehiculo(String placa, String color, String modelo, Cliente propietario) {
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + "{" +
                "placa='" + placa + '\'' +
                ", color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
