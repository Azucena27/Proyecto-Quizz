/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import controlador.Controller;
import exception.ArchivoInvalidoException;
import exception.CargarArchivoException;
import exception.PreguntaExistenteException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import quizz.DetallesQuizz;
import quizz.Pregunta;

/**
 *
 * @author Azucena
 */
public class PrincipalFrame extends JFrame {

    private JButton BtnHacer;
    private JButton BtnTomar;
    private JButton BtnCancelar;
    private JPanel pnlOpciones;
    private JPanel pnlCancelar;
    private HacerDialog dglHacer;
    private TomarDialog dglTomar;
    private PreguntasDialog dglPreguntas;
    private Controller controlador;

    public PrincipalFrame() {
        super("Quizz");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 230);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);

        controlador = new Controller();
        pnlOpciones = new JPanel();
        pnlOpciones.setPreferredSize(new Dimension(300, 400));
        pnlOpciones.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlOpciones.setBorder(new MatteBorder(30, 30, 30, 30, Color.BLUE));

        dglTomar = new TomarDialog(this);
        dglTomar.setListener(new TomarDialogListener() {
            @Override
            public void TerminarButtonClick() {
                System.exit(0);
                //dglTomar.setVisible(false);
                System.out.println("listo");
            }

            @Override
            public void cancelarButtonClick() {
                dglTomar.setVisible(false);
                System.out.println("cancelar");
            }

        });

        dglPreguntas = new PreguntasDialog(this);
        dglPreguntas.setListener(new ConfirmacionDialogListener() {
            @Override
            public void siguienteButtonClick(DetallesQuizz detalles) {

                dglHacer = new HacerDialog(null, detalles);
                //dglHacer.setDetalles(detalles);
                dglHacer.setListener(new HacerDialogListener() {
                    @Override
                    public void listoButtonClick(Pregunta preguntas) {//DetallesQuizz detalles
                    //    try {
                            //System.out.println(preguntas + " Preguntas");
                            System.out.println("Listo");
                            System.exit(0);
                      /*  } catch(PreguntaExistenteException ex) {
                            JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Preguntas no ingresadas", JOptionPane.ERROR_MESSAGE);
                        }*/
                    }

                    @Override
                    public void cancelarButtonClick() {
                        dglHacer.setVisible(false);
                        System.out.println("cancelar");
                    }
                });

                dglHacer.setVisible(true);
            }

            @Override
            public void cancelarButtonClick() {
                dglPreguntas.setVisible(false);
            }

        });
        
        BtnHacer = new JButton("Elaborar examen");
        BtnHacer.setBackground(Color.ORANGE);
        BtnHacer.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        BtnHacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dglPreguntas.setVisible(true);

            }
        });

        BtnTomar = new JButton("Realizar examen");
        BtnTomar.setBackground(Color.YELLOW);
        BtnTomar.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        BtnTomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dglTomar.setVisible(true);

            }
        });

        pnlOpciones.add(BtnHacer);
        pnlOpciones.add(BtnTomar);

        BtnCancelar = new JButton("Cancelar");
        BtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pnlCancelar = new JPanel();
        pnlCancelar.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlCancelar.setBackground(Color.PINK);
        pnlCancelar.add(BtnCancelar);

        super.add(pnlCancelar, BorderLayout.SOUTH);
        super.add(pnlOpciones, BorderLayout.CENTER);
        super.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();
            }
        });
    }

}
