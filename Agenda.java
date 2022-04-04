import java.util.*;
public class Agenda {
    static int v = 0;
    static ArrayList<Persona> ArrPersona = new ArrayList<Persona>();
    private Persona objPersona;
    
    public Agenda() {
    }
    
    public void agregar(String nombre, String telefono, String correo, String cumple) {
        objPersona = new Persona();
        objPersona.setNombre(nombre);
        objPersona.setTelefono(telefono);
        objPersona.setCorreo(correo);
        objPersona.setFechaCumple(cumple);
        
        ArrPersona.add(objPersona);
        v++;
    }
    
    public int getPersona(String nombre) {
        for(int x=0; x<v; x++) {
            if (ArrPersona.get(x).getNombre().equals(nombre)) {
                return x;
            }
        }
        return -2;
    }
    
    public Persona consultar (int v) {
        return ArrPersona.get(v);
    }
    
    public void modificar(int v, Persona p) {
        ArrPersona.set(v, p);
    }
    
    public void eliminar(int v) {
        ArrPersona.remove(v);
        this.v--;
    }
    
    public ArrayList Datos() {
        return ArrPersona;
    }
}
