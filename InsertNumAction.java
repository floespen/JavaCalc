package Calculator;

import java.awt.event.ActionEvent;

/**
 * @author fed
 * 
 * Hier wird indirekt ein ActionListener implementiert, für welchen die abstrake
 * Klasse InsertAction ein paar extra Funktionen bereitstellt
 */
public class InsertNumAction extends InsertAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		initCalcVars();
		String value = arg0.getActionCommand();
		System.out.println(value);
		
		String buttonText = arg0.getActionCommand();			
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
}
		
	
