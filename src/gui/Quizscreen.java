import backend.Frage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;


//Gui Element - Quizfenster
// v1.0 - 19.05.2021
// by Stéphane Matot


public class Quizscreen extends JFrame {
    // Anfang Attribute
    private JLabel infoScreen = new JLabel();
    private ImageIcon infoScreenIcon = new ImageIcon(getClass().getResource("images/quiz_infoscreen_empty.png"));
    private JLabel fragenfeld = new JLabel();
    private ImageIcon fragenfeldIcon = new ImageIcon(getClass().getResource("images/frage_textfeld.png"));
    private JButton antwortA = new JButton();
    private ImageIcon antwortAIcon = new ImageIcon(getClass().getResource("images/antwort_textfeld.png"));
    private JButton antwortB = new JButton();
    private ImageIcon antwortBIcon = new ImageIcon(getClass().getResource("images/antwort_textfeld.png"));
    private JButton antwortC = new JButton();
    private ImageIcon antwortCIcon = new ImageIcon(getClass().getResource("images/antwort_textfeld.png"));
    private JButton antwortD = new JButton();
    private ImageIcon antwortDIcon = new ImageIcon(getClass().getResource("images/antwort_textfeld.png"));
    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("images/rahmen_bg.png"));
    // Ende Attribute

    public Quizscreen() {
        // Frame-Initialisierung
        super();
        buttonListener = new ButtonListener();
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

        infoScreen.setBounds(24, 38, 578, 233);
        infoScreen.setIcon(infoScreenIcon);
        infoScreen.setHorizontalTextPosition(JLabel.CENTER);
        infoScreen.setVerticalTextPosition(JLabel.CENTER);
        cp.add(infoScreen);
        fragenfeld.setBounds(25, 266, 578, 68);
        fragenfeld.setIcon(fragenfeldIcon);
        fragenfeld.setHorizontalTextPosition(JLabel.CENTER);
        fragenfeld.setVerticalTextPosition(JLabel.CENTER);
        cp.add(fragenfeld);

        antwortA.setBounds(24, 328, 292, 68);
        antwortA.setIcon(antwortAIcon);
        antwortA.setHorizontalTextPosition(JLabel.CENTER);
        antwortA.setVerticalTextPosition(JLabel.CENTER);
        antwortA.setIconTextGap(4);
        antwortA.setBorderPainted(false);
        antwortA.setContentAreaFilled(false);
        antwortA.addActionListener(buttonListener);

        cp.add(antwortA);

        antwortB.setBounds(311, 328, 292, 68);
        antwortB.setIcon(antwortBIcon);
        antwortB.setHorizontalTextPosition(JLabel.CENTER);
        antwortB.setVerticalTextPosition(JLabel.CENTER);
        antwortB.setIconTextGap(4);
        antwortB.setBorderPainted(false);
        antwortB.setContentAreaFilled(false);
        antwortB.addActionListener(buttonListener);

        cp.add(antwortB);

        antwortC.setBounds(24, 390, 292, 68);
        antwortC.setIcon(antwortCIcon);
        antwortC.setHorizontalTextPosition(JLabel.CENTER);
        antwortC.setVerticalTextPosition(JLabel.CENTER);
        antwortC.setBorderPainted(false);
        antwortC.setContentAreaFilled(false);
        antwortC.addActionListener(buttonListener);

        cp.add(antwortC);

        antwortD.setBounds(311, 390, 292, 68);
        antwortD.setIcon(antwortDIcon);
        antwortD.setHorizontalTextPosition(JLabel.CENTER);
        antwortD.setVerticalTextPosition(JLabel.CENTER);
        antwortD.setBorderPainted(false);
        antwortD.setContentAreaFilled(false);
        antwortD.addActionListener(buttonListener);

        cp.add(antwortD);

        // Ende Komponenten


    } // end of public Quizscreen
    

    public void anzeigen(Frage frage)
    {
        infoScreen.setText("Infoscreen");
        fragenfeld.setText(frage.getFrage());
        ArrayList<String> alleAntworten = frage.getAlleAntworten();
        antwortA.setText(alleAntworten.get(0));
        antwortB.setText(alleAntworten.get(1));
        antwortC.setText(alleAntworten.get(2));
        antwortD.setText(alleAntworten.get(3));


        setVisible(true);
    }
    // Anfang Methoden

    public static void main(String[] args) {
        Quizscreen quizscreen = new Quizscreen();
        ArrayList<String> liste = new ArrayList<String>();
        liste.add("1");
        liste.add("2");
        liste.add("3");

        Frage.Schwierigkeit schwierigkeit = Frage.Schwierigkeit.values()[1];
        Frage frage = new Frage("hallo?", "ja", liste,  schwierigkeit, 2);
        quizscreen.anzeigen(frage);
    } // end of main

    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton source = (JButton) e.getSource();
            antwort = source.getText();
            System.out.println(antwort);
        }
    }

    //gewählte Antwort
    private String antwort;
    private ButtonListener buttonListener;

        // Ende Methoden
} // end of class Quizscreen
