package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


//Gui Element - Quizfenster
// v1.0 - 19.05.2021
// by Stéphane Matot


public class Quizscreen extends JFrame {
    // Anfang Attribute
    private JLabel jLabel1 = new JLabel();
    //fuck relative paths in java...
    private ImageIcon jLabel1Icon = new ImageIcon(getClass().getResource("/images/quiz_infoscreen_empty.png"));
    private JLabel jLabel2 = new JLabel();
    private ImageIcon jLabel2Icon = new ImageIcon(getClass().getResource("/images/frage_textfeld.png"));
    private JLabel antwortA = new JLabel();
    private ImageIcon antwortAIcon = new ImageIcon(getClass().getResource("/images/antwort_textfeld.png"));
    private JLabel antwortB = new JLabel();
    private ImageIcon antwortBIcon = new ImageIcon(getClass().getResource("/images/antwort_textfeld.png"));
    private JLabel antwortA1 = new JLabel();
    private ImageIcon antwortA1Icon = new ImageIcon(getClass().getResource("/images/antwort_textfeld.png"));
    private JLabel antwortD = new JLabel();
    private ImageIcon antwortDIcon = new ImageIcon(getClass().getResource("/images/antwort_textfeld.png"));
    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("/images/rahmen_bg.png"));
    // Ende Attribute

    public Quizscreen() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 640;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Wer wird Anwendungsentwickler? - Quiz");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        rahmen_bg_layer.setBounds(8, 20, 613, 454);
        rahmen_bg_layer.setText("");
        rahmen_bg_layer.setIcon(rahmen_bg_layerIcon);
        rahmen_bg_layer.setVisible(true);
        rahmen_bg_layer.setEnabled(true);
        cp.add(rahmen_bg_layer);

        jLabel1.setBounds(24, 38, 578, 233);
        jLabel1.setText("");
        jLabel1.setIcon(jLabel1Icon);
        cp.add(jLabel1);
        jLabel2.setBounds(25, 266, 578, 68);
        jLabel2.setText("");
        jLabel2.setIcon(jLabel2Icon);
        cp.add(jLabel2);
        antwortA.setBounds(24, 328, 292, 68);
        antwortA.setText("");
        antwortA.setIcon(antwortAIcon);
        antwortA.setIconTextGap(4);
        cp.add(antwortA);

        antwortB.setBounds(311, 328, 292, 68);
        antwortB.setText("");
        antwortA.setIcon(antwortBIcon);
        antwortA.setIconTextGap(4);
        antwortB.setIcon(antwortBIcon);
        cp.add(antwortB);
        antwortA1.setBounds(24, 390, 292, 68);
        antwortD.setBounds(311, 390, 292, 68);
        antwortA1.setText("");
        antwortA1.setIcon(antwortA1Icon);
        cp.add(antwortA1);
        antwortD.setText("");
        antwortD.setIcon(antwortDIcon);
        cp.add(antwortD);

        // Ende Komponenten

        setVisible(true);
    } // end of public Quizscreen

    // Anfang Methoden

    public static void main(String[] args) {
        new Quizscreen();
    } // end of main

    // Ende Methoden
} // end of class Quizscreen
