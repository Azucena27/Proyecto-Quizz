/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import exception.CantidadPreguntasException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import quizz.DetallesQuizz;

/**
 *
 * @author Azucena
 */
public class PreguntasDialog extends JDialog {

    private JLabel lblPreguntas;
    private JTextField edtPreguntas;
    private JLabel lblCantidad;
    private JTextField edtCantidad;
    private JButton btnCantidad;
    private JPanel pnlCantidad;
    private JPanel pnlOpciones;
    private JButton btnSiguiente;
    private JButton btnCancelar;
    private ConfirmacionDialogListener listener;

    public PreguntasDialog(JFrame parent) {
        super(parent, true);
        super.setSize(290, 200);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(parent);

        lblPreguntas = new JLabel("Cantidad de preguntas a ingresar: ");
        edtPreguntas = new JTextField(7);
        lblCantidad = new JLabel("Cantidad de preguntas aplicar por examen: ");
        edtCantidad = new JTextField(7);

        pnlCantidad = new JPanel();
        pnlCantidad.setBackground(Color.PINK);
        pnlCantidad.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlCantidad.setBorder(new TitledBorder("Detalles del examen"));
        pnlCantidad.setPreferredSize(new Dimension(280, 120));

        pnlCantidad.add(lblPreguntas);
        pnlCantidad.add(edtPreguntas);
        pnlCantidad.add(lblCantidad);
        pnlCantidad.add(edtCantidad);

        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DetallesQuizz detalles = new DetallesQuizz(
                            Integer.parseInt(edtPreguntas.getText()),
                            Integer.parseInt(edtCantidad.getText())
                    );
                    System.out.println(detalles.getCantidad()+" Detalles "+detalles.getPreguntas());
                    
                    listener.siguienteButtonClick(detalles);
                    
                } catch (CantidadPreguntasException ex) {
                    JOptionPane.showMessageDialog(PreguntasDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PreguntasDialog.this, "Error al ingresar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.cancelarButtonClick();
            }
        });

        pnlOpciones = new JPanel();
        pnlOpciones.setBackground(Color.LIGHT_GRAY);
        pnlOpciones.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        pnlOpciones.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlOpciones.add(btnCancelar);
        pnlOpciones.add(btnSiguiente);

        super.add(pnlCantidad, BorderLayout.NORTH);
        super.add(pnlOpciones, BorderLayout.SOUTH);

    }

    public void setListener(ConfirmacionDialogListener listener) {
        this.listener = listener;
    }
}
