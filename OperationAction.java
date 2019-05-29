package Calculator;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * @author fed
 * 
 * Hier wird indirekt ein ActionListener implementiert, für welchen die abstrake
 * Klasse InsertAction ein paar extra Funktionen bereitstellt
 */
public class OperationAction extends InsertAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		initCalcVars();
		String buttonText = arg0.getActionCommand();
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
		overrideInitCalcVars();
	}


	/**
	 * @param display
	 * @param activeOperation
	 * @return processInstantOperation
	 * Wird für die unären operationen angewandt.
	 */
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

	/**
	 * @param operationMemo
	 * @param display
	 * @param activeOperation
	 * @return processLastOperation
	 * Liest die zuletzt aktivierte Operation aus und schliesst diese ab
	 */
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


}
