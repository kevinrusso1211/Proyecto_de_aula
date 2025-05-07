package Main;

import controller.empleadoController;
import controller.loginController;
import controller.restauranteController;
import model.pedidoModel;
import view.Login;
import view.restauranteView;

public class Main {
    public static void main(String[] args) {
        // 1. Configuración inicial igual que antes
        Login login = new Login();
        empleadoController empController = new empleadoController();
        
        // 2. Creamos los componentes del restaurante (pero NO los mostramos aún)
        restauranteView vistaRestaurante = new restauranteView();
        pedidoModel modeloPedido = new pedidoModel(1);
        restauranteController restController = new restauranteController(vistaRestaurante, modeloPedido);
        
        // 3. Pasamos todo al loginController (igual que antes)
        new loginController(login, empController, restController); 
        
        // 4. Mostramos el login (sin cambios)
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}