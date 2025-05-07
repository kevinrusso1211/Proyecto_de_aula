package model;

public abstract class usuarioModel {

    protected String nombre;
    protected String id;
    protected String username;
    protected String password;

    public usuarioModel() {
    }

    public usuarioModel(String nombre, String id, String username, String password) {
        this.nombre = nombre;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verificarCredenciales(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract String getTipoUsuario();
}
