package gui;

import backend.Gamemaster;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Gui Element - Einstellungsfenster
// v1.0 - 05/2021
// by Stéphane Matot


public class SettingsScreen extends JFrame {


    public SettingsScreen(Gamemaster gamemaster) {
        // Frame-Initialisierung
        super();
        this.gamemaster = gamemaster;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 640;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Settings");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        rahmen_bg_layer.setBounds(8, 20, 613, 454);
        rahmen_bg_layer.setText("");
        rahmen_bg_layer.setIcon(rahmen_bg_layerIcon);
        rahmen_bg_layer.setVisible(true);
        cp.add(rahmen_bg_layer);


        fragenEditorButton.setBounds(176, 264, 311, 67);
        fragenEditorButton.setText("");
        fragenEditorButton.setMargin(new Insets(2, 2, 2, 2));
        fragenEditorButton.addActionListener(new FragenEditorListener());
        fragenEditorButton.setIcon(option2Icon);
        fragenEditorButton.setPressedIcon(option2PressedIcon);
        fragenEditorButton.setBorderPainted(false);
        fragenEditorButton.setContentAreaFilled(false);
        fragenEditorButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(fragenEditorButton);
        startmenuButton.setBounds(176, 336, 311, 67);
        startmenuButton.setText("");
        startmenuButton.setMargin(new Insets(2, 2, 2, 2));
        startmenuButton.addActionListener(new StartWindowButtonListener());
        startmenuButton.setIcon(button_zurueckIcon);
        startmenuButton.setPressedIcon(button_zurueckPressedIcon);
        startmenuButton.setBorderPainted(false);
        startmenuButton.setContentAreaFilled(false);
        startmenuButton.setHorizontalTextPosition(SwingConstants.LEFT);
        cp.add(startmenuButton);
        jLabel1.setBounds(168, 96, 329, 65);
        jLabel1.setText("");
        jLabel1.setIcon(jLabel1Icon);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(jLabel1);
        schwierigkeitswahlButton.setBounds(176, 192, 311, 68);
        schwierigkeitswahlButton.setText("");
        schwierigkeitswahlButton.setMargin(new Insets(2, 2, 2, 2));
        schwierigkeitswahlButton.addActionListener(new SchwierigkeitswahlListener());
        schwierigkeitswahlButton.setIcon(button_option1Icon);
        schwierigkeitswahlButton.setPressedIcon(button_option1PressedIcon);
        schwierigkeitswahlButton.setBorderPainted(false);
        schwierigkeitswahlButton.setContentAreaFilled(false);
        cp.add(schwierigkeitswahlButton);

        // Ende Komponenten

    } // end of public Settings

    // Anfang Methoden


    private class SchwierigkeitswahlListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //TODO Fenster zur Schwierigkeitswahl anzeigen
//            setVisible(false);
        }
    }

    private class FragenEditorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //TODO Frageneditor anzeigen
//            setVisible(false);
        }
    }

    private class StartWindowButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Startwindow startwindow = new Startwindow(gamemaster);
            startwindow.setVisible(true);
            SettingsScreen.this.dispose();      //zerstört das Fenster
        }
    }

    // Ende Methoden

    // Anfang Attribute
    private JLabel jLabel1 = new JLabel();
    private ImageIcon jLabel1Icon = new ImageIcon(getClass().getResource("../images/einstellung_titel.png"));

    private JButton schwierigkeitswahlButton = new JButton();
    private ImageIcon button_option1PressedIcon = new ImageIcon(getClass().getResource("../images/button_option1_pushed.png"));
    private ImageIcon button_option1Icon = new ImageIcon(getClass().getResource("../images/button_option1.png"));
    private JButton fragenEditorButton = new JButton();
    private ImageIcon option2PressedIcon = new ImageIcon(getClass().getResource("../images/button_option2_pushed.png"));
    private ImageIcon option2Icon = new ImageIcon(getClass().getResource("../images/button_option2.png"));
    private JButton startmenuButton = new JButton();
    private ImageIcon button_zurueckPressedIcon = new ImageIcon(getClass().getResource("../images/Startmenue_button_optionen_pushed.png"));
    private ImageIcon button_zurueckIcon = new ImageIcon(getClass().getResource("../images/Startmenue_button_optionen.png"));


    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("../images/rahmen_bg.png"));

    private Gamemaster gamemaster;
    // Ende Attribute
} // end of class Settings
