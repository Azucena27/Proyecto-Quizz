/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import quizz.Pregunta;
import exception.ArchivoInvalidoException;
import exception.CargarArchivoException;
import exception.GuardarPreguntasException;
import exception.PreguntaExistenteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Azucena
 */
public class Controller implements Serializable{
    
   private ArrayList<Pregunta> preguntas;
    
    public boolean add(Pregunta pregunta) throws PreguntaExistenteException {
        if (preguntas.contains(pregunta)) {
            throw new PreguntaExistenteException("Una pregunta ya ha sido ingresada anteriormente");
        }
        return preguntas.add(pregunta);
    }

    public Pregunta getPregunta(int inx){
        return preguntas.get(inx);
    }
    
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }
    
    public int cantidadPreguntas() {
        return preguntas.size();
    }
    
        public void guardar() throws GuardarPreguntasException {
        try {
            File file = new File("preguntas.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(this);

            writer.close();
            output.close();
        } catch (IOException ex) {
            throw new GuardarPreguntasException("Hubo un error en disco duro");
        }
    }

    
        public void cargar() throws CargarArchivoException, ArchivoInvalidoException {
        File file = new File("preguntas.dat");
        if (file.exists()) {
            try {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                preguntas = (ArrayList<Pregunta>) reader.readObject();

                reader.close();
                input.close();
            } catch (IOException ex) {
                throw new CargarArchivoException("Error al cargar el examen");
            } catch (ClassNotFoundException ex) {
                throw new ArchivoInvalidoException("El archivo de origen ha sido corrompido");
            }
        } else {
            preguntas = new ArrayList<Pregunta>();
        }

    }
        
}
