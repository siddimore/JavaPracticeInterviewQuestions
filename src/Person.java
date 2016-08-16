import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoreFamily on 4/21/2016.
 */

public class Person
{

    public String FirstName;
    public String LastName;
    public String SocialSecurityNumber;

    public Person(String givenName, String familyName, String number){
        this.FirstName = givenName;
        this.LastName = familyName;
        this.SocialSecurityNumber = number;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String input){
        this.LastName = input;
    }

    @Override
    public int hashCode(){
        return (int)Math.random()%10;
    }
    @Override
    public String toString() {
        return this.FirstName + " " + this.LastName + " ";
    }

    @Override
    public boolean equals(Object obj)
    {
        final Person other = (Person) obj;
//        if ((this.SocialSecurityNumber == null) ? (other.SocialSecurityNumber != null) : !this.SocialSecurityNumber.equals(other.SocialSecurityNumber)) {
//            return false;
//        }

        if(this.SocialSecurityNumber == null || other.SocialSecurityNumber == null || (this.SocialSecurityNumber != other.SocialSecurityNumber)){
            return false;
        }
        return true;
    }


    // returns items that in both listA and listB (the union)
    public static List<Person> UnionTwoLists(List<Person> listA, List<Person> listB) throws NullPointerException
    {
        List<Person> listC = null;
        //check for empty lists
        if(listA == null || listB == null){
            throw new NullPointerException("list cannot be empty");
        }
        listC = new ArrayList<>();
        // Iterate over list B and check if person Object is present in listA
        for(Person personB: listB){
            if(listA.contains(personB)){
                listC.add(personB);
            }
        }
        return listC;
        }

    public static void main(String[] args){
        Person p1 = new Person("Siddharth", "More", "12345");
        Person p2 = new Person("Test", "More", "123456");

        List<Person> listA = new ArrayList<>();
        listA.add(p1);
        List<Person> listB = new ArrayList<>();
        listB.add(p2);

        for(Person p: UnionTwoLists(listA,listB)){
            System.out.println(p.toString());
        }
    }
    }