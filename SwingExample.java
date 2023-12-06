import javax.swing.*;
class SwingE
{
    SwingE()
    {
        JFrame jfrm=new JFrame();
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setTitle("Java Swing Program");
        JLabel Jlab=new JLabel("POWERFUL");
        jfrm.add(Jlab);
        jfrm.setVisible(true);
    }
}
public class SwingExample
{
    public static void main(String args[])
    {
        SwingE sw=new SwingE();
    }
}