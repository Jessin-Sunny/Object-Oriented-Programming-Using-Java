abstract class Shape                //abstract class Shape
{
    abstract int numberOfSides();   //abstract method
}
class Rectangle extends Shape
{
    private int sides=4;
    int numberOfSides()
    {
        return sides;
    }
    void display()
    {
        System.out.println("Sides of a Rectangle : "+sides);
    }
}
class Triangle extends Shape
{
    private int sides=3;
    int numberOfSides()
    {
        return sides;
    }
    void display()
    {
        System.out.println("Sides of a Triangle : "+sides);
    }
}
class Hexagon extends Shape
{
    private int sides=6;
    int numberOfSides()
    {
        return sides;
    }

    void display()
    {
        System.out.println("Sides of a Hexagon : "+sides);
    }
}

public class Pgm5
{
    public static void main(String[] args)
    {
        Rectangle r=new Rectangle();
        Triangle t=new Triangle();
        Hexagon h=new Hexagon();
        r.display();
        t.display();
        h.display();;

    } 
}
