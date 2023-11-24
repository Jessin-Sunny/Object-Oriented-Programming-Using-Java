/*Java program for the following
1) Create a doubly linked list of elements.
2) Delete a given element from the above list.
3) Display the contents of the list after deletion. 
*/
import java.io.*;
import java.util.Scanner;
class Node 
{
    int data;
    Node prev;
    Node next;

    Node(int data) 
    {
        this.data = data;
        prev = null;
        next = null;
    }
}

class DoubleLinkedList 
{
    Node head;

    void insert(int data)
    {
        Node newnode = new Node(data);
        if (head == null) 
        {
            head = newnode;
        } else 
        {
            Node temp;
            temp = head;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    void delete(int data)
    {
        Node temp, ptr;
        temp = head;
        while (temp!= null) {
            if (temp.data == data) {
                if (temp.prev == null) // deleting node is head node
                {
                    head = temp.next;
                    if(temp.next!=null)
                    {
                        head.prev = null;
                    }
                } else if (temp.next == null) // deleting node is last node
                {
                    temp = temp.prev;
                    temp.next = null;
                } else // deleting node is any node b/w head and last
                {
                    ptr = temp.prev; // previous node is stored in ptr
                    ptr.next = temp.next;
                    temp = temp.next;
                    temp.prev = ptr;
                }
                break;
            }
            temp = temp.next;
        }
    }

    void display() {
        Node temp;
        temp = head;
        if (temp==null)
        {
            System.out.println("List is EMPTY");
        } 
        else 
        {
            while (temp!=null)
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
}

public class Pgm16 {
    public static void main(String args[])
    {
        int value,n,data;
        char ch='y';
        Scanner reader=new Scanner(System.in);;
        DoubleLinkedList obj=new DoubleLinkedList();
        while (ch=='y'||ch=='Y')
        {
        System.out.print("1 : CREATE\n2 : DELETE\n3 : DISPLAY\n");
        System.out.print("Enter your choice : ");
        value=reader.nextInt();
        switch(value)
        {
            case 1: System.out.print("How many elements ? : ");
                    n=reader.nextInt();
                    System.out.print("Enter the elements : ");
                    for(int i=0;i<n;i++)
                    {
                        data=reader.nextInt();
                        obj.insert(data);
                    }
                    break;

            case 2: System.out.print("Enter the data to be deleted : ");
                    data=reader.nextInt();
                    obj.delete(data);
                    break;
        
            case 3: obj.display();
                    System.out.println();
                    break;

            default : System.out.println("Invalid Choice!!\n");
        }
        System.out.print("Do you want to continue ?(y/n) : ");
        ch=reader.next().charAt(0);
    }
    }
}
