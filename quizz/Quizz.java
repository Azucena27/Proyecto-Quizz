/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import exception.PreguntaExistenteException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Azucena
 */
public class Quizz implements Serializable{
    
    private ArrayList<Pregunta> preguntas;
    
    public Quizz(){
        this.preguntas = new ArrayList<>();
    }
    
    public void addPregunta(Pregunta pregunta) throws PreguntaExistenteException{
        this.preguntas.add(pregunta);
    }
    
    public int size(){
        return this.preguntas.size();
    }
    
    public Pregunta getPregunta(int indice){
        return this.preguntas.get(indice);
    }

}

