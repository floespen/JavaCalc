package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private Font f = new Font("Arial", Font.BOLD, 50);
	private JTextField ioField = new JTextField();
	private double operationMemo = 0;
	private String activeOperation = null;
	
	public Calculator(String name){
    	super(name);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(new Dimension(800,600));
    	setLayout(new BorderLayout());
    	
    	JPanel numPanel = new JPanel();
    	numPanel.setLayout(new GridLayout(4,0));
    	JPanel operandPanel = new JPanel();
    	operandPanel.setLayout(new GridLayout(4,0));
    	ioField.setEditable(false);
    	ioField.setText("0");
    	ioField.setFont(f);
    	ioField.setHorizontalAlignment(JTextField.RIGHT);
    	add(ioField, "North");
    	add(numPanel, "Center");
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
    		btn.setFont(f);
    		addNumButtonListener(btn);
    		numPanel.add(btn);
		}
  
    	for (JButton btn : operandButton) {
    		btn.setFont(f);
    		addOperationButtonListener(btn);
    		operandPanel.add(btn);
    	}
		
		pack();
		setLocationRelativeTo(null);
    }
	
	private void addOperationButtonListener(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = e.getActionCommand();
				String display = ioField.getText();
					
				switch(buttonText) {
				case "C": 
					ioField.setText("0");
					operationMemo = 0;
					activeOperation = null;
					
					break;
				case "+":
					if(activeOperation==null) {
						activeOperation = "+";
						operationMemo =  Double.parseDouble(display);
						ioField.setText("0");
					}else {
						ioField.setText(processLastOperation(operationMemo, display, activeOperation));
						activeOperation = "+";
					}
					break;
				case "-": 
					if(activeOperation==null) {
						activeOperation = "-";
						operationMemo =  Double.parseDouble(display);
						ioField.setText("0");
					}else {
						ioField.setText(processLastOperation(operationMemo, display, activeOperation));
						activeOperation = "-";
					}
					break;
				case "*": 
					if(activeOperation==null) {
						activeOperation = "*";
						operationMemo = Double.parseDouble(display);
						ioField.setText("0");
					}else {
						ioField.setText(processLastOperation(operationMemo, display, activeOperation));
						activeOperation = "*";
					}
					break;
				case "/":
					if(activeOperation==null) {
						activeOperation = "/";
						operationMemo =  Double.parseDouble(display);
						ioField.setText("0");
					}else {
						ioField.setText(processLastOperation(operationMemo, display, activeOperation));
						activeOperation = "/";
					}
					break;
				case "x²":
					ioField.setText(processInstantOperation(display, "x²"));
					break;
				case "\u221A":
					 ioField.setText(processInstantOperation(display, "\u221A"));
					 break;
				case "=":
					if(activeOperation!=null) {
						ioField.setText(processLastOperation(operationMemo, display, activeOperation));
						operationMemo = 0;
						activeOperation = null;
					}
					break;
				default: 	
					JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
					break;
				}
			}

			private String processInstantOperation(String display, String activeOperation) {
				double result = Double.parseDouble(display);
				switch (activeOperation) {
				case "\u221A":
					result = Math.sqrt(Double.parseDouble(display));
					break;
				case "x²":
					result = Double.parseDouble(display) * Double.parseDouble(display);
					break;
				default: 
					JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
					break;
				}
				return Double.toString(result);
			}

			private String processLastOperation(double operationMemo, String display, String activeOperation) {
				double result = Double.parseDouble(display);
				switch(activeOperation) {
				case "+":
					result = Double.parseDouble(display) + operationMemo;
					break;
				case "-":
					result = operationMemo - Double.parseDouble(display);
					break;
				case "*":
					result = Double.parseDouble(display) * operationMemo;
					break;
				case "/":
					result = operationMemo / Double.parseDouble(display);
					break;
				default: 
					JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
					break;
				}
				return Double.toString(result);
			}
		});
	}  

	private void addNumButtonListener(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = e.getActionCommand();			
				String display = ioField.getText();
										
				switch(buttonText) {
				case "0": 
				case "1": 
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					if(display.equals("0")) {
						ioField.setText(buttonText); 
					}
					else {
						ioField.setText(display.concat(buttonText));
					}
					break;
				case ".": 
					if (!display.contains(".")) {
						ioField.setText(display.concat(buttonText));
					}
					break;
				case "+-": 
					if(display.charAt(0)=='-') {
						display = display.substring(1,display.length());
						ioField.setText(display);
					}
					else {
						display = "-" + display;
						ioField.setText(display);
					}
				default: 
				break;
				}
			}
		});
	}  
}
