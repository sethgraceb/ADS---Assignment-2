
import java.util.LinkedList;


public class TST<Value> {
	private int size; 	//size
	//private TrieNode<Value> root;
  /*
   * Bus Service Questions:
   * 1. How many unique destinations is there in the file?
   *    //171
   * 2. Is there a bus going to the destination "SOUTHSIDE"?
   *    //yes
   * 3. How many records is there about the buses going to the destination beginning with "DOWN"?
   *    //70
   *
   * Google Books Common Words Questions:
   * 4. How many words is there in the file?
   *    //97565
   * 5. What is the frequency of the word "ALGORITHM"?
   *    //14433021
   * 6. Is the word "EMOJI" present?
   *   //NO
   * 7. IS the word "BLAH" present?
   *   //YES
   * 8. How many words are there that start with "TEST"?
   *    //39
   */
  /* A Node in your trie containing a Value val and a pointer to its children */
  private static class TrieNode<Value> {
	   // private int size = 0; //how many words
		private char c;                        // character
        private TrieNode<Value> left, mid, right;  // left, middle, and right subtries
        private Value val;                     // value associated with string
  }

  /* a pointer to the start of your trie */
  private TrieNode<Value> root = new TrieNode<Value>();

  /*
   * Returns the number of words in the trie
   */
  public int size() {
    //TODO: Implement method
    return size;
  }

  /*
   * returns true if the word is in the trie, false otherwise
   */
  public boolean contains(String key) {
      return get(key) != null;
   // return false;
  }

  /*
   * return the value stored in a node with a given key, returns null if word is not in trie
   */
  public Value get(String key) {
    //TODO: implement method
  TrieNode<Value> x = get(root, key, 0);
      if (x == null) return null;
      return x.val;
    //return null;
  }
//return subtrie corresponding to given key
  private TrieNode<Value> get(TrieNode<Value> x, String key, int d) {
      if (x == null) return null;
 
      char c = key.charAt(d);
      if      (c < x.c)              return get(x.left,  key, d);
      else if (c > x.c)              return get(x.right, key, d);
      else if (d < key.length() - 1) return get(x.mid,   key, d+1);
      else                           return x;
  }

  /*
   * stores the Value val in the node with the given key
   */
  public void put(String key, Value val) {
          if (!contains(key)) size++;
      root = put(root, key, val, 0);
  }
  private TrieNode<Value> put(TrieNode<Value> x, String key, Value val, int d) {
      char c = key.charAt(d);
      if (x == null) {
          x = new TrieNode<Value>();
          x.c = c;
      }
      if      (c < x.c)               x.left  = put(x.left,  key, val, d);
      else if (c > x.c)               x.right = put(x.right, key, val, d);
      else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
      else                            x.val   = val;
      return x;
  }

  /*
   * returns the linked list containing all the keys present in the trie
   * that start with the prefix passes as a parameter, sorted in alphabetical order
   */
  public LinkedList<String> keysWithPrefix(String prefix) {
    
      LinkedList<String> queue = new LinkedList<String>();
      TrieNode<Value> x = get(root, prefix, 0);
      if (x == null) return queue;
      if (x.val != null) queue.add(prefix);
      collect(x.mid, new StringBuilder(prefix), queue);
      return queue; 
    //return null;
  }
  private void collect(TrieNode<Value> x, StringBuilder prefix, LinkedList<String> queue) {
		if (x == null) return;
		collect(x.left, prefix, queue);
		if (x.val != null) queue.add(prefix.toString() + x.c);
		collect(x.mid,   prefix.append(x.c), queue);
		collect(x.right, prefix,       queue);
	}
  
}