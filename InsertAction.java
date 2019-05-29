package Calculator;

import java.awt.event.ActionListener;

import javax.swing.JTextField;


/**
 * @author fed
 * Wrapper für den ActionListener. Stellt Methoden bereit, um auf die Variablen 
 * des Calculator Fensters zuzugreifen
 */
public abstract class InsertAction implements ActionListener{

	protected JTextField ioField;
	protected double operationMemo = 0;
	protected String activeOperation = null;
		
	protected void initCalcVars() {
		ioField = Calc_init.calc.getIoField();
		operationMemo = Calc_init.calc.getOperationMemo();
		activeOperation = Calc_init.calc.getActiveOperation();
	}
	
	protected void overrideInitCalcVars() {
		Calc_init.calc.setOperationMemo(operationMemo);
		Calc_init.calc.setActiveOperation(activeOperation);
	}

}
