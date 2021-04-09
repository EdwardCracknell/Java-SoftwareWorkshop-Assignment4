import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeypadMain {

	public static void main(String[] args) {
		MapDictionary md = new MapDictionary("words");

		DictionaryModel model = new DictionaryModel(md);

		KeypadView view = new KeypadView(model);

		KeypadController controller = new KeypadController(model, view);

		// here we make our JFrame that we then set the size.
		JFrame frame = new JFrame("Predictive Text");
		frame.add(view);
		frame.setVisible(true);
		frame.setSize(800, 600);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();

	}

}
