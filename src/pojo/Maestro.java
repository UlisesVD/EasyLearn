package pojo;

public class Maestro {
    private int clave;
    private String nombre;
    private String ap;
    private String am;
    private String edad;
    private String sexo;
    private String contraseña;

    public Maestro(int clave, String nombre, String ap, String am, String edad, String sexo, String contraseña) {
        this.clave = clave;
        this.nombre = nombre;
        this.ap = ap;
        this.am = am;
        this.edad = edad;
        this.sexo = sexo;
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
