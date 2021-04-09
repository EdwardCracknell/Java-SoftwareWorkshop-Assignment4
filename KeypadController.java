import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Edward Cracknell
 * 
 *         The Keypad controller will listen to the view for changes made( e.g.
 *         buttons pressed). If the view does show the Controller an event
 *         happening then the Controller will call on a method in the model
 *         depeding on what event happened.
 *
 */
public class KeypadController implements ActionListener {

	private DictionaryModel model;
	private KeypadView view;

	public KeypadController(DictionaryModel model, KeypadView view) {
		this.view = view;
		this.model = model;

		// this controller is the action listener for any number pressed
		view.getNumber1().addActionListener(this);
		view.getNumber2().addActionListener(this);
		view.getNumber3().addActionListener(this);
		view.getNumber4().addActionListener(this);
		view.getNumber5().addActionListener(this);
		view.getNumber6().addActionListener(this);
		view.getNumber7().addActionListener(this);
		view.getNumber8().addActionListener(this);
		view.getNumber9().addActionListener(this);
		view.getHash().addActionListener(this);
		view.getSpace().addActionListener(this);
		view.getStar().addActionListener(this);

	}

	/**
	 * if an action is performed an action event will occur. By checking the
	 * action event we can decide on the right method to do in the model
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// check the source of the action event
		if (e.getSource() == view.getNumber1()) {

		} else if (e.getSource() == view.getNumber2()) {
			model.addChar('2');
		} else if (e.getSource() == view.getNumber3()) {
			model.addChar('3');
		} else if (e.getSource() == view.getNumber4()) {
			model.addChar('4');
		} else if (e.getSource() == view.getNumber5()) {
			model.addChar('5');
		} else if (e.getSource() == view.getNumber6()) {
			model.addChar('6');
		} else if (e.getSource() == view.getNumber7()) {
			model.addChar('7');
		} else if (e.getSource() == view.getNumber8()) {
			model.addChar('8');
		} else if (e.getSource() == view.getNumber9()) {
			model.addChar('9');
		} else if (e.getSource() == view.getHash()) {

		} else if (e.getSource() == view.getSpace()) {
			model.spaceBar();
		} else if (e.getSource() == view.getStar()) {
			model.incWord();
		}

	}
}
