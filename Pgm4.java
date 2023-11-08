class Employee
{
    protected String name;            //instance variables
    protected int age;
    protected String phno;
    protected String address;
    protected long salary;
    public Employee()               //Non parameterised Constructor
    {
    }
    protected void printSalary()
    {
        System.out.println("Salary="+salary);
    }
}
class Officer extends Employee
{
    char specialization;
    char department;
    public Officer(String name,int age,String phno,String address,long  salary)
    {
        this.name=name;         //Parameterised Constructor
        this.age=age;
        this.phno=phno;
        this.address=address;
        this.salary=salary;
    }
    void display()
    {
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Phone Number : "+phno);
        System.out.println("Address : "+address);
    }
}
class Manager extends Employee
{
    protected String specialization;
    protected String department;
    public Manager(String name,int age,String phno,String address,long salary,String special,String dept)
    {
        this.name=name;         //Parameterised Constructor
        this.age=age;
        this.phno=phno;
        this.address=address;
        this.salary=salary;
        this.specialization=special;
        this.department=dept;
    }
    void display()
    {
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Phone Number : "+phno);
        System.out.println("Address : "+address);
        System.out.println("Salary : ");
        super.printSalary();
    }
}


public class Pgm4 
{
    public static void main(String[] args)
    {
        Officer o1=new Officer("John",35,"984568741","Kochi", 15000);
        o1.display();
        Manager m1=new Manager("Tom",45,"9988447521","Changanaserry",35000, "s","CSE");
       m1.display();

    }
}
