package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.empleadoModel;
import view.Login;
import view.adminView;

public class loginController {

    private Login vista;
    private empleadoController empController;
    private restauranteController restController;

    public loginController(Login vista, empleadoController empController, restauranteController restController) {
        this.vista = vista;
        this.empController = empController;
        this.restController = restController;
        inicializar();
    }

    private void inicializar() {
        vista.login.addActionListener(e -> verificacion());
    }

    private void verificacion() {
        String usuario = vista.txtname.getText();
        String password = new String(vista.txtpassword.getPassword());

        if (usuario.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(vista, "Bienvenido, Administrador");
            adminView vistaAdmin = new adminView(restController);
            vistaAdmin.setLocationRelativeTo(null);
            vistaAdmin.setVisible(true);
            vista.dispose();
        } else if (verificarEmpleado(usuario, password)) {
            JOptionPane.showMessageDialog(vista, "Bienvenido, " + usuario);
            restController.mostrarVistaRestaurante(); // <- aquí se llama en el momento correcto
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            vista.txtname.setText("");
            vista.txtpassword.setText("");
        }
    }

    private boolean verificarEmpleado(String userName, String password) {
        ArrayList<empleadoModel> lista = empController.getListaEmpleado();
        for (empleadoModel emp : lista) {
            if (emp.getUsername().equals(userName) && emp.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
