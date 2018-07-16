package pojo;

public class Respuesta {
    private int clavePegunta;
    private String respuesta;
    private int cveAlu;

    public Respuesta(int clavePegunta, String respuesta, int cveAlu) {
        this.clavePegunta = clavePegunta;
        this.respuesta = respuesta;
        this.cveAlu = cveAlu;
    }

    public int getCveAlu() {
        return cveAlu;
    }

    public void setCveAlu(int cveAlu) {
        this.cveAlu = cveAlu;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getClavePegunta() {
        return clavePegunta;
    }

    public void setClavePegunta(int clavePegunta) {
        this.clavePegunta = clavePegunta;
    }

    @Override
    public String toString() {
        return  clavePegunta + " " + respuesta;
    }
    
    
    
}
