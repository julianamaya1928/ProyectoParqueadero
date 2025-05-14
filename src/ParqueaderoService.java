import java.util.ArrayList;

public class ParqueaderoService {
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<RegistroParqueo> registros;

    public ParqueaderoService() {
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        registros = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<RegistroParqueo> getRegistros() {
        return registros;
    }

    // 🚗 Registro de ingreso
    public void ingresarVehiculo(String placa) {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);
        if (vehiculo != null) {
            registros.add(new RegistroParqueo(vehiculo));
            System.out.println("Vehículo ingresado: " + vehiculo);
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    // 🚪 Registro de salida y cálculo de tarifa
    public void salirVehiculo(String placa) {
        for (RegistroParqueo r : registros) {
            if (r.getVehiculo().getPlaca().equalsIgnoreCase(placa) && r.getHoraSalida() == null) {
                r.registrarSalida();
                System.out.println("Vehículo salió: " + r);
                return;
            }
        }
        System.out.println("Registro de ingreso no encontrado para la placa.");
    }

    // 📋 Reporte de vehículos aún estacionados
    public void mostrarVehiculosEstacionados() {
        System.out.println("Vehículos en el parqueadero:");
        for (RegistroParqueo r : registros) {
            if (r.getHoraSalida() == null) {
                System.out.println(r);
            }
        }
    }
}
