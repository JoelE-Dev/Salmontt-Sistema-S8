


/**
 *
 * @author j0el97
 */



import javax.swing.*;
import java.util.ArrayList;

/*
 * ================================
 * INTERFAZ COMÚN
 * ================================
 */
interface Registrable {
    String mostrarResumen();
}

/*
 * ================================
 * CLASE BASE
 * ================================
 */
abstract class Entidad implements Registrable {

    private String id;
    private String nombre;

    public Entidad(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
}

/*
 * ================================
 * ENTIDADES DEL SISTEMA
 * ================================
 */

class Empleado extends Entidad {

    private String cargo;
    private double sueldo;

    public Empleado(String id, String nombre, String cargo, double sueldo) {
        super(id, nombre);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    @Override
    public String mostrarResumen() {
        return "Empleado\nNombre: " + getNombre() +
               "\nCargo: " + cargo +
               "\nSueldo: $" + sueldo;
    }
}

class Proveedor extends Entidad {

    private String servicio;

    public Proveedor(String id, String nombre, String servicio) {
        super(id, nombre);
        this.servicio = servicio;
    }

    @Override
    public String mostrarResumen() {
        return "Proveedor\nNombre: " + getNombre() +
               "\nServicio: " + servicio;
    }
}

class CentroCultivo extends Entidad {

    private String ubicacion;

    public CentroCultivo(String id, String nombre, String ubicacion) {
        super(id, nombre);
        this.ubicacion = ubicacion;
    }

    @Override
    public String mostrarResumen() {
        return "Centro de Cultivo\nNombre: " + getNombre() +
               "\nUbicación: " + ubicacion;
    }
}

class PlantaProceso extends Entidad {

    private int capacidadToneladas;

    public PlantaProceso(String id, String nombre, int capacidadToneladas) {
        super(id, nombre);
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public String mostrarResumen() {
        return "Planta de Proceso\nNombre: " + getNombre() +
               "\nCapacidad: " + capacidadToneladas + " toneladas";
    }
}

/*
 * ================================
 * COLECCIÓN
 * ================================
 */
class GestorEntidades {

    private ArrayList<Registrable> registros = new ArrayList<>();

    public void agregar(Registrable r) {
        registros.add(r);
    }

    public String mostrarTodo() {
        StringBuilder sb = new StringBuilder();

        for (Registrable r : registros) {

            sb.append(r.mostrarResumen()).append("\n");

            if (r instanceof Empleado) {
                sb.append("Tipo detectado: Empleado\n");
            } else if (r instanceof Proveedor) {
                sb.append("Tipo detectado: Proveedor\n");
            } else if (r instanceof CentroCultivo) {
                sb.append("Tipo detectado: Centro de Cultivo\n");
            } else if (r instanceof PlantaProceso) {
                sb.append("Tipo detectado: Planta de Proceso\n");
            }

            sb.append("----------------------------\n");
        }
        return sb.toString();
    }
}

/*
 * ================================
 * INTERFAZ GRÁFICA
 * ================================
 */
public class SistemaSalmontt extends JFrame {

    private GestorEntidades gestor = new GestorEntidades();

    public SistemaSalmontt() {

        setTitle("Sistema de Gestión Salmontt");
        setSize(420, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnEmpleado = new JButton("Agregar Empleado");
        JButton btnProveedor = new JButton("Agregar Proveedor");
        JButton btnMostrar = new JButton("Mostrar Registros");

        btnEmpleado.addActionListener(e -> {
            Empleado emp = new Empleado(
                    "E01",
                    "Juan Pérez",
                    "Operario de Planta",
                    850000
            );
            gestor.agregar(emp);
            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente");
        });

        btnProveedor.addActionListener(e -> {
            Proveedor prov = new Proveedor(
                    "P01",
                    "AquaLog",
                    "Transporte marítimo"
            );
            gestor.agregar(prov);
            JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente");
        });

        btnMostrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, gestor.mostrarTodo());
        });

        JPanel panel = new JPanel();
        panel.add(btnEmpleado);
        panel.add(btnProveedor);
        panel.add(btnMostrar);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SistemaSalmontt();
    }
}



