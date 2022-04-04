public class Persona {
    private String nombre;
    private String telefono;
    private String correo;
    private String fechaCumple;
    
    public Persona() {
    }
    
    public Persona(String nombre, String telefono, String correo, String fechaCumple) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaCumple = fechaCumple;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(String fechaCumple) {
        this.fechaCumple = fechaCumple;
    }
}
