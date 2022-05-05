package views.spielerei;

import java.awt.*;

import java.awt.event.*;
 
import javax.swing.*;
 
public class buttonfaballa extends JFrame implements ActionListener {
 
    Color bgColor;
 
    JButton jbRot, jbGelb, jbGruen, jbNeutral, jbStop;
 
    Container cp;
 

 
    public buttonfaballa(String title)  {
 
        super(title);
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        cp = getContentPane();
 
        
 
        cp.setLayout(new FlowLayout());
 
        bgColor = getBackground();
 

 
        jbRot = new JButton("flasch");
 
        jbRot.addActionListener(this);
 
        cp.add(jbRot);
 

 
        jbGelb = new JButton("teilweise richtig");
 
        jbGelb.addActionListener(this);
 
        cp.add(jbGelb);
 

 
        jbGruen = new JButton("Richtig");
 
        jbGruen.addActionListener(this);
 
        cp.add(jbGruen);
 

 
        jbNeutral = new JButton("wtf XD");
 
        jbNeutral.addActionListener(this);
 
        cp.add(jbNeutral);
 

 
        jbStop = new JButton("Ende");
 
        jbStop.addActionListener(this);
 
        cp.add(jbStop);
 

 
        setSize(400, 200);
 
        setVisible(true);
 
    }
 

 
    public void actionPerformed(ActionEvent e) {
 
        Object obj = e.getSource();
 
     
 
        if (obj == jbRot) cp.setBackground(Color.RED);
 
        if (obj == jbGelb) cp.setBackground(Color.YELLOW);
 
        if (obj == jbGruen) cp.setBackground(Color.GREEN);
 
        if (obj == jbNeutral) cp.setBackground(bgColor);
 
        if (obj == jbStop) System.exit(0);
 
    }
 

 
    public static void main(String[] args) {
        new buttonfaballa("Rot - Gelb - Grün");
    }
}
 