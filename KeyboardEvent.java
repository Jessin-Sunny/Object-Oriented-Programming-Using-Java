/*Program for handling KeyBoard Events*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KeyEvents //implements KeyListener
{
    KeyEvents()
    {
        JFrame jfrm=new JFrame("KeyBoard Events");
        jfrm.setSize(800,800);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlab=new JLabel("Enter the text ");
        jlab.setBounds(5,5,100,100);
        jfrm.add(jlab);
        JTextField jf=new JTextField();
        jf.setBounds(0,0,500,50);
        jfrm.add(jf);
        jfrm.setVisible(true);

        jf.addKeyListener(new KeyListener() 
        {
            public void keyPressed(KeyEvent ke)
            {
                jlab.setText("Key Pressed : "+ke.getKeyChar());
            }
            public void keyTyped(KeyEvent ke)
            {
                jlab.setText("Key Typed : "+ke.getKeyChar());
            }
            public void keyReleased(KeyEvent ke)
            {
                jlab.setText("Key Released : "+ke.getKeyChar());
            }
        });
    }
}

public class KeyboardEvent
{
    public static void main(String args[])
    {
        KeyEvents ke=new KeyEvents();
    }
}