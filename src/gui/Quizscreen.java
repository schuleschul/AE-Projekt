package gui;

import backend.*;
import datenbank.DatenbankInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.*;


//Gui Element - Quizfenster
// v1.0 - 19.05.2021
// by Stéphane Matot


public class Quizscreen extends JFrame {

    public Quizscreen(Gamemaster gamemaster) {
        // Frame-Initialisierung
        super();
        this.gamemaster = gamemaster;
        this.antwortValidierer = new AntwortValidierer();
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

    public void anzeigen(ArrayList<Frage> fragen)
    {
        if(fragen.size() == 0)
        {
            throw new IllegalArgumentException("es wurden keine Fragen übergeben!");
        }
        this.fragen = fragen;
        akutelleFrageIndex = 0;
        anzeigen(fragen.get(akutelleFrageIndex));
    }


    private void anzeigen(Frage frage)
    {
        istEingeloggt = false;
        this.frage = frage;
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
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        AntwortValidierer antwortValidierer = new AntwortValidierer();
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, new FragenFactory(datenbankInterface), new ThemenFactory(datenbankInterface));
        Quizscreen quizscreen = new Quizscreen(gamemaster);

        ArrayList<String> liste = new ArrayList<String>();
        liste.add("1");
        liste.add("2");
        liste.add("3");

        Frage.Schwierigkeit schwierigkeit = Frage.Schwierigkeit.values()[1];
        Frage frage = new Frage("hallo?", "ja", liste,  schwierigkeit, 2);
        ArrayList<Frage> fragen = new ArrayList<Frage>();
        fragen.add(frage);
        fragen.add(new Frage("hallo?", "nein", liste,  schwierigkeit, 2));
        fragen.add(new Frage("hallo?", "doch", liste,  schwierigkeit, 2));
        fragen.add(new Frage("hallo?", "ohh", liste,  schwierigkeit, 2));
        quizscreen.anzeigen(fragen);
    } // end of main



    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //TODO das löst nur das klicken am Ende des Spiels, zwischen den Fragen werden weitere events immer noch verarbeitet..
            if(!istEingeloggt)
            {
                istEingeloggt = true;
                JButton button = (JButton) e.getSource();
                antwort = button.getText();
                System.out.println(antwort);
                boolean istRichtig = antwortValidierer.istRichtig(frage, antwort);
                System.out.println(istRichtig);
                gamemaster.takeAction(frage, istRichtig);

                try
                {
                    showResult(button, istRichtig);
                }
                catch(InterruptedException exception)
                {
                    System.out.println("Schade eigentlich.");
                }
                System.out.println("Index: " + akutelleFrageIndex);
                if(akutelleFrageIndex < (fragen.size() -1))
                {
                    anzeigen(fragen.get(++akutelleFrageIndex));
                }
                else
                {
                    //hier goodbye screen einblenden, der ua den Score anzeigt
                    System.out.println("Level vorbei!");
                    System.out.println(gamemaster.getScore());
                }
            }
        }
    }

    //zeigt an, ob die Antwort richtig war oder nicht
    private void showResult(JButton button, boolean istRichtig) throws InterruptedException
    {
        if(istRichtig)
        {
            //button grün machen
            System.out.println("RICHTIG!!!");
        }
        else
        {
            //button rot machen
            System.out.println("Antwort ist falsch!");
            if(antwortA.getText().equals(frage.getRichtigeAntwort()))
            {
                //grün machen
                System.out.println("AntwortA ist richtig");
            }
            else if(antwortB.getText().equals(frage.getRichtigeAntwort()))
            {
                //grün machen
                System.out.println("AntwortB ist richtig");
            }
            else if(antwortC.getText().equals(frage.getRichtigeAntwort()))
            {
                //grün machen
                System.out.println("AntwortC ist richtig");
            }
            else if(antwortD.getText().equals(frage.getRichtigeAntwort()))
            {
                //grün machen
                System.out.println("AntwortD ist richtig");
            }
        }
        TimeUnit.SECONDS.sleep(5);
    }


    // Anfang Attribute
    private JLabel infoScreen = new JLabel();
    private ImageIcon infoScreenIcon = new ImageIcon(getClass().getResource("../images/quiz_infoscreen_empty.png"));
    private JLabel fragenfeld = new JLabel();
    private ImageIcon fragenfeldIcon = new ImageIcon(getClass().getResource("../images/frage_textfeld.png"));
    private JButton antwortA = new JButton();
    private ImageIcon antwortAIcon = new ImageIcon(getClass().getResource("../images/antwort_textfeld.png"));
    private JButton antwortB = new JButton();
    private ImageIcon antwortBIcon = new ImageIcon(getClass().getResource("../images/antwort_textfeld.png"));
    private JButton antwortC = new JButton();
    private ImageIcon antwortCIcon = new ImageIcon(getClass().getResource("../images/antwort_textfeld.png"));
    private JButton antwortD = new JButton();
    private ImageIcon antwortDIcon = new ImageIcon(getClass().getResource("../images/antwort_textfeld.png"));
    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("../images/rahmen_bg.png"));
    // Ende Attribute



    private String antwort;         //gewählte Antwort
    private Frage frage;
    private ArrayList<Frage> fragen;
    private int akutelleFrageIndex;
    private boolean istEingeloggt;  //damti nicht ständig neue Buttonevents ausgelöst werden, wird überpürt, ob eine Antwort schon eingeloggt wurde
    private Gamemaster gamemaster;
    private AntwortValidierer antwortValidierer;
    private ButtonListener buttonListener;

        // Ende Methoden
} // end of class Quizscreen
