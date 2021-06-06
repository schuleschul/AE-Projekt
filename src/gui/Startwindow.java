package gui;
import backend.*;
import datenbank.DatenbankInterface;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Gui Element - Startfenster
// v1.0 - 05/2021
// by Stéphane Matot


public class Startwindow extends JFrame {

    public Startwindow(Gamemaster gamemaster) {
        // Frame-Initialisierung
        super();
        this.gamemaster = gamemaster;
        QuizstartListener quizstartListener = new QuizstartListener();
        SettingsListener settingsListener = new SettingsListener();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 640;
        int frameHeight = 520;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Start");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten



        quizstart.setBounds(176, 336, 311, 68);
        quizstart.setText("");
        quizstart.setMargin(new Insets(2, 2, 2, 2));
        quizstart.addActionListener(quizstartListener);
        quizstart.setIcon(quizstartIcon);

        quizstart.setBorderPainted(false);
        quizstart.setContentAreaFilled(false);
        quizstart.setPressedIcon(quizstartPressedIcon);
        quizstart.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(quizstart);
        jLabel1.setBounds(88, 80, 488, 236);
        jLabel1.setText("");
        jLabel1.setIcon(jLabel1Icon);
        cp.add(jLabel1);
        settingsButton.setBounds(548, 20, 73, 73);
        settingsButton.setText("");
        settingsButton.setMargin(new Insets(2, 2, 2, 2));
        settingsButton.addActionListener(settingsListener);
        settingsButton.setIcon(settingsIcon);

        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);

        cp.add(settingsButton);
        rahmen_bg_layer.setBounds(8, 20, 613, 454);
        rahmen_bg_layer.setText("");
        rahmen_bg_layer.setIcon(rahmen_bg_layerIcon);
        cp.add(rahmen_bg_layer);
        // Ende Komponenten


    } // end of public Hauptmenue

    // Anfang Methoden


    public static void main(String[] args)
    {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
//        AntwortValidierer antwortValidierer = new AntwortValidierer();
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, new FragenFactory(datenbankInterface), new ThemenFactory(datenbankInterface));
//        Quizscreen quizscreen = new Quizscreen(gamemaster, antwortValidierer);
        Startwindow startwindow = new Startwindow(gamemaster);
        startwindow.setVisible(true);
    } // end of main

    private class QuizstartListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Quizscreen quizscreen = new Quizscreen(gamemaster);

            DatenbankInterface datenbankInterface = new DatenbankInterface();
            ThemenFactory themenfactory = new ThemenFactory(datenbankInterface);
            //TODO die setter sind nur für Testzwecke hier. Sobald die Auswahlscreens fertig sind, diese Zeilen entfernen!
            gamemaster.setThema(themenfactory.laden().get(0));
            gamemaster.setSchwierigkeit(gamemaster.getMaxSchwierigkeit());


            Startwindow.this.dispose();
            quizscreen.anzeigen(gamemaster.getFragen());
        }
    }

    private class SettingsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
//            Startwindow.this.setVisible(false);
            SettingsScreen settings = new SettingsScreen(Startwindow.this.gamemaster);
            Startwindow.this.dispose(); //wenn das Settingsfenster über den Fenster-Schließen-Button geschlossen werden würde, würde das Startwindow andernfalls weiter bestehen
            settings.setVisible(true);
        }
    }


    // Anfang Attribute
    private JButton quizstart = new JButton();
    private ImageIcon quizstartPressedIcon = new ImageIcon(getClass().getResource("../images/button_quizstart_pushed.png"));
    private ImageIcon quizstartIcon = new ImageIcon(getClass().getResource("../images/button_quizstart.png"));
    private JLabel jLabel1 = new JLabel();
    private ImageIcon jLabel1Icon = new ImageIcon(getClass().getResource("../images/sb_Logo_big.png"));
    private JButton settingsButton = new JButton();
    private ImageIcon settingsIcon = new ImageIcon(getClass().getResource("../images/settings_solo_small.png"));
    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("../images/rahmen_bg.png"));
    // Ende Attribute

    private Gamemaster gamemaster;

    // Ende Methoden
} // end of class Startwindow
