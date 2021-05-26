import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//Gui Element - Einstellungsfenster
// v1.0 - 05/2021
// by Stéphane Matot


public class Settings extends JFrame {
    // Anfang Attribute
    private JLabel jLabel1 = new JLabel();
    private ImageIcon jLabel1Icon = new ImageIcon(getClass().getResource("images/einstellung_titel.png"));

    private JButton button_option1 = new JButton();
    private ImageIcon button_option1PressedIcon = new ImageIcon(getClass().getResource("images/button_option1_pushed.png"));
    private ImageIcon button_option1Icon = new ImageIcon(getClass().getResource("images/button_option1.png"));
    private JButton option2 = new JButton();
    private ImageIcon option2PressedIcon = new ImageIcon(getClass().getResource("images/button_option2_pushed.png"));
    private ImageIcon option2Icon = new ImageIcon(getClass().getResource("images/button_option2.png"));
    private JButton button_zurueck = new JButton();
    private ImageIcon button_zurueckPressedIcon = new ImageIcon(getClass().getResource("images/Startmenue_button_optionen_pushed.png"));
    private ImageIcon button_zurueckIcon = new ImageIcon(getClass().getResource("images/Startmenue_button_optionen.png"));


    private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("images/rahmen_bg.png"));
    // Ende Attribute

    public Settings() {
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


        option2.setBounds(176, 264, 311, 67);
        option2.setText("");
        option2.setMargin(new Insets(2, 2, 2, 2));
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                option2_ActionPerformed(evt);
                System.out.println("Option2");
            }
        });
        option2.setIcon(option2Icon);
        option2.setPressedIcon(option2PressedIcon);
        option2.setBorderPainted(false);
        option2.setContentAreaFilled(false);
        option2.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(option2);
        button_zurueck.setBounds(176, 336, 311, 67);
        button_zurueck.setText("");
        button_zurueck.setMargin(new Insets(2, 2, 2, 2));
        button_zurueck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_zurueck_ActionPerformed(evt);
                System.out.println("zurück");
            }
        });
        button_zurueck.setIcon(button_zurueckIcon);
        button_zurueck.setPressedIcon(button_zurueckPressedIcon);
        button_zurueck.setBorderPainted(false);
        button_zurueck.setContentAreaFilled(false);
        button_zurueck.setHorizontalTextPosition(SwingConstants.LEFT);
        cp.add(button_zurueck);
        jLabel1.setBounds(168, 96, 329, 65);
        jLabel1.setText("");
        jLabel1.setIcon(jLabel1Icon);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(jLabel1);
        button_option1.setBounds(176, 192, 311, 68);
        button_option1.setText("");
        button_option1.setMargin(new Insets(2, 2, 2, 2));
        button_option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_option1_ActionPerformed(evt);
                System.out.println("Option1");
            }
        });
        button_option1.setIcon(button_option1Icon);
        button_option1.setPressedIcon(button_option1PressedIcon);
        button_option1.setBorderPainted(false);
        button_option1.setContentAreaFilled(false);
        cp.add(button_option1);

        // Ende Komponenten

        setVisible(true);
    } // end of public Settings

    // Anfang Methoden

    public static void main(String[] args) {
        new Settings();
    } // end of main

    public void option2_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of option2_ActionPerformed

    public void button_zurueck_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of button_zurueck_ActionPerformed

    public void button_option1_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of button_option1_ActionPerformed

    // Ende Methoden
} // end of class Settings
