import java.util.Comparator;

/**
 * Created by MoreFamily on 3/13/2016.
 */
//public class Dog {
//}
//
//class Dog
//{
//
//}
public class Dog implements Comparable<Dog>,Comparator<Dog>
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    int age;

    public Dog()
    {

    }

    public Dog(String dogName, int age)
    {
        name = dogName;
        this.age = age;
    }

    //override the comapreTo method
    @Override
    public int compareTo(Dog d)
    {
        return (this.name).compareTo(d.name);
    }

    @Override
    public int compare(Dog d1, Dog d2)
    {
        return d1.age - d2.age;
    }
}
