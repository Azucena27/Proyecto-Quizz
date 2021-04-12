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
public class PreguntaExistenteException extends Exception {

    /**
     * Creates a new instance of <code>PreguntaExistenteException</code> without
     * detail message.
     */
    public PreguntaExistenteException() {
    }

    /**
     * Constructs an instance of <code>PreguntaExistenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PreguntaExistenteException(String msg) {
        super(msg);
    }
}
