//import sun.text.normalizer.Trie;
//
//import java.util.HashMap;
//import java.util.Queue;
//import java.util.Set;
//
///**
// * Created by MoreFamily on 4/2/2016.
// */
//
//class Dictionary{
//
//    private TrieNode root;
//    private int size;
//    private Queue<TrieNode> q = null;
//
//    public Dictionary(){
//        root = new TrieNode();
//        size = 0;
//    }
//
//    /** Insert a word into the trie.
//     * For the basic part of the assignment (part 2), you should ignore the word's case.
//     * That is, you should convert the string to all lower case as you insert it. */
//    public boolean addWord(String word)
//    {
//        //TODO: Implement this method.
//        boolean bAddWord = false;
//        //convert word to lowerCase
//        //Only lowercase dictionary supported
//        word = word.toLowerCase();
//        TrieNode t = root;
//        TrieNode node;
//
//        //find node of each character in the word
//        for(int i =0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            //check first character if it already exist
//            //if not add it to TrieNode
//            if(i == 0)
//            {
//                //get the node containing character 'c'
//                t = root.getChild(c);
//                if(t == null) {
//                    //Add node to hashmap
//                    t = root.insert(c);
//                }
//            } else { //check if other characters exist in TrieNode
//                node = t;
//                t = t.getChild(c);
//                if(t == null) {
//                    t = node.insert(c);
//                }
//
//
//            }
//            //At end of word  increase size of words in hashmap
//            //set last node as endWord to true
//            if (word.length() - 1 == i) {
//                if(t.getText().equals(word.toLowerCase()))
//                {
//                    if(!t.endsWord()) {
//                        t.setEndsWord(true);
//                        bAddWord = true;
//                        ++size;
//                    }
//                }
//            }
//
//        }
//
//        return bAddWord;
//    }
//
//    /**
//     * Return the number of words in the dictionary.  This is NOT necessarily the same
//     * as the number of TrieNodes in the trie.
//     */
//    public int size()
//    {
//        //TODO: Implement this method
//        return size;
//    }
//
//
//    public boolean isWord(String s)
//    {
//        // TODO: Implement this method
//        TrieNode next = root;
//        s = s.toLowerCase();
//        for(int i =0; i < s.length(); i++)
//        {
//            char c = s.charAt(i);
//            TrieNode child = next.getChild(c);
//            if(child == null)
//            {
//                return false;
//            }
//            next = child;
//        }
//
//        return next.endsWord();
//    }
//
//    public String getText()
//    {
//        return text;
//    }
//
//    public void setEndsWord(boolean b)
//    {
//        isWord = b;
//    }
//
//    public boolean endsWord()
//    {
//        return isWord;
//    }
//
//    public Set<Character> getValidNextCharacters()
//    {
//        return children.keySet();
//    }
//
//
//}
//public class TrieNode {
//
//    private HashMap<Character, TrieNode> children;
//    private String text;
//    private boolean isWord;
//
//    public TrieNode()
//    {
//        children = new HashMap<>();
//        text = "";
//        isWord = false;
//    }
//
//    public TrieNode(String text)
//    {
//        this();
//        this.text = text;
//    }
//
//    public HashMap<Character , TrieNode> getChildren()
//    {
//        return children;
//    }
//
//    public TrieNode getChild(Character C)
//    {
//        return children.get(C);
//    }
//
//    public TrieNode insert(Character C)
//    {
//        if(children.containsKey(C))
//        {
//            return null;
//        }
//        else
//        {
//            TrieNode next = new TrieNode(this.text + C.toString());
//            children.put(C, next);
//            return next;
//        }
//    }
//
//
//    public static void main(String[] args){
//
//        TrieNode tN = new TrieNode();
//
//
//    }
//}
