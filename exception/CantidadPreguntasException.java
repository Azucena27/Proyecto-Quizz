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
public class CantidadPreguntasException extends Exception {

    /**
     * Creates a new instance of <code>CantidadPreguntasException</code> without
     * detail message.
     */
    public CantidadPreguntasException() {
    }

    /**
     * Constructs an instance of <code>CantidadPreguntasException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CantidadPreguntasException(String msg) {
        super(msg);
    }
}
