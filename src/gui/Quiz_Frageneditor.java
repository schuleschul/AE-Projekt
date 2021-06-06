package gui;

import backend.*;
import datenbank.DatenbankInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * GUI-Frageneditor
 *
 * @version 1.0 vom 06.06.2021
 * @Stéphane Matot
 */

public class Quiz_Frageneditor extends JFrame {


    public Quiz_Frageneditor(Gamemaster gamemaster) {
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
        setTitle("Quiz_Frageneditor");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        rahmen_bg_layer.setBounds(8, 28, 613, 454);
        rahmen_bg_layer.setText("");
        rahmen_bg_layer.setIcon(rahmen_bg_layerIcon);
        rahmen_bg_layer.setVisible(true);
        cp.add(rahmen_bg_layer);



        bAbsenden.setBounds(208, 408, 201, 49);
        bAbsenden.setText("absenden");
        bAbsenden.setMargin(new Insets(2, 2, 2, 2));
        bAbsenden.addActionListener(new ButtonListener());
        cp.add(bAbsenden);

        lFrageneditor.setBounds(248, 32, 125, 48);
        lFrageneditor.setText("Frageneditor");
        lFrageneditor.setFont(new Font("Arial Narrow", Font.BOLD, 24));
        cp.add(lFrageneditor);

        jThemenauswahl.setModel(jThemenauswahlModel);
        jThemenauswahl.setBounds(64, 80, 225, 33);
        jThemenauswahl.setToolTipText("Themengebiet auswählen");
        cp.add(jThemenauswahl);


        tfHierbittedieFrageeintragen.setBounds(128, 144, 481, 41);
        tfHierbittedieFrageeintragen.setText("");
//        tfHierbittedieFrageeintragen.setToolTipText("xxx");
        cp.add(tfHierbittedieFrageeintragen);

        jSchwierigkeitsgrad.setBounds(336, 80, 225, 33);
        jSchwierigkeitsgrad.setModel(jSchwierigkeitsgradModel);
        cp.add(jSchwierigkeitsgrad);

        lFrage1.setBounds(48, 144, 70, 33);
        lFrage1.setText("Frage:");
        lFrage1.setHorizontalAlignment(SwingConstants.RIGHT);
        cp.add(lFrage1);
        tfHierbittedieAntworteintragen.setBounds(128, 192, 481, 41);
        lAntwort.setBounds(48, 192, 70, 33);
        cp.add(tfHierbittedieAntworteintragen);
        lAntwort.setText("Antwort:");
        cp.add(lAntwort);
        lFalscheAntwort1.setBounds(16, 240, 104, 33);
        tfFalscheAntwort1.setBounds(128, 240, 481, 41);
        lFalscheAntwort1.setText("falsche Antwort1:");
        cp.add(lFalscheAntwort1);
        cp.add(tfFalscheAntwort1);
        lFalscheAntwort2.setBounds(16, 288, 104, 33);
        tfFalscheAntwort2.setBounds(128, 288, 481, 41);
        lFalscheAntwort2.setText("falsche Antwort2:");
        cp.add(lFalscheAntwort2);
        cp.add(tfFalscheAntwort2);
        tfFalscheAntwort3.setBounds(128, 336, 481, 41);
        lFalscheAntwort3.setBounds(16, 336, 104, 33);
        cp.add(tfFalscheAntwort3);
        lFalscheAntwort3.setText("falsche Antwort3:");
        cp.add(lFalscheAntwort3);
        // Ende Komponenten


    } // end of public quiz_Frageneditor

    public void anzeigen(ArrayList<Thema> alleThemen)
    {
        this.alleThemen = alleThemen;
        for (Thema thema : this.alleThemen)
        {
            jThemenauswahlModel.addElement(thema.getBezeichnung());
        }
        for (Frage.Schwierigkeit schwierigkeit : Frage.Schwierigkeit.values())
        {
            jSchwierigkeitsgradModel.addElement(schwierigkeit.toString());
        }

        setVisible(true);
    }

    // Anfang Methoden



    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JTextField[] textfelder = {tfHierbittedieFrageeintragen, tfHierbittedieAntworteintragen, tfFalscheAntwort1, tfFalscheAntwort2, tfFalscheAntwort3};
            for (JTextField textfeld : textfelder)
            {
                if(textfeld.getText().isEmpty())
                {
                    //TODO Fehlermeldung wäre schön, ist jetzt aber nicht da... sollte man aber drauf kommen, dass man alle Felder befüllen muss
                    return;
                }
            }

            Thema gewaehltesThema = null;
            Frage.Schwierigkeit gewaehlteSchwierigkeit = null;
            for (Thema thema : alleThemen)
            {
                if(thema.getBezeichnung().equals(jThemenauswahlModel.getSelectedItem()))
                {
                    gewaehltesThema = thema;
                }
            }
            for(Frage.Schwierigkeit schwierigkeit : Frage.Schwierigkeit.values())
            {
                if(schwierigkeit.toString().equals(jSchwierigkeitsgrad.getSelectedItem()))
                {
                    gewaehlteSchwierigkeit = schwierigkeit;
                }
            }

            String frage = tfHierbittedieFrageeintragen.getText();
            String richtigeAntwort = tfHierbittedieAntworteintragen.getText();
            ArrayList<String> falscheAntworten = new ArrayList<>();
            falscheAntworten.add(tfFalscheAntwort1.getText());
            falscheAntworten.add(tfFalscheAntwort2.getText());
            falscheAntworten.add(tfFalscheAntwort3.getText());

            gamemaster.getFragenFactory().speichern(frage, richtigeAntwort, falscheAntworten, gewaehltesThema.getId(), gewaehlteSchwierigkeit);

            SettingsScreen settingsScreen = new SettingsScreen(gamemaster);
            Quiz_Frageneditor.this.dispose();
            settingsScreen.setVisible(true);

        }
    }



    // Anfang Attribute

    private Gamemaster gamemaster;
    private ArrayList<Thema> alleThemen;

    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("images/rahmen_bg.png"));
    private JComboBox<String> jThemenauswahl = new JComboBox<String>();
    private DefaultComboBoxModel<String> jThemenauswahlModel = new DefaultComboBoxModel<String>();
    private JLabel lFrageneditor = new JLabel();
    private JButton bAbsenden = new JButton();

    private JTextField tfHierbittedieFrageeintragen = new JTextField();
    private JComboBox<String> jSchwierigkeitsgrad = new JComboBox<String>();
    private DefaultComboBoxModel<String> jSchwierigkeitsgradModel = new DefaultComboBoxModel<String>();
    private JLabel lFrage1 = new JLabel();
    private JTextField tfHierbittedieAntworteintragen = new JTextField();
    private JLabel lAntwort = new JLabel();
    private JLabel lFalscheAntwort1 = new JLabel();
    private JTextField tfFalscheAntwort1 = new JTextField();
    private JLabel lFalscheAntwort2 = new JLabel();
    private JTextField tfFalscheAntwort2 = new JTextField();
    private JTextField tfFalscheAntwort3 = new JTextField();
    private JLabel lFalscheAntwort3 = new JLabel();
    // Ende Attribute


    public static void main(String[] args)
    {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        ThemenFactory themenFactory = new ThemenFactory(datenbankInterface);
//        AntwortValidierer antwortValidierer = new AntwortValidierer();
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, new FragenFactory(datenbankInterface), new ThemenFactory(datenbankInterface));

        Quiz_Frageneditor frageneditor = new Quiz_Frageneditor(gamemaster);
        frageneditor.anzeigen(themenFactory.laden());
    } // end of main
    // Ende Methoden
} // end of class quiz_Frageneditor
