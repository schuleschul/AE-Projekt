package gui;

import backend.Frage;
import backend.Gamemaster;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * GUI-Schwierigkeitsgrad
 *
 * @version 1.0 vom 06.06.2021
 * @St�phane Matot
 */

public class Schwierigkeitsgrad extends JFrame {

  
  public Schwierigkeitsgrad(Gamemaster gamemaster) {
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
    setTitle("Quiz_Schwierigkeitsauswahl");
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
    lSchwierigkeitsgrad.setBounds(224, 32, 184, 48);
    lSchwierigkeitsgrad.setText("Schwierigkeitsgrad");
    lSchwierigkeitsgrad.setFont(new Font("Arial Narrow", Font.BOLD, 24));
    cp.add(lSchwierigkeitsgrad);
    

    jSchwierigkeitsgrad.setModel(jSchwierigkeitsgradModel);
    jSchwierigkeitsgrad.setBounds(184, 224, 249, 41);

    cp.add(jSchwierigkeitsgrad);
    // Ende Komponenten
    

  } // end of public Schwierigkeitsgrad
  
  // Anfang Methoden

  public void anzeigen()
  {
    for(Frage.Schwierigkeit schwierigkeit : Frage.Schwierigkeit.values())
    {
      jSchwierigkeitsgradModel.addElement(schwierigkeit.toString());
      if(gamemaster.getMaxSchwierigkeit() == schwierigkeit) break;
    }
    jSchwierigkeitsgradModel.setSelectedItem(jSchwierigkeitsgradModel.getElementAt( (jSchwierigkeitsgradModel.getSize() -1) ));   //machts schöner

    setVisible(true);
  }

  private class ButtonListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      for(Frage.Schwierigkeit schwierigkeit : Frage.Schwierigkeit.values())
      {
        if(schwierigkeit.toString().equals(jSchwierigkeitsgradModel.getSelectedItem()))
        {
          gamemaster.setSchwierigkeit(schwierigkeit);
          Quizscreen quizscreen = new Quizscreen(gamemaster);
          Schwierigkeitsgrad.this.dispose();
          quizscreen.anzeigen();
        }
      }
    }
  }

  // Anfang Attribute
  private Gamemaster gamemaster;

  private JLabel rahmen_bg_layer = new JLabel();
  private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("../images/rahmen_bg.png"));
  private JLabel lSchwierigkeitsgrad = new JLabel();
  private JButton bAbsenden = new JButton();

  private JLabel lFalscheAntwort3 = new JLabel();
  private JComboBox<String> jSchwierigkeitsgrad = new JComboBox<String>();
  private DefaultComboBoxModel<String> jSchwierigkeitsgradModel = new DefaultComboBoxModel<String>();
  // Ende Attribute
  
//  public static void main(String[] args) {
//    new Schwierigkeitsgrad();
//  } // end of main
  


  // Ende Methoden
} // end of class Schwierigkeitsgrad

