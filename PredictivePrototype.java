
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Edward Cracknell
 * 
 *         PredictivePrototype class has a wordToSignature and SignatureToWords
 *         method. I have also used a helper method that I have called isValid
 *         Word.
 * 
 *
 */

public class PredictivePrototype {

	/**
	 * 
	 * @param word of type String is the word we want to find the signature for 
	 * @return String that is the signature for the word we have given 
	 */
	public static String wordToSignature(String word) {

		word = word.toLowerCase();
		StringBuffer out = new StringBuffer();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			switch (c) {
			case 'a':
			case 'b':
			case 'c':
				out.append('2');
				break;
			case 'd':
			case 'e':
			case 'f':
				out.append('3');
				break;
			case 'g':
			case 'h':
			case 'i':
				out.append('4');
				break;
			case 'j':
			case 'k':
			case 'l':
				out.append('5');
				break;
			case 'm':
			case 'n':
			case 'o':
				out.append('6');
				break;
			case 'p':
			case 'q':
			case 'r':
			case 's':
				out.append('7');
				break;
			case 't':
			case 'u':
			case 'v':
				out.append('8');
				break;
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				out.append('9');
				break;
			default:
				out.append(' ');
				break;

			}
		}
		return out.toString();
	}

	public static boolean isValidWord(String word) {

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param signature 
	 * @return Set of strings that are all the words that correspond to the given signature 
	 */
	public static Set<String> signatureToWords(String signature) {

		TreeSet<String> set = new TreeSet<String>();
		Scanner s = null;

		try {
			s = new Scanner(new File("/usr/share/dict/words"));
		} catch (FileNotFoundException e) {
			System.out.println("word not found in dictionary");
		}

		while (s.hasNext()) {
			String w = s.nextLine();
			if (isValidWord(w)) {
				w = w.toLowerCase();
				if (wordToSignature(w).equals(signature)) {
					set.add(w);
				}

			}
		}
		return set;
	}
	
//	public static void main(String []args){
//		PredictivePrototype w = new PredictivePrototype();
//		System.out.println(w.signatureToWords("8425"));
//		System.out.println(w.wordToSignature("Abra Cadabra"));
//	}
}