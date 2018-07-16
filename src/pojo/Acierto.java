package pojo;


public class Acierto {
    private String nombre;
    private int aciertos;

    public Acierto(String nombre, int aciertos) {
        this.nombre = nombre;
        this.aciertos = aciertos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
