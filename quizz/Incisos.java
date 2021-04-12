/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 * @author Azucena
 */
public class Incisos {
   private String enunciado;
   private Boolean respuesta;

    public Incisos(String pregunta, Boolean respuesta){
       this.enunciado = pregunta;
       this.respuesta = respuesta;
   }
    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return enunciado;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.enunciado = pregunta;
    }

    /**
     * @return the respuesta
     */
    public Boolean getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }
   
   
}
