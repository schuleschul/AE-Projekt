package gui;

import backend.FragenFactory;
import backend.Gamemaster;
import backend.Thema;
import backend.ThemenFactory;
import datenbank.DatenbankInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * GUI-Themenauswahl
 *
 * @version 1.0 vom 06.06.2021
 * @St�phane Matot
 */

public class Themengebiete extends JFrame {

  
  public Themengebiete(Gamemaster gamemaster) {
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
    setTitle("Themenauswahl");
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
    lThemengebiete.setBounds(248, 32, 149, 48);
    lThemengebiete.setText("Themengebiete");
    lThemengebiete.setFont(new Font("Arial Narrow", Font.BOLD, 24));
    cp.add(lThemengebiete);



    jThemen.setModel(jThemenModel);
    jThemen.setBounds(184, 224, 249, 41);
    cp.add(jThemen);


  } // end of public Themengebiete
  
  // Anfang Methoden

  public void anzeigen()
  {
    alleThemen = gamemaster.getThemenFactory().laden();
    for (Thema thema : alleThemen)
    {
      jThemenModel.addElement(thema.getBezeichnung());
    }
    setVisible(true);
  }

  // Anfang Attribute
  private Gamemaster gamemaster;
  private ArrayList<Thema> alleThemen;

  private JLabel rahmen_bg_layer = new JLabel();
  private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("../images/rahmen_bg.png"));
  private JLabel lThemengebiete = new JLabel();
  private JButton bAbsenden = new JButton();

  private JComboBox<String> jThemen = new JComboBox<String>();
  private DefaultComboBoxModel<String> jThemenModel = new DefaultComboBoxModel<String>();



  private class ButtonListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      for (Thema thema : alleThemen)
      {
        if(thema.getBezeichnung().equals(jThemenModel.getSelectedItem()))
        {
          gamemaster.setThema(thema);
          Schwierigkeitsgrad schwierigkeitsgrad = new Schwierigkeitsgrad(gamemaster);
          Themengebiete.this.dispose();
          schwierigkeitsgrad.anzeigen();
          return;
        }
      }
    }
  }


  public static void main(String[] args)
  {
    DatenbankInterface datenbankInterface = new DatenbankInterface();
    ThemenFactory themenFactory = new ThemenFactory(datenbankInterface);
    Gamemaster gamemaster = new Gamemaster(datenbankInterface, new FragenFactory(datenbankInterface), new ThemenFactory(datenbankInterface));
    Themengebiete themengebiete = new Themengebiete(gamemaster);
    themengebiete.anzeigen();
  } // end of main

  // Ende Methoden
} // end of class Themengebiete

