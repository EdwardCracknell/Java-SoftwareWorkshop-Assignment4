
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import predictive.Dictionary;
import predictive.PredictivePrototype;

/**
 * 
 * @author Edward Cracknell
 * 
 *         Stores the dictionary in a map so that for any signature (key) the
 *         given set of words (values) can be given very quickly.
 *
 */
public class MapDictionary implements Dictionary {

	private TreeMap<String, Set<String>> dictionary;

	/**
	 * 
	 * @param path
	 *            is the directory that our dictionary file is in
	 * 
	 */
	public MapDictionary(String path) {
		dictionary = new TreeMap<String, Set<String>>();

		try {
			Scanner s = new Scanner(new File(path));

			while (s.hasNext()) {

				String line = s.nextLine().toLowerCase();
				String signature = PredictivePrototype.wordToSignature(line);
				if (PredictivePrototype.validWord(line)) {
					if (dictionary.containsKey(signature)) {

						Set<String> words = dictionary.get(signature);
						if (!words.contains(line)) {
							words.add(line);
						}
					} else {
						Set<String> words = new TreeSet<String>();
						words.add(line);
						dictionary.put(signature, words);

					}

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * this method finds possible words that correspond to a a given signature
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		if (signature.equals("")) {
			return new TreeSet<String>();
		} else {
			return dictionary.get(signature);
		}
	}

	// public static void main(String[] args) {
	// MapDictionary md = new MapDictionary("words");
	// System.out.println(md.signatureToWords("75"));
	// }
}