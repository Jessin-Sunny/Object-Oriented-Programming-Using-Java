import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator implements ActionListener
{
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bm,bd,bc,be;
    JTextField txt=new JTextField();
    JFrame jfrm=new JFrame();
    int op=0;
    double a,b,r;
    boolean exc;
    public Calculator()
    {
        jfrm.setTitle("Calculator");
        jfrm.setBounds(50,50,350,500);
        jfrm.setLayout(null);
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
        jfrm.setVisible(true);

        txt.setBounds(30,40,275,50);
        jfrm.add(txt);

        b0=new JButton("0");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        ba=new JButton("+");
        bs=new JButton("-");
        bm=new JButton("*");
        bd=new JButton("/");
        be=new JButton("=");
        bc=new JButton("Clear(X)");

        b7.setBounds(40,100,50,40);
        jfrm.add(b7);
        b8.setBounds(110,100,50,40);
        jfrm.add(b8);
        b9.setBounds(180,100,50,40);
        jfrm.add(b9);
        b4.setBounds(40,170,50,40);
        jfrm.add(b4);
        b5.setBounds(110,170,50,40);
        jfrm.add(b5);
        b6.setBounds(180,170,50,40);
        jfrm.add(b6);
        b1.setBounds(40,240,50,40);
        jfrm.add(b1);
        b2.setBounds(110,240,50,40);
        jfrm.add(b2);
        b3.setBounds(180,240,50,40);
        jfrm.add(b3);
        b0.setBounds(40,310,90,40);
        jfrm.add(b0);
        bc.setBounds(140,310,90,40);
        jfrm.add(bc);
        ba.setBounds(250,100,50,40);
        jfrm.add(ba);
        bs.setBounds(250,170,50,40);
        jfrm.add(bs);
        bm.setBounds(250,240,50,40);
        jfrm.add(bm);
        bd.setBounds(250,310,50,40);
        jfrm.add(bd);
        be.setBounds(40,380,265,40);
        jfrm.add(be);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        be.addActionListener(this);
        bc.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b0)
        {
            txt.setText(txt.getText().concat("0"));
        }
        if(e.getSource()==b1)
        {
            txt.setText(txt.getText().concat("1"));
        }
        if(e.getSource()==b2)
        {
            txt.setText(txt.getText().concat("2"));
        }
        if(e.getSource()==b3)
        {
            txt.setText(txt.getText().concat("3"));
        }
        if(e.getSource()==b4)
        {
            txt.setText(txt.getText().concat("4"));
        }
        if(e.getSource()==b5)
        {
            txt.setText(txt.getText().concat("5"));
        }
        if(e.getSource()==b6)
        {
            txt.setText(txt.getText().concat("6"));
        }
        if(e.getSource()==b7)
        {
            txt.setText(txt.getText().concat("7"));
        }
        if(e.getSource()==b8)
        {
            txt.setText(txt.getText().concat("8"));
        }
        if(e.getSource()==b9)
        {
            txt.setText(txt.getText().concat("9"));
        }
        if(e.getSource()==ba)
        {
            a=Double.parseDouble(txt.getText());
            op=1;
            txt.setText(null);
        }
        if(e.getSource()==bs)
        {
            a=Double.parseDouble(txt.getText());
            op=2;
            txt.setText(null);
        }
        if(e.getSource()==bm)
        {
            a=Double.parseDouble(txt.getText());
            op=3;
            txt.setText(null);
        }
        if(e.getSource()==bd)
        {
            a=Double.parseDouble(txt.getText());
            op=4;
            txt.setText(null);
        }
        if(e.getSource()==be)
        {
            b=Double.parseDouble(txt.getText());
            exc=false;
            switch(op)
            {
                case 1: r=a+b;
                        break;
                case 2: r=a-b;
                        break;
                case 3: r=a*b;
                        break;
                case 4: 
                        try
                        {
                            if(b==0)
                            {
                                exc=true;
                                throw new ArithmeticException("Cannot Divide by zero");    
                            }
                            else
                            {
                                r=a/b;
                                break;
                            }
                        }
                        catch (ArithmeticException ex) 
                        {
                            txt.setText("ERROR : "+ex.getMessage());
                        }
            }
            if(exc==false)
            {
                txt.setText(""+r);
            }
        }
        if(e.getSource()==bc)
        {
            txt.setText(null);
        }
    }
}



public class Pgm13
{
    public static void main(String args[])
    {
        Calculator cal=new Calculator();
    }
}
