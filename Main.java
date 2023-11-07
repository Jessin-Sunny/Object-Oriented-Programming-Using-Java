import animalpackage.*;
import animalpackage.Carnivores.*;
import animalpackage.Herbivores.*;
public class Main 
{
    public static void main(String[] args)
    {
        Animal obj;
        obj=new Cow();
        obj.get_cries();
        obj.get_eating_type();
        obj=new Elephant();
        obj.get_cries();
        obj.get_eating_type();
        obj=new Lion();
        obj.get_cries();
        obj.get_eating_type();
        obj=new Bear();
        obj.get_cries();
        obj.get_eating_type();
    }
}
