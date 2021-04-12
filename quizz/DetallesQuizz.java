/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import exception.CantidadPreguntasException;
import java.io.Serializable;

/**
 *
 * @author Azucena
 */
public class DetallesQuizz implements Serializable {

    private int preguntas;
    private int cantidad;

    public DetallesQuizz(int preguntas, int cantidad) throws CantidadPreguntasException {
        this.preguntas = preguntas;
        this.setCantidad(cantidad);
    }

    /**
     * @return the preguntas
     */
    public int getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(int preguntas) {
            this.preguntas = preguntas;

    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) throws CantidadPreguntasException {     
         if ((cantidad<= preguntas)){
           this.cantidad = cantidad;
        }else{
            throw new CantidadPreguntasException("La cantidad de preguntas en cada examen debe ser igual o menor al total de las preguntas ingresadas");
        }
    }

    
}

