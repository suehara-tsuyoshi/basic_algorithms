import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class MainPanel extends JPanel{
     private static final int Width = 240;
     private static final int Height = 240;
     
    public MainPanel(){
        setPreferredSize(new Dimension(Width,Height));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(10, 10, 100, 10);

        g.setColor(Color.RED);

       

        g.drawRect(10, 20, 40, 40);

        g.fillRect(60, 20, 40, 40);

       
        g.setColor(Color.BLUE);

      
        g.drawOval(10, 70, 40, 40);

        g.fillOval(60, 70, 40, 40);
    }
}
