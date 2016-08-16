import java.util.List;

/**
 * Created by MoreFamily on 4/18/2016.
 */
public class friendAdminTest {

    public static void main(String[] args){
        friendAdmin FA = new friendAdmin();

        FA.addFriend("Booboo", "Tiya");
        FA.addFriend("Booboo", "Xiangxiang");
        FA.addFriend("Booboo", "LaoLao");
        FA.addFriend("Booboo", "Baa");
        FA.addFriend("Tiya", "Hredhu");
        FA.addFriend("Xiangxiang", "Papa");

        List<String> df= FA.getDirectFriends("Booboo");
        System.out.println("Friends of Booboo: ");
        int count = 0;
        for(String friend: df){
            ++count;
            System.out.println("Friend"+count+": " + friend);
        }
        List<String> idf= FA.getIndirectFriends("Booboo");
        System.out.println("Indirect Friends of Booboo by BFS: ");
        count = 0;
        for(String friend: idf){
            ++count;
            System.out.println("Friend"+count+": " + friend);
        }

        List<String> idfs= FA.getIndirectFriendsDFS("Booboo");
        System.out.println("Indirect Friends of Booboo by DFS: ");
        count = 0;
        for(String friend: idf){
            ++count;
            System.out.println("Friend"+count+": " + friend);
        }


        FA.removeFriend("Booboo", "Baa");
        df= FA.getDirectFriends("Booboo");
        System.out.println("New Friends of Booboo: ");
         count = 0;
        for(String friend: df){
            ++count;
            System.out.println("Friend"+count+": " + friend);
        }

    }
}
