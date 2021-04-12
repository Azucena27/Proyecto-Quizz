/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Martha Jazmín
 */
public class GuardarPreguntasException extends Exception {

    /**
     * Creates a new instance of <code>GuardarPreguntasException</code> without
     * detail message.
     */
    public GuardarPreguntasException() {
    }

    /**
     * Constructs an instance of <code>GuardarPreguntasException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GuardarPreguntasException(String msg) {
        super(msg);
    }
}
