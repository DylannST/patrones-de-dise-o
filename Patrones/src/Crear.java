import interfaces.Profesional;
import entity.employee.Empleado;
import service.ProfesionalService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crear extends JFrame {
    private JButton btnRegistrar;
    private JPanel panel;
    private JTextField txtNombre;
    private JComboBox options;
    private JTextField txtCedula;
    private JComboBox tipoBD;
    private JTextArea resultado;

    public Crear() {
        options.addItem("Seleccionar");
        options.addItem("Desarrollador");
        options.addItem("Asesor");
        options.addItem("Recursos Humanos");

        tipoBD.addItem("Seleccione la base de datos");
        tipoBD.addItem("MySQL");
        tipoBD.addItem("PostgresSQL");
        ProfesionalService service = new ProfesionalService();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.enLaBaseDatos((String) tipoBD.getSelectedItem());
                Empleado empleado = service.crearProfesional(txtCedula.getText(), txtNombre.getText(), (String) options.getSelectedItem());
                resultado.setText("Se registró el empleado exitosamente\n\n");
                resultado.setText(resultado.getText() + ((Profesional) empleado).datosDelProfesional());
            }
        });
    }

    public static void main(String[] args) {
        Crear crear = new Crear();
        crear.setContentPane(new Crear().panel);
        crear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crear.setVisible(true);
        crear.setLocationRelativeTo(null);
        crear.pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
