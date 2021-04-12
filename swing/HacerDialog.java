/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import exception.PreguntaExistenteException;
import swing.PreguntasDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import quizz.DetallesQuizz;
import quizz.Pregunta;

/**
 *
 * @author Azucena
 */
public class HacerDialog extends JDialog {

    private JLabel[] lblPregunta;
    private JTextField[] edtPregunta;
    private JLabel[] lblRespuestaC;
    private JTextField[] edtRespuestaC;
    private JLabel[] lblRespuestaI;
    private JTextField[] edtRespuesta;
    private JTextField[][] edtRespuestaI;
    private JLabel[] lblSeparador;
    private JPanel pnlOpciones;
    private JPanel pnlPreguntas;
    private JButton btnListo;
    private JButton btnCancelar;
    private HacerDialogListener listener;
    public DetallesQuizz detalles;
    private Pregunta preguntas;

    public HacerDialog(JFrame parent, DetallesQuizz detalles){
        super(parent, true);
        super.setSize(410, 370);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(parent);

        pnlPreguntas = new JPanel();
        pnlPreguntas.setBackground(Color.ORANGE);
        pnlPreguntas.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlPreguntas.setBorder(new TitledBorder("Elaboración del examen"));
        pnlPreguntas.setPreferredSize(new Dimension(370,500));
        this.detalles = detalles;   
        int cantidad = 0;

        if(this.detalles != null){
            System.out.println(this.detalles.getPreguntas()+" preguntas");
            cantidad = detalles.getCantidad();
            System.out.println(cantidad);
          
        }else{
             lblPregunta = new JLabel[1];  
        }
        
        lblPregunta = new JLabel[cantidad];   
        edtPregunta = new JTextField[cantidad]; 
        lblRespuestaC = new JLabel[cantidad];
        edtRespuestaC = new JTextField[cantidad];
        lblRespuestaI = new JLabel[cantidad];
        edtRespuesta = new JTextField[cantidad];
    //    edtRespuestaI = new JTextField[cantidad][3];
        lblSeparador = new JLabel[cantidad];
      //  edtRespuesta = new JTextField[JTextField[2]];

        
        for (int i = 0; i < lblPregunta.length; i++) {

            lblPregunta[i] = new JLabel();    
            edtPregunta[i] = new JTextField(30); 
            lblRespuestaC[i] = new JLabel();
            edtRespuestaC[i] = new JTextField(30);
            lblRespuestaI[i] = new JLabel();
            edtRespuesta[i] = new JTextField(30);
//            edtRespuestaI[i][3] = new JTextField(30);
            lblSeparador[i] = new JLabel();

            lblPregunta[i].setText("Ingrese la pregunta " + (i + 1) + " :");
            lblRespuestaC[i].setText("Ingrese la respuesta correcta :");
            lblRespuestaI[i].setText("Ingrese 3 respuestas incorrectas :");
            lblSeparador[i].setText("...................................................................................................................");

            pnlPreguntas.add(lblPregunta[i], null);
            pnlPreguntas.add(edtPregunta[i], null);
            pnlPreguntas.add(lblRespuestaC[i], null);
            pnlPreguntas.add(edtRespuestaC[i], null);
            pnlPreguntas.add(lblRespuestaI[i], null);
            pnlPreguntas.add(edtRespuesta[i],null);
  //          pnlPreguntas.add(edtRespuestaI[i][3], 3);
            pnlPreguntas.add(lblSeparador[i], null);
        }
 
        btnListo = new JButton("Listo");
        btnListo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /* try{
                    Pregunta preguntas = new Pregunta(
                    edtPregunta.getText();
                    );
                }catch(PreguntaExistenteException ex){
                   JOptionPane.showMessageDialog(Dialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);    
                }*/
                listener.listoButtonClick(preguntas);
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
        pnlOpciones.add(btnListo);

        super.add(pnlPreguntas, BorderLayout.CENTER);
        super.add(pnlOpciones, BorderLayout.SOUTH);
        super.add(new JScrollPane(pnlPreguntas), BorderLayout.CENTER); 
    }

    public void setListener(HacerDialogListener listener) {
        this.listener = listener;
    }
    
    public void setDetalles(DetallesQuizz detalles){
        this.detalles = detalles;
        System.out.println(this.detalles.getPreguntas()+" setDetalles");
    }

}
