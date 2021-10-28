import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class KMPSearch {

	private static int[][] dfa;
	private String pat;
	private String txt;
	private final int R;

	/*
	 * Bus Service Questions:
	 *
	 * 1. How many total vehicles is there information on? //TODO
	 *987
	 * 2. Does the file contain information about the vehicle number 16555?
	 * yes
	 *
	 * 3. Locate the first record about a bus heading to HAMPTON PARK //TODO
	 *19774
	 * 4. Does the file contain information about the vehicle number 9043409?
	 * no
	 */

	public KMPSearch(String pat) {
		this.pat = pat;
		this.R = 256;
		
		int M = pat.length();
		//int R = txt.length();
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int i = 0, j= 1; j < M; j++){
			for (int k = 0; k <R; k++){
				dfa[k][j] = dfa[k][i];
				dfa[pat.charAt(j)][j] = j+1;
				i = dfa[pat.charAt(j)][i];
			}
		}
		
	}

	/*
	 * The method checks whether a pattern pat occurs at least once in String
	 * txt.
	 *
	 */
	public static boolean contains(String txt, String pat) {
		
		return searchFirst(txt, pat) != 0;
	}

	/*
	 * The method returns the index of the first ocurrence of a pattern pat in
	 * String txt. It should return -1 if the pat is not present
	 */
	public static int searchFirst(String txt, String pat) {
		
		int m = pat.length();
		int n = txt.length();
		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == m)
			return i - m; // found
		// not found
		
		return -1;
	}

	/*
	 * The method returns the number of non-overlapping occurences of a pattern
	 * pat in String txt.
	 */
	public static int searchAll(String txt, String pat) {
		// TODO: Implementation
		//return (pat.length() - pat.replace(txt, "").length()) / txt.length();
		int count = 0;
		for (int i = pat.indexOf(txt); i != -1;
		     i = pat.indexOf(txt, i + txt.length()))
			count++;
		return count;
		
	}
	
}