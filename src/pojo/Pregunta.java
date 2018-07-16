package pojo;

public class Pregunta {
    private int clave;
    private String pregunta;
    private String respuestaCorrecta;
    private String respuestaIncorrectaUno;
    private String respuestaIncorrectaDos;

    public Pregunta(int clave, String pregunta, String respuestaCorrecta, String respuestaIncorrectaUno, String respuestaIncorrectaDos) {
        this.clave = clave;
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaIncorrectaUno = respuestaIncorrectaUno;
        this.respuestaIncorrectaDos = respuestaIncorrectaDos;
    }
    
    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrectaUno() {
        return respuestaIncorrectaUno;
    }

    public void setRespuestaIncorrectaUno(String respuestaIncorrectaUno) {
        this.respuestaIncorrectaUno = respuestaIncorrectaUno;
    }

    public String getRespuestaIncorrectaDos() {
        return respuestaIncorrectaDos;
    }

    public void setRespuestaIncorrectaDos(String respuestaIncorrectaDos) {
        this.respuestaIncorrectaDos = respuestaIncorrectaDos;
    }
    
    
    
}
