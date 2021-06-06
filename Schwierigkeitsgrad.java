import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * GUI-Schwierigkeitsgrad
 *
 * @version 1.0 vom 06.06.2021
 * @Stéphane Matot
 */

public class Schwierigkeitsgrad extends JFrame {
  // Anfang Attribute
  
  private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("images/rahmen_bg.png"));
  private JLabel lSchwierigkeitsgrad = new JLabel();  
  private JButton bAbsenden = new JButton();    
  
  private JLabel lFalscheAntwort3 = new JLabel();
  private JComboBox<String> jSchwierigkeitsgrad = new JComboBox<String>();
    private DefaultComboBoxModel<String> jSchwierigkeitsgradModel = new DefaultComboBoxModel<String>();
  // Ende Attribute
  
  public Schwierigkeitsgrad() { 
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
    setTitle("quiz_Frageneditor");
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
    lSchwierigkeitsgrad.setBounds(224, 32, 184, 48);
    lSchwierigkeitsgrad.setText("Schwierigkeitsgrad");
    lSchwierigkeitsgrad.setFont(new Font("Arial Narrow", Font.BOLD, 24));
    cp.add(lSchwierigkeitsgrad);
    
    
    
    
    
    
    jSchwierigkeitsgrad.setModel(jSchwierigkeitsgradModel);
    jSchwierigkeitsgrad.setBounds(184, 224, 249, 41);
    jSchwierigkeitsgradModel.addElement("leicht");
    jSchwierigkeitsgradModel.addElement("mittel");
    jSchwierigkeitsgradModel.addElement("schwer");
    cp.add(jSchwierigkeitsgrad);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Schwierigkeitsgrad
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Schwierigkeitsgrad();
  } // end of main
  
  

  public void bAbsenden_ActionPerformed(ActionEvent evt) {
    // Button absenden...
    
  } // Ende bAbsenden_ActionPerformed

  // Ende Methoden
} // end of class Schwierigkeitsgrad

