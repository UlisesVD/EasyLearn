
package pojo;

/**
 *
 * @author Mauricio
 */
public class Alumno {
    String nombre,ap,am,edad,sexo,contraseña,grupo;
    int clave;

    public Alumno(String nombre, String ap, String am, String edad, String sexo, String contraseña, String grupo, int clave) {
        this.nombre = nombre;
        this.ap = ap;
        this.am = am;
        this.edad = edad;
        this.sexo = sexo;
        this.contraseña = contraseña;
        this.grupo = grupo;
        this.clave = clave;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

 

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Alumno() {
        
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", ap=" + ap + ", am=" + am + ", edad=" + edad + ", sexo=" + sexo + ", contrase\u00f1a=" + contraseña + ", grupo=" + grupo + ", clave=" + clave + '}';
    }

 
    
    
    
    
}
