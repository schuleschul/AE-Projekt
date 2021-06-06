import java.awt.*;
import java.awt.event.*;
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
    // Anfang Attribute

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

    public Quiz_Frageneditor() {
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
        bAbsenden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAbsenden_ActionPerformed(evt);
            }
        });
        cp.add(bAbsenden);
        lFrageneditor.setBounds(248, 32, 125, 48);
        lFrageneditor.setText("Frageneditor");
        lFrageneditor.setFont(new Font("Arial Narrow", Font.BOLD, 24));
        cp.add(lFrageneditor);

        jThemenauswahl.setModel(jThemenauswahlModel);
        jThemenauswahl.setBounds(64, 80, 225, 33);
        jThemenauswahlModel.addElement("Themengebiet 1");
        jThemenauswahlModel.addElement("Themengebiet 2");
        jThemenauswahlModel.addElement("Themengebiet 3");
        jThemenauswahlModel.addElement("Themengebiet 4");
        jThemenauswahlModel.addElement("Themengebiet 5");
        jThemenauswahl.setToolTipText("Themengebiet auswählen");
        cp.add(jThemenauswahl);




        tfHierbittedieFrageeintragen.setBounds(128, 144, 481, 41);
        tfHierbittedieFrageeintragen.setText("");
        tfHierbittedieFrageeintragen.setToolTipText("xxx");
        cp.add(tfHierbittedieFrageeintragen);
        jSchwierigkeitsgrad.setBounds(336, 80, 225, 33);
        jSchwierigkeitsgrad.setModel(jSchwierigkeitsgradModel);
        jSchwierigkeitsgradModel.addElement("leicht");
        jSchwierigkeitsgradModel.addElement("mittel");
        jSchwierigkeitsgradModel.addElement("schwer");
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
        lFalscheAntwort3.setText("falsche Antwort2:");
        cp.add(lFalscheAntwort3);
        // Ende Komponenten

        setVisible(true);
    } // end of public quiz_Frageneditor

    // Anfang Methoden

    public static void main(String[] args) {
        new Quiz_Frageneditor();
    } // end of main



    public void bAbsenden_ActionPerformed(ActionEvent evt) {
        // Button absenden...

    } // Ende bAbsenden_ActionPerformed

    // Ende Methoden
} // end of class quiz_Frageneditor
