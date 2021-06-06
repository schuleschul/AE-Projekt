import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * GUI-Themenauswahl
 *
 * @version 1.0 vom 06.06.2021
 * @Stéphane Matot
 */

public class Themengebiete extends JFrame {
  // Anfang Attribute
  
  private JLabel rahmen_bg_layer = new JLabel();
    private ImageIcon rahmen_bg_layerIcon = new ImageIcon(getClass().getResource("images/rahmen_bg.png"));
  private JLabel lThemengebiete = new JLabel();  
  private JButton bAbsenden = new JButton();    
  
  private JLabel lFalscheAntwort3 = new JLabel();
  private JCheckBox cbThemengebiet1 = new JCheckBox();
  private JCheckBox cbThemengebiet = new JCheckBox();
  private JCheckBox cbThemengebiet3 = new JCheckBox();
  private JCheckBox cbThemengebiet4 = new JCheckBox();
  private JCheckBox cbThemengebiet5 = new JCheckBox();
  // Ende Attribute
  
  public Themengebiete() { 
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
    lThemengebiete.setBounds(248, 32, 149, 48);
    lThemengebiete.setText("Themengebiete");
    lThemengebiete.setFont(new Font("Arial Narrow", Font.BOLD, 24));
    cp.add(lThemengebiete);
    
    
    
    
    
    
    cbThemengebiet1.setBounds(240, 104, 153, 33);
    cbThemengebiet1.setOpaque(false);
    cbThemengebiet1.setText("Themengebiet 1");
    cp.add(cbThemengebiet1);
    cbThemengebiet.setBounds(240, 144, 153, 33);
    cbThemengebiet.setOpaque(false);
    cbThemengebiet.setText("Themengebiet 2");
    cp.add(cbThemengebiet);
    cbThemengebiet3.setBounds(240, 184, 153, 33);
    cbThemengebiet3.setOpaque(false);
    cbThemengebiet3.setText("Themengebiet 3");
    cp.add(cbThemengebiet3);
    cbThemengebiet4.setBounds(240, 224, 153, 33);
    cbThemengebiet4.setOpaque(false);
    cbThemengebiet4.setText("Themengebiet 4");
    cp.add(cbThemengebiet4);
    cbThemengebiet5.setBounds(240, 264, 153, 33);
    cbThemengebiet5.setOpaque(false);
    cbThemengebiet5.setText("Themengebiet 5");
    cp.add(cbThemengebiet5);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Themengebiete
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Themengebiete();
  } // end of main
  
  

  public void bAbsenden_ActionPerformed(ActionEvent evt) {
    // Button absenden...
    
  } // Ende bAbsenden_ActionPerformed

  // Ende Methoden
} // end of class Themengebiete

