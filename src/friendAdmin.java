import java.util.*;

/**
 * Created by MoreFamily on 4/18/2016.
 */
public class friendAdmin {

    private Map<String, List<String>> friendMap;

    public friendAdmin(){
        friendMap = new HashMap<>();
    }

    //add Person
    private void addVertex(String s1){
        if(!friendMap.containsKey(s1))
        {
            List<String> dF = new ArrayList<>();
            friendMap.put(s1, dF);
            System.out.println("New Person Added: " + s1);
        }
    }

    //add friends of person
    private boolean addFriendEdge(String s1, String s2){
        if(friendMap.containsKey(s1)){
            friendMap.get(s1).add(s2);
            return true;
        }

        return false;
    }

    //adds a person and friend
    public void addFriend(String p1, String p2) throws NullPointerException{
        if(p1 == null || p2 == null){
            throw new NullPointerException("P1 or P2 cannot be null");
        }else{
            //Add Person
            //if(!friendMap.containsKey(p1))
            addVertex(p1);
            //add friends
            if(addFriendEdge(p1, p2)){
                System.out.println("New Friend Added: " + p2);
            };
        }
    }

    //removes friend of a person from AL
    public boolean removeFriend(String s1, String s2){
        List<String> dF = this.getDirectFriends(s1);
        for(String friend: dF){
            if(friend.equals(s2)){
                friendMap.get(s1).remove(friend);
                return true;
            }
        }
        return false;
    }

    //returns AL containing direct friends of person
    public List<String> getDirectFriends(String s1){

        if(friendMap.containsKey(s1))
        return new ArrayList<>(friendMap.get(s1));

        return null;
    }

    //BFS to get indirect friends of person
    public List<String> getIndirectFriends(String s1)throws NullPointerException{

        if(s1 == null) throw new NullPointerException("Friend cannot be null");
        List<String> IndirectFriends = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> Friends = this.getDirectFriends(s1);
        List<String> directFriends;

        q.add(s1);
        while(!q.isEmpty()) {
            String person = q.remove();
            directFriends = this.getDirectFriends(person);
            if (directFriends != null) {
                for (String friendOfPerson : directFriends) {
                    visited.add(friendOfPerson);
                    if (!Friends.contains(friendOfPerson))
                        IndirectFriends.add(friendOfPerson);
                    q.add(friendOfPerson);
                }
            }
        }

        return IndirectFriends;
    }

    //DFS to get friends of Person
    public List<String> getIndirectFriendsDFS(String s1){
        Stack<String> s = new Stack();
        List<String> indirectFriends = new ArrayList<>();
        Set<String> visited =  new HashSet<>();
        List<String> Friends = this.getDirectFriends(s1);
        List<String> directFriends;

        s.push(s1);

        while(!s.isEmpty()){
            String person = s.pop();
            directFriends = this.getDirectFriends(person);
            if(directFriends != null)
            {
                for(String friendOfPerson : directFriends){
                    visited.add(friendOfPerson);
                    if (!Friends.contains(friendOfPerson))
                        indirectFriends.add(friendOfPerson);
                    s.push(friendOfPerson);
                }
            }
        }

        return indirectFriends;

    }
}
