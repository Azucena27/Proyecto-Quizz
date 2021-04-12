/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import quizz.DetallesQuizz;

/**
 *
 * @author Azucena
 */
public class TomarDialog extends JDialog {

    private JLabel lblPregunta;
    private JRadioButton edtRptCorrecta;
    private JRadioButton edtRptIncorrecta1;
    private JRadioButton edtRptIncorrecta2;
    private JRadioButton edtRptIncorrecta3;
    private JPanel pnlOpciones;
    private JPanel pnlPreguntas;
    private JButton btnSiguiente;
    private JButton btnListo;
    private JButton btnCancelar;
    private TomarDialogListener listener;
    private ArrayList<String> listaTemporal1;
    private ArrayList<String> listaTemporal2;
    private ArrayList<ArrayList<String>> listaTemporal;
    private ArrayList<String> listaTemporalPreguntas;
    public DetallesQuizz detalles;

    public TomarDialog(JFrame parent) {
        super(parent, true);
        super.setSize(380, 500);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(parent);
        /*
        JLabel[] label = new JLabel[6]; 
        JRadioButton[] radioB = new JRadioButton[6];
        
           for(int i = 0; i < label.length; i++) {
                    label[i] = new JLabel();    
                   radioB[i] = new JRadioButton();    
           }
          */ 
        listaTemporalPreguntas = new ArrayList<String>();
        listaTemporalPreguntas.add("¿De qué color es el mar?");
        listaTemporalPreguntas.add("¿Cuántos meses tiene un año?");

        listaTemporal = new ArrayList<ArrayList<String>>();
        
        listaTemporal1 = new ArrayList<String>();
        listaTemporal2 = new ArrayList<String>();
       
        listaTemporal1.add("Azul");
        listaTemporal1.add("Verde");
        listaTemporal1.add("Gris");
        listaTemporal1.add("Morado");

        listaTemporal2.add("12");
        listaTemporal2.add("11");
        listaTemporal2.add("13");
        listaTemporal2.add("365");

        listaTemporal.add(listaTemporal1);
        listaTemporal.add(listaTemporal2);
        Random r = new Random();
        int valor;
        int valorPreguntas;// = r.nextInt(listaTemporalPreguntas.size());

        //  for (int i = 0; i < listaTemporalPreguntas.size()+i; i++) {
        for (ArrayList subList : listaTemporal) {
            // valor = r.nextInt(listaTemporal.size());
            valor = r.nextInt(subList.size());
            //valorPreguntas = r.nextInt(listaTemporalPreguntas.size()-i);
            valorPreguntas = r.nextInt(listaTemporalPreguntas.size());

            lblPregunta = new JLabel(listaTemporalPreguntas.get(valorPreguntas));
            listaTemporalPreguntas.remove(valorPreguntas);

            ArrayList<String> temporal = subList;

            //tblAlumnos = new JTable();
            edtRptCorrecta = new JRadioButton(temporal.get(valor), false);
            edtRptCorrecta.setBackground(Color.PINK);
           // listaTemporal.remove(valor);
           temporal.remove(valor);
            valor = r.nextInt(3);
            edtRptIncorrecta1 = new JRadioButton(temporal.get(valor), false);
            edtRptIncorrecta1.setBackground(Color.GREEN);
           // listaTemporal.remove(valor);
           temporal.remove(valor);
            valor = r.nextInt(2);
            edtRptIncorrecta2 = new JRadioButton(temporal.get(valor), false);
            edtRptIncorrecta2.setBackground(Color.CYAN);
          // listaTemporal.remove(valor);
          temporal.remove(valor);
            valor = r.nextInt(1);
            edtRptIncorrecta3 = new JRadioButton(temporal.get(valor), false);
            edtRptIncorrecta3.setBackground(Color.ORANGE);
        
        }

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(edtRptCorrecta);
        grupo1.add(edtRptIncorrecta1);
        grupo1.add(edtRptIncorrecta2);
        grupo1.add(edtRptIncorrecta3);

        pnlPreguntas = new JPanel();
        pnlPreguntas.setBackground(Color.WHITE);
        pnlPreguntas.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlPreguntas.setBorder(new TitledBorder("Examen"));
        pnlPreguntas.setPreferredSize(new Dimension(370, 430));

        pnlPreguntas.add(lblPregunta);
        pnlPreguntas.add(edtRptCorrecta);
        pnlPreguntas.add(edtRptIncorrecta1);
        pnlPreguntas.add(edtRptIncorrecta2);
        pnlPreguntas.add(edtRptIncorrecta3);

        btnListo = new JButton("Terminar examen");
        btnListo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.TerminarButtonClick();
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

        super.add(pnlPreguntas, BorderLayout.NORTH);
        super.add(pnlOpciones, BorderLayout.SOUTH);
        super.add(new JScrollPane(pnlPreguntas), BorderLayout.CENTER);
    }

    public void setListener(TomarDialogListener listener) {
        this.listener = listener;
    }

}
