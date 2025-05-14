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
        vista.login.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {
        String usuario = vista.txtname.getText().trim();
        String password = new String(vista.txtpassword.getPassword()).trim();

        if (usuario.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(vista, "Bienvenido, Administrador");
            adminView vistaAdmin = new adminView(restController);
            vistaAdmin.setLocationRelativeTo(null);
            vistaAdmin.setVisible(true);
            vista.dispose();
            return;
        } else if (verificarEmpleado(usuario, password)) {
            JOptionPane.showMessageDialog(vista, "Bienvenido, " + usuario);
            restController.mostrarVistaRestaurante();
            vista.dispose();
            return;
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            vista.txtname.setText("");
            vista.txtpassword.setText("");
        }
        if (usuario.length() < 4 || password.length() < 6) {
            JOptionPane.showMessageDialog(vista, "El usuario y la contraseña deben tener al menos 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
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
