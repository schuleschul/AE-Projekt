import java.awt.*;
import java.awt.event.*;
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
        infoScreen.setText("Infoscreen");
        infoScreen.setHorizontalTextPosition(JLabel.CENTER);
        infoScreen.setVerticalTextPosition(JLabel.CENTER);
        cp.add(infoScreen);
        fragenfeld.setBounds(25, 266, 578, 68);
        fragenfeld.setIcon(fragenfeldIcon);
        fragenfeld.setText("Hier steht die Frage");
        fragenfeld.setHorizontalTextPosition(JLabel.CENTER);
        fragenfeld.setVerticalTextPosition(JLabel.CENTER);
        cp.add(fragenfeld);

        antwortA.setBounds(24, 328, 292, 68);
        antwortA.setIcon(antwortAIcon);
        antwortA.setText("Anwort A");
        antwortA.setHorizontalTextPosition(JLabel.CENTER);
        antwortA.setVerticalTextPosition(JLabel.CENTER);
        antwortA.setIconTextGap(4);
        antwortA.setBorderPainted(false);
        antwortA.setContentAreaFilled(false);
        antwortA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                antwortA_ActionPerformed(evt);
                System.out.println("A gedrückt!");
            }
        });

        cp.add(antwortA);

        antwortB.setBounds(311, 328, 292, 68);
        antwortB.setIcon(antwortBIcon);
        antwortB.setText("Antwort B");
        antwortB.setHorizontalTextPosition(JLabel.CENTER);
        antwortB.setVerticalTextPosition(JLabel.CENTER);
        antwortB.setIconTextGap(4);
        antwortB.setBorderPainted(false);
        antwortB.setContentAreaFilled(false);
        antwortB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                antwortB_ActionPerformed(evt);
                System.out.println("B gedrückt!");
            }
        });
        cp.add(antwortB);

        antwortC.setBounds(24, 390, 292, 68);
        antwortC.setIcon(antwortCIcon);
        antwortC.setText("Antwort C");
        antwortC.setHorizontalTextPosition(JLabel.CENTER);
        antwortC.setVerticalTextPosition(JLabel.CENTER);
        antwortC.setBorderPainted(false);
        antwortC.setContentAreaFilled(false);
        antwortC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                antwortC_ActionPerformed(evt);
                System.out.println("C gedrückt!");
            }
        });
        cp.add(antwortC);

        antwortD.setBounds(311, 390, 292, 68);
        antwortD.setIcon(antwortDIcon);
        antwortD.setText("Antwort D");
        antwortD.setHorizontalTextPosition(JLabel.CENTER);
        antwortD.setVerticalTextPosition(JLabel.CENTER);
        antwortD.setBorderPainted(false);
        antwortD.setContentAreaFilled(false);
        antwortD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                antwortD_ActionPerformed(evt);
                System.out.println("D gedrückt!");
            }
        });
        cp.add(antwortD);

        // Ende Komponenten

        setVisible(true);
    } // end of public Quizscreen


    private void antwortA_ActionPerformed(ActionEvent evt) {
    }

    private void antwortB_ActionPerformed(ActionEvent evt) {
    }

    private void antwortC_ActionPerformed(ActionEvent evt) {
    }

    private void antwortD_ActionPerformed(ActionEvent evt) {
    }

    // Anfang Methoden

    public static void main(String[] args) {
        new Quizscreen();
    } // end of main

    // Ende Methoden
} // end of class Quizscreen
