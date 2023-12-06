import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EventDemo
{
    JLabel jlab;
    EventDemo()
    {
        JFrame jfrm=new JFrame();
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(500,200);
        jfrm.setTitle("Event Demo");
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
        

        //JLabel jlab=new JLabel();

        JButton jbtnA=new JButton("Alpha");
        JButton jbtnB=new JButton("Beta");

        jbtnA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                jlab.setText("Alpha was pressed");
            }
        });
        jbtnB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                jlab.setText("Beta was pressed");
            }
        });

        jfrm.add(jbtnA);
        jfrm.add(jbtnB);
        
        jlab=new JLabel("Press a Button : ");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
    public static void main(String args[])
    {
        EventDemo event=new EventDemo();
    }
}

