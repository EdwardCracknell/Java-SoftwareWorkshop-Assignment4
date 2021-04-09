import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeypadView extends JPanel implements Observer {

	/**
	 * @author Edward Cracknell
	 * 
	 *         The view will hold all the JButtons and also have a space for the
	 *         JTextField. Using a JPanel content pane and a second JPanel for
	 *         the gridlayout with the JButtons I was able to get the GUI
	 *         looking correct.
	 */
	private DictionaryModel model;
	public JPanel contentPane;

	// These fields are made global so we can make them accessible outside the
	// setup method
	private JButton number1;
	private JButton number2;
	private JButton number3;
	private JButton number4;
	private JButton number5;
	private JButton number6;
	private JButton number7;
	private JButton number8;
	private JButton number9;
	private JButton star;
	private JButton space;
	private JButton hash;

	private JTextField text;

	public KeypadView(DictionaryModel model) {
		this.model = model;
		// on creation of the view, add it to the list of observers on the model
		this.model.addObserver(this);
		setup();
	}

	public JButton getNumber1() {
		return number1;
	}

	public JButton getNumber2() {
		return number2;
	}

	public JButton getNumber3() {
		return number3;
	}

	public JButton getNumber4() {
		return number4;
	}

	public JButton getNumber5() {
		return number5;
	}

	public JButton getNumber6() {
		return number6;
	}

	public JButton getNumber7() {
		return number7;
	}

	public JButton getNumber8() {
		return number8;
	}

	public JButton getNumber9() {
		return number9;
	}

	public JButton getHash() {
		return hash;
	}

	public JButton getSpace() {
		return space;
	}

	public JButton getStar() {
		return star;
	}

	/**
	 * setup method creates a new JPanel with a grid layout of 2,1 and then adds
	 * a text field to the top part. The bottom part has a second JPanel added
	 * to it with a GridLayout for all the JButtons.
	 */
	private void setup() {

		contentPane = new JPanel();
		add(contentPane);
		// Grid layout, with 2 rows, 1 column. For the JTextField and the second Grid Layout
		contentPane.setLayout(new GridLayout(2, 1));

		text = new JTextField();
		contentPane.add(text);

		// Grid Layout with 3 columns for the JButtons
		JPanel buttonPanel = new JPanel(new GridLayout(0, 3));

		number1 = new JButton("1");
		buttonPanel.add(number1);

		number2 = new JButton("abc 2");
		buttonPanel.add(number2);

		number3 = new JButton("def 3");
		buttonPanel.add(number3);

		number4 = new JButton("ghi 4");
		buttonPanel.add(number4);

		number5 = new JButton("jkl 5");
		buttonPanel.add(number5);

		number6 = new JButton("mno 6");
		buttonPanel.add(number6);

		number7 = new JButton("pqrs 7");
		buttonPanel.add(number7);

		number8 = new JButton("tuv 8");
		buttonPanel.add(number8);

		number9 = new JButton("wxyz 9");
		buttonPanel.add(number9);

		star = new JButton("*");
		buttonPanel.add(star);

		space = new JButton("0");
		buttonPanel.add(space);

		hash = new JButton("#");
		buttonPanel.add(hash);

		contentPane.add(buttonPanel);

	}

	/*
	 * The update method is called when the observable object (in this case the
	 * model) calls notifyObserevers here, we simply set the text in the
	 * JTextField object to the value that is passed to the notify observers (in
	 * this case, the word were typing)
	 */
	@Override
	public void update(Observable o, Object arg) {
		text.setText(model.getMessage() + " " + model.currentWord());

	}

}
