package CAB;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SetMap {

 BufferedImage bufImage = null;
JButton jb;
 public enum State { IDLE, DRAGGING }

 
  final Color INITIAL_COLOR = Color.RED;
 
  Color color = INITIAL_COLOR;
 
   State state = State.IDLE;
   Point start = null;
   Point end   = null;

 
   JPanel panel;

   int x,y;
   JLabel label;
 
   public static void main(String args[]) throws IOException {
    SetMap sm=new SetMap();
    
   sm.newframe();
  
  }

 
   public  void CreateFrame() throws IOException {

   makeFrame();


    JFrame f;
    f = new JFrame();
   // f.setSize(1300, 800);
    f.setLayout(new BorderLayout());
    f.add(panel);
    f.pack();
    f.setVisible(true);

  }

    public void newframe(){
  JFrame frame = new JFrame("Cab Service ");
  frame.setSize(800, 600);
 
  frame.setVisible(true);
  //frame.setBackground(Color.CYAN);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   JButton jb=new JButton("Set Name of Places ");
   jb.setBounds(100, 100, 20, 50);

   JPanel jp=new JPanel();
   jp.setBackground(Color.gray);
   jp.add(jb); 
   frame.add(jp);
  JPanel jp1=new JPanel();
   jp1.setBackground(Color.gray);
   frame.add(jp1);
  
  
  frame.add(jp);
 jb.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                try {
                    CreateFrame();
    
                } catch (IOException ex) {
                    Logger.getLogger(SetMap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
 
  
  }

  public void makeFrame() throws IOException {
  
    panel = new JPanel() {
      public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        if (bufImage == null) {
            int w = this.getWidth();
            int h = this.getHeight();
            bufImage  = new BufferedImage(800,500, BufferedImage.TRANSLUCENT);
            Graphics2D gc = bufImage.createGraphics();
        }

        g2.drawImage(bufImage, null, 0, 0);
        if (state == State.DRAGGING) {
          g2.drawLine(start.x, start.y, end.x  , end.y);
        }
      }

      public Dimension getPreferredSize() {
        return new Dimension(1300, 800);
      }
    };

    panel.addMouseListener(new MouseListener() {
      @Override
     
     
       public void mouseClicked(MouseEvent e){
         
             x = e.getX();
             y = e.getY();
          label= new JLabel();

          String name = JOptionPane.showInputDialog("Enter the name of City");
   
      if(name.equals("Jodhpur")){
          ImageIcon img=new ImageIcon("jodhpur.jpg");
          label.setIcon(img);
       }
      else if(name.equals("Pali"))
      {
      ImageIcon img=new ImageIcon("pali.jpg");
          label.setIcon(img);
     
     
      }
      else if(name.equals("Mahendipur Balajee"))
      {
      ImageIcon img=new ImageIcon("Mahendipur Balijee.jpg");
          label.setIcon(img);
     
     
      }
      else if(name.equals("Nadoti"))
      {
      ImageIcon img=new ImageIcon("Nadoti.jpg");
          label.setIcon(img);
      }
      else if(name.equals("Jaipur"))
      {
      ImageIcon img=new ImageIcon("jaipur.jpg");
          label.setIcon(img);
      }
      else if(name.equals("Ratanada Headoffice"))
      {
      ImageIcon img=new ImageIcon("Ratanada.jpg");
          label.setIcon(img);
      }
      else
      {
      ImageIcon img=new ImageIcon("Other.jpg");
          label.setIcon(img);
     
     
      }

          label.setLayout(new BorderLayout(
                  ));
                panel.add(label);
    
     label.setBounds(x,y,65,60);
     label.setToolTipText(name);
    
    }
     

      @Override
      public void mousePressed(MouseEvent me) {
      }

      @Override
      public void mouseReleased(MouseEvent me) {
       
        state = State.IDLE;
      }

      @Override
      public void mouseEntered(MouseEvent me) {
      }

      @Override
      public void mouseExited(MouseEvent me) {
      }
    });

    panel.addMouseMotionListener(new MouseMotionListener() {

      @Override
      public void mouseDragged(MouseEvent me) {
        state = State.DRAGGING;
        end   = me.getPoint();
        if (state == State.DRAGGING) {
            Graphics2D g2 = bufImage.createGraphics();
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(start.x, start.y, end.x, end.y);
            panel.repaint();
        }
        start = end;
      }

      @Override
      public void mouseMoved(MouseEvent me) {
       
        start = me.getPoint();
      }
    });

   
    panel.setOpaque(true);
 //^ out.close();
  }

}