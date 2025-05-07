package model;

public class administradorModel extends usuarioModel {

    public administradorModel() {
    }

    public administradorModel(String nombre, String id, String username, String password) {
        super(nombre, id, username, password);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
