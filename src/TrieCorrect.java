import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

/**
 * Created by MoreFamily on 5/14/2016.
 */
public class TrieCorrect {

    private TNode root;

    public TrieCorrect(){
        root = new TNode();
    }

    public void insert(String word){
        Map<Character, TNode> children = root.children;
        word = word.toLowerCase();
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);

            TNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }
            else{
                t = new TNode(c);
                children.put(c,t);
            }

            if(i ==0)
                t.setParentNode(t);

            if(i == word.length()-1) {
                t.isLeaf = true;
                t = t.getParentNode();
                t.isWord = true;
            }

            children = t.children;
        }
    }

    //search Word
    public boolean search(String word){
        TNode t = searchNode(word);
        if(t!=null && t.isWord){
            return true;
        }
        else return false;
    }

    //Search Node
    private TNode searchNode(String s){
        Map<Character,TNode> children = root.children;
        TNode t = null;

        for(int i= 0; i < s.length()-1;i++){
            char c = s.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
                return t;
            }
            else
                return null;
        }
        return t;
    }

    class TNode{

        char c;
        Map<Character, TNode> children = new HashMap<>();
        boolean isLeaf;
        boolean isWord = false;

        public TNode getParentNode() {
            return parentNode;
        }

        public void setParentNode(TNode parentNode) {
            this.parentNode = parentNode;
        }

        TNode parentNode;
        public TNode(){

        }

        public TNode(char c){
            this.c = c;
        }
    };

    public static void main(String[] args){
        TrieCorrect t = new TrieCorrect();
        t.insert("trie");
        t.insert("tree");
        t.insert("tent");
        t.insert("bent");

        System.out.println("word present in tree:" +t.search("bent"));

    }
}
