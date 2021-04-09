import java.util.ArrayList;
import java.util.Observable;

/**
 * 
 * @author Edward Cracknell
 * 
 *         The Model holds the code to take in a dictionary and read it into a
 *         list of words of type string. These words will correspond to a
 *         signature. With a method to pick a word from the list of strings the
 *         predictive text comes to life.
 *
 */
public class DictionaryModel extends Observable {

	private MapDictionary dictionary;
	private String currentSig;
	private String message;
	private int position;
	private ArrayList<String> strings;
	private ArrayList<Character> useful;

	/**
	 * 
	 * @param dictionary
	 *            is the MapDictionary that were searching through to find out
	 *            words for a given signature
	 */
	public DictionaryModel(MapDictionary dictionary) {
		this.dictionary = dictionary;
		this.currentSig = "";
		this.message = "";
		this.position = 0;
		this.strings = new ArrayList<String>();
		this.useful = new ArrayList<Character>();
	}

	/**
	 * 
	 * @param c
	 *            char that were adding to our word
	 * 
	 *            this method adds a signature of type char to our current
	 *            signature and then goes to the dicionary and finds the words
	 *            that correspond to that signature. Once the arraylist is
	 *            updated we set the change and update the observer which is the
	 *            view.
	 */
	public void addChar(char c) {
		currentSig += c;

		strings = new ArrayList<String>();

		strings.addAll(dictionary.signatureToWords(currentSig));

		position = 0;

		// markes a change as happening
		setChanged();
		// tells the view of the change that has been made
		notifyObservers();
	}

	/**
	 * this method will change the position were at in the array of words so
	 * that we can click through the possible words for a signature
	 */
	public void incWord() {
		position++;
		if (position >= strings.size()) {
			position = 0;
		}

		setChanged();

		notifyObservers();
	}

	/**
	 * 
	 * @return String that is the word in our ArrayList that corresponds to the
	 *         position were at
	 */
	public String currentWord() {
		return strings.get(position);
	}

	/**
	 * this method will put a space in between what has been written and the
	 * word that we are writing
	 * 
	 */
	public void spaceBar() {
		message = message + " " + currentWord();
		currentSig = "";
	}

	public MapDictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(MapDictionary dictionary) {
		this.dictionary = dictionary;
	}

	public String getCurrentSig() {
		return currentSig;
	}

	public void setCurrentSig(String currentSig) {
		this.currentSig = currentSig;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ArrayList<String> getStrings() {
		return strings;
	}

	public void setStrings(ArrayList<String> strings) {
		this.strings = strings;
	}

}
