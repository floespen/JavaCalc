package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private Font f = new Font("Arial", Font.BOLD, 50);
	private JTextField ioField = new JTextField();
	private double operationMemo = 0;
	private String activeOperation = null;
	
	// getter & setter
	
	public JTextField getIoField() {
		return ioField;
	}

	public void setIoField(JTextField ioField) {
		this.ioField = ioField;
	}
	
	public double getOperationMemo() {
		return operationMemo;
	}

	public void setOperationMemo(double operationMemo) {
		this.operationMemo = operationMemo;
	}

	public String getActiveOperation() {
		return activeOperation;
	}

	public void setActiveOperation(String activeOperation) {
		this.activeOperation = activeOperation;
	}
		
	// Konstruktor für die GUI
	public Calculator(String name){
    	super(name);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(new Dimension(800,600));
    	setLayout(new BorderLayout());
    	
    	// Zwei Panel mit Gridlayout einer für das numpad und einer für die operationbuttons
    	JPanel numPanel = new JPanel();
    	numPanel.setLayout(new GridLayout(4,0));
    	JPanel operandPanel = new JPanel();
    	operandPanel.setLayout(new GridLayout(4,0));
    	
    	// Inputfeld für den Taschenrechner
    	ioField.setEditable(false);
    	ioField.setText("0");
    	ioField.setFont(f);
    	ioField.setHorizontalAlignment(JTextField.RIGHT);
    	
    	// Platziert die 3 Hauptelemente nach BorderLayout im Fenster
    	add(ioField, "North");
    	add(numPanel, "Center");
    	add(operandPanel, "East");

    	// Die Numpad Buttons
    	JButton[] numButton = new JButton[12];
    	String[] numButtonText = {
    			"7", "8", "9",
    			"4", "5", "6",
    			"1", "2", "3",
    			"+-", "0", ".",
    	};
    	
    	// Die Buttons für die Rechenoperationen
    	JButton[] operandButton = new JButton[8];
     	String[] operandButtonText = {
    			"+", "-", "*", 
    			"/", "x²", "\u221A",
    			"C", "="	
    	};
     	
     	// Zwei Schleifen um alle Buttons zu Initialisieren
    	for(int i = 0; i < numButtonText.length; i++) {
    		numButton[i] = new JButton(numButtonText[i]);
    	}
    	for(int i = 0; i < operandButtonText.length; i++) {
    		operandButton[i] = new JButton(operandButtonText[i]);
    	}
    	          
    	// Hier werden die Buttons 
    	for (JButton btn : numButton) {
    		btn.setFont(f);
    		btn.addActionListener(new InsertNumAction());;
    		numPanel.add(btn);
		}
  
    	for (JButton btn : operandButton) {
    		btn.setFont(f);
    		btn.addActionListener(new OperationAction());;
    		operandPanel.add(btn);
    	}
		
		pack();
		setLocationRelativeTo(null);
    }
	
}
