import static org.junit.Assert.*;

import org.junit.Test;

public class TSTTest {

  @Test
  public void testEmpty(){
    TST<Long> trie = new TST<>();
    assertEquals("size of an empty trie should be 0",0, trie.size());
    assertFalse("searching an empty trie should return false",trie.contains("null"));
    assertNull("getting from an empty trie should return null",trie.get("null"));
  }
  
  @Test
  public void testNotEmpty(){
	  TST<Long> trie = new TST<>();
	  
	    assertFalse(trie.contains("3"));
	    assertFalse(trie.contains("vi"));
	   // assertTrue(trie.contains("life"));
	    Long value = 224L;
	    Long value2 = 34L;
	    Long value3 = 87L;
	    trie.put("he", value);
	    trie.put("hell", value2);
	    trie.put("help", value3);
	    assertEquals("size of trie should be 3",3, trie.size());
	    assertTrue(trie.contains("help"));
	    //assertNotNull("",trie.get("he"));
	    assertEquals("",value, trie.get("he"));
	    assertEquals("",value2, trie.get("hell"));
	    assertEquals("",value3, trie.get("help"));
	    
	   // trie.keysWithPrefix("he");
	    //assertEquals("","[he, hell, hellp]", trie.keysWithPrefix("he"));
	    
	    
	    
  }
}