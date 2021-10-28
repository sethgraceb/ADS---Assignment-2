//import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class KMPSearchTest {

//  @Test
//  public void testEmpty(){
//    assertEquals("Empty text or pattern is invalid",-1,KMPSearch.searchFirst("",""));
//    assertEquals("Empty text or pattern is invalid",0,KMPSearch.searchAll("",""));
//    assertFalse("Empty text or pattern is invalid",KMPSearch.contains("",""));
//  }
  @Test
  public void testContains(){
	  //KMPSearch kmp = new KMPSearch("bababanagagaga");
	 // KMPSearch.contains("bababanagagaga", "naga");
  String a = "aaaa";
  String b = "aa";
  //assertEquals("",true,KMPSearch.contains(a,b));
	  assertTrue("",KMPSearch.contains(a, b));
	  //assertFalse("",KMPSearch.contains("bababanagagaga", "naga"));
	  
	  
  }
  @Test
  public void testSearchFirst(){
	  KMPSearch kmp = new KMPSearch("bababanagagaga");
	  String txt = "babanbanagaaa";
	  KMPSearch.searchFirst(txt, "ba");
	  assertEquals("",0,KMPSearch.searchFirst(txt,"ba"));
	  //kmp.searchAll(txt, "an");
	  assertEquals("",0,KMPSearch.searchAll("abcdefga","a"));
	  
  }
}
