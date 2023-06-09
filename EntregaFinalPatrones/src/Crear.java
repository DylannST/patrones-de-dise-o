import command.RegistrarEmpleado;
import facade.mysql.DataBaseMySqlFacade;
import model.Empleado;
import model.FuncionesEmpleado;

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
        options.addItem("Servicio");
        options.addItem("Cafeteria");
        options.addItem("Lavanderia");

        tipoBD.addItem("Seleccione la base de datos");
        tipoBD.addItem("MySQL");
        tipoBD.addItem("PostgresSQL");

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //https://railway.app/
                String funciones = FuncionesEmpleado.valueOf(options.getSelectedItem().toString().toUpperCase()).toString();
                Empleado empleado=new Empleado(txtNombre.getText(),txtCedula.getText(), options.getSelectedItem().toString(), funciones);
                Empleado empleadoRespone = new Empleado();
                switch (tipoBD.getSelectedItem().toString()) {
                    case "PostgresSQL" -> {
                        RegistrarEmpleado registrarEmpleado = new RegistrarEmpleado(empleado);
                        empleadoRespone = registrarEmpleado.execute();
                    }
                    case "MySQL" -> {
                        DataBaseMySqlFacade dataBaseMySqlFacade = new DataBaseMySqlFacade();
                        empleadoRespone = dataBaseMySqlFacade.registrarEmpleado(empleado);
                    }
                }
                resultado.setText("Se registró el empleado exitosamente\n\n");
                resultado.setText(resultado.getText() +empleadoRespone.toString());
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
