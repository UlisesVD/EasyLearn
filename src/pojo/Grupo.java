package pojo;

public class Grupo {
    private int clave;
    private String salon;

    public Grupo(int clave, String salon) {
        this.clave = clave;
        this.salon = salon;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return salon ;
    }
}
