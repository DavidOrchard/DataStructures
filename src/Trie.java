import java.util.*;

public class Trie {
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.addWord("dave");
		System.out.print("Does " + (t.containsWord("dave") ? "" : "not " ) + "contain dave");
	}
	public class Node {
		 
        private final Character ch;
        private final String value;
        private Map<Character, Node> children =  new java.util.HashMap<Character, Node>();
        private boolean isValidWord;
 
        public Node(char argChar, String argValue) {
                ch = argChar;
                value = argValue;
        }
 
        public boolean addChild(Node argChild) {
                if (children.containsKey(argChild.getChar())) {
                        return false;
                }
 
                children.put(argChild.getChar(), argChild);
                return true;
        }
 
        public boolean containsChildValue(char c) {
                return children.containsKey(c);
        }
 
        public String getValue() {
                return value.toString();
        }
 
        public char getChar() {
                return ch;
        }
 
        public Node getChild(char c) {
                return children.get(c);
        }
 
        public boolean isWord() {
                return isValidWord;
        }
 
        public void setIsWord(boolean argIsWord) {
                isValidWord = argIsWord;
 
        }
 
        public String toString() {
                return value;
        }
	}

 
        private Node root = new Node('\0', "");
 
        public Trie() {}
 
        public Trie(List<String> argInitialWords) {
                for (String word:argInitialWords) {
                        addWord(word);
                }
        }
 
        public void addWord(String argWord) {
                addWord(argWord.toCharArray());
        }
 
        public void addWord(char[] argWord) {
                Node currentNode = root;
 
                for (int i = 0; i < argWord.length; i++) {
                        if (!currentNode.containsChildValue(argWord[i])) {
                                currentNode.addChild(new Node(argWord[i], currentNode.getValue() + argWord[i]));
                        }
 
                        currentNode = currentNode.getChild(argWord[i]);
                }
 
                currentNode.setIsWord(true);
        }
 
        public boolean containsPrefix(String argPrefix) {
                return contains(argPrefix.toCharArray(), false);
        }
 
        public boolean containsWord(String argWord) {
                return contains(argWord.toCharArray(), true);
        }
 
        public Node getWord(String argString) {
                Node node = getNode(argString.toCharArray());
                return node != null && node.isWord() ? node : null;
        }
 
        public Node getPrefix(String argString) {
                return getNode(argString.toCharArray());
        }
 
        @Override
        public String toString() {
                return root.toString();
        }
 
        private boolean contains(char[] argString, boolean argIsWord) {
                Node node = getNode(argString);
                return (node != null && node.isWord() && argIsWord) || (!argIsWord && node != null);
        }
 
        private Node getNode(char[] argString) {
                Node currentNode = root;
 
                for (int i = 0; i < argString.length && currentNode != null; i++) {
                        currentNode = currentNode.getChild(argString[i]);
 
                        if (currentNode == null) {
                                return null;
                        }
                }
 
                return currentNode;
        }
}