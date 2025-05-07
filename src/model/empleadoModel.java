package model;

public class empleadoModel extends usuarioModel {

    public empleadoModel() {
    }

    public empleadoModel(String nombre, String id, String username, String password) {
        super(nombre, id, username, password);
    }

    @Override
    public String getTipoUsuario() {
        return "Cajero";
    }

    public String toFileString() {
        return getNombre() + "," + getId() + "," + getUsername() + "," + getPassword();
    }

    public static empleadoModel fromFileString(String content) {
        String[] parts = content.split(",");
        if (parts.length >= 4) {
            return new empleadoModel(parts[0], parts[1], parts[2], parts[3]);
        }
        return null;
    }

}
