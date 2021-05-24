import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//Gui Element - Startfenster
// v1.0 - 05/2021
// by Stéphane Matot


public class Startwindow extends JFrame {
    // Anfang Attribute
    private JButton quizstart = new JButton();
    private ImageIcon quizstartPressedIcon = new ImageIcon(getClass().getResource("images/button_quizstart_pushed.png"));
    private ImageIcon quizstartIcon = new ImageIcon(getClass().getResource("images/button_quizstart.png"));
    private JLabel jLabel1 = new JLabel();
    private ImageIcon jLabel1Icon = new ImageIcon(getClass().getResource("images/sb_Logo_big.png"));
    private JButton settings = new JButton();
    private ImageIcon settingsIcon = new ImageIcon(getClass().getResource("images/settings_solo_small.png"));
    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("images/rahmen_bg.png"));
    // Ende Attribute

    public Startwindow() {
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
        setTitle("Start");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten



        quizstart.setBounds(176, 336, 311, 68);
        quizstart.setText("");
        quizstart.setMargin(new Insets(2, 2, 2, 2));
        quizstart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quizstart_ActionPerformed(evt);
                System.out.println("Startbutton gedrückt!");
            }
        });
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
        settings.setBounds(548, 20, 73, 73);
        settings.setText("");
        settings.setMargin(new Insets(2, 2, 2, 2));
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                settings_ActionPerformed(evt);
                System.out.println("Settingsicon gedrückt!");
            }
        });
        settings.setIcon(settingsIcon);

        settings.setBorderPainted(false);
        settings.setContentAreaFilled(false);

        cp.add(settings);
        rahmen_bg_layer.setBounds(8, 20, 613, 454);
        rahmen_bg_layer.setText("");
        rahmen_bg_layer.setIcon(rahmen_bg_layerIcon);
        cp.add(rahmen_bg_layer);
        // Ende Komponenten

        setVisible(true);
    } // end of public Hauptmenue

    // Anfang Methoden

    public static void main(String[] args) {
        new Startwindow();
    } // end of main

    public void quizstart_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        System.out.println("x");

    } // end of quizstart_ActionPerformed

    public void settings_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        System.out.println("y");

    } // end of settings_ActionPerformed

    // Ende Methoden
} // end of class Startwindow
