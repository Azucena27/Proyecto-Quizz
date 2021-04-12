/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import exception.PreguntaExistenteException;
import java.io.Serializable;

/**
 *
 * @author Azucena
 */
public class Pregunta implements Serializable {

    private String texto;
    private Incisos[] incisos;
    private int indice = 0;

    public Pregunta(String texto) {
        this.texto = texto;
        this.incisos = new Incisos[4];
    }

    public void addInciso(Incisos inciso) {
        System.out.println(inciso.getPregunta());
        System.out.println(indice);
        if (getIndice() <= 3) {
            this.incisos[indice] = inciso;
            indice++;
            this.getIncisos()[getIndice()] = inciso;
      
        }
    }
/*
    public void imprimir() {
        indice = 0;
        for (Incisos inciso : incisos) {
            System.out.println(String.format("[%d] %s ", indice, inciso.getPregunta()));
            indice++;
        }
    }
*/
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) throws PreguntaExistenteException{
        if(this.texto != texto){
        this.texto = texto;
        }else{
            throw new PreguntaExistenteException("Una de las preguntas esta repetida");
        }
        
        
    }

    public Incisos[] getIncisos() {
        return incisos;
    }

    public void setIncisos(Incisos[] incisos) {
        this.incisos = incisos;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    boolean responder(int inidce) {
        this.incisos.equals(this);
        return this.responder(inidce);
    }

    /*   
        @Override
    public boolean equals(Object obj){
        if(obj instanceof Pregunta){
        Pregunta preguntas = (Pregunta)obj;
        if(this.texto.compareTo(preguntas.getTexto())) == 0){
            return true;
        }
    }
        return false;
    }*/
}
