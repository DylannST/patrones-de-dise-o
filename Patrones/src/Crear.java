import Interface.Profesion;
import entity.Empleado;
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
    private JTextField txtConsultar;
    private JLabel lbInfo;
    private JButton consultarButton;

    public Crear() {
        options.addItem("Seleccionar");
        options.addItem("desarrollador");
        options.addItem("asesor");
        ProfesionalService service = new ProfesionalService();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado empleado = service.crearProfesional(txtCedula.getText(), txtNombre.getText(), (String) options.getSelectedItem());
                lbInfo.setText(((Profesion) empleado).datosEmpleado());

            }
        });
    }

    public static void main(String[] args) {
        Crear crear = new Crear();
        crear.setContentPane(new Crear().panel);
        crear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crear.setVisible(true);
        crear.pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
