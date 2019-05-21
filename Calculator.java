package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;

	public Calculator(String name){
    	super(name);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(new Dimension(800,600));
    	setLayout(new BorderLayout());
    	
    	JPanel numPanel = new JPanel();
    	numPanel.setLayout(new GridLayout(4,0));
    	JPanel operandPanel = new JPanel();
    	operandPanel.setLayout(new GridLayout(4,0));
    	JTextField ioField = new JTextField();
    	ioField.setEditable(false);
    	
    	add(ioField, "North");
    	add(numPanel, "West");
    	add(operandPanel, "East");
    	
    	JButton[] numButton = new JButton[12];
    	String[] numButtonText = {
    			"7", "8", "9",
    			"4", "5", "6",
    			"1", "2", "3",
    			"+-", "0", ".",
    	};
    	JButton[] operandButton = new JButton[8];
     	String[] operandButtonText = {
    			"+", "-", "*", 
    			"/", "x²", "\u221A",
    			"C", "="
    	};
     	
    	for(int i = 0; i < numButtonText.length; i++) {
    		numButton[i] = new JButton(numButtonText[i]);
    	}
    	for(int i = 0; i < operandButtonText.length; i++) {
    		operandButton[i] = new JButton(operandButtonText[i]);
    	}
    	          
    	for (JButton btn : numButton) {
			numPanel.add(btn);
		}
    	for (JButton btn : operandButton) {
    		operandPanel.add(btn);
    	}
		
		//Font f = new Font("Arial", Font.BOLD | Font.ITALIC, 50);
		//button.addActionListener(new ExitListener());

		//add(button);

		pack();
		setLocationRelativeTo(null);
    }
}
