/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import quizz.Pregunta;

/**
 *
 * @author Azucena
 */
public interface HacerDialogListener {
    
    public void listoButtonClick(Pregunta preguntas);
    
    public void cancelarButtonClick();
}
