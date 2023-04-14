package UserInterface;

import ArithmeticOperations.ArithmeticOperations;
import Calculator.Calculator;
import Calculator.CalculatorImpl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame implements ActionListener{

	
	/**
	 * version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1, label2, label3;
    private JTextField textField1, textField2, textField3;
    private JButton buttonSum, buttonSubtract, buttonMultiply, buttonDivide;
    private Locale locale = new Locale("tr");
    
    private Calculator calculator;
    private ArithmeticOperations arithmeticOperations;

	public CalculatorFrame() {
    	
    	calculator = new CalculatorImpl();
    	arithmeticOperations = new ArithmeticOperations() {
		};
    	    	
    	setTitle("Cagatay Calculator");
        
        label1 = new JLabel();
        textField1 = new JTextField(50);
        label2 = new JLabel();
        textField2 = new JTextField(50);
        label3 = new JLabel();
        textField3 = new JTextField(50);
        textField3.setEditable(false);
        
        buttonSum = new JButton();
        buttonSubtract = new JButton();
        buttonMultiply = new JButton();
        buttonDivide = new JButton();
        
        switch(locale.getLanguage()) {
        	case "tr":
        		label1.setText("Sayı 1:");
        		label2.setText("Sayı 2:");
        		label3.setText("Sonuç :");
        		buttonSum.setText("Topla");
                buttonSubtract.setText("Çıkar");
                buttonMultiply.setText("Çarp");
                buttonDivide.setText("Böl");
                break;
        	case "en":
        		label1.setText("Number 1:");
        		label2.setText("Number 2:");
        		label3.setText("Result :");
        		buttonSum.setText("Sum");
                buttonSubtract.setText("Subtract");
                buttonMultiply.setText("Multiply");
                buttonDivide.setText("Divide");
                break;        		
        }
        
        buttonSum.addActionListener(this);
        buttonSubtract.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        
        JPanel panelLabels = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelLabels.add(label1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelLabels.add(label2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelLabels.add(label3, gbc);
        
        JPanel panelTextFields = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelTextFields.add(textField1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelTextFields.add(textField2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelTextFields.add(textField3, gbc);
        
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelButtons.add(buttonSum);
        panelButtons.add(buttonSubtract);
        panelButtons.add(buttonMultiply);
        panelButtons.add(buttonDivide);
        
        JPanel panelMain = new JPanel(new BorderLayout(10, 10));
        panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelMain.add(panelLabels, BorderLayout.WEST);
        panelMain.add(panelTextFields, BorderLayout.CENTER);
        panelMain.add(panelButtons, BorderLayout.SOUTH);
        
        panelLabels.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        panelTextFields.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        
        add(panelMain);
        
        setSize(750, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
    	BigInteger num1 = BigInteger.ZERO;
    	BigInteger num2 = BigInteger.ZERO;
    	BigInteger result = BigInteger.ZERO;
    	String resultStr = "";
    	String btnText = ((JButton) e.getSource()).getText();
    	
    	switch(locale.getLanguage()) {
    		case "tr":
    			
    			if(calculator.isValid(textField1.getText(), locale) != "geçerli")
    			{
    				resultStr = calculator.isValid(textField1.getText(), locale);
    				break;
    			}else {
    				num1 = calculator.convertTr(textField1.getText().toLowerCase());
        			num2 = calculator.convertTr(textField2.getText().toLowerCase());
        			System.out.println("Num 1 : " + num1 + " | Num 2 : " + num2);
        			    			
        			switch(btnText) {
        			case "Topla":
        				result = arithmeticOperations.sum(num1, num2);
        				break;
        			case "Çıkar":
        				result = arithmeticOperations.sub(num1, num2);
        				break;
        			case "Çarp":
        				result = arithmeticOperations.mult(num1, num2);
        				break;
        			case "Böl":
        				result = arithmeticOperations.div(num1, num2);
        				break;
        			}
        			
        			resultStr = calculator.convertTrWord(result);
        			
        			break;
    			}
    			
    		case "en":
    			
    			if(calculator.isValid(textField1.getText(), locale) != "valid")
    			{
    				resultStr = calculator.isValid(textField1.getText(), locale);
    				break;
    			}else {
    				num1 = calculator.convertEn(textField1.getText());
        			num2 = calculator.convertEn(textField2.getText());
        			
        			switch(btnText) {
        			case "Sum":
        				result = arithmeticOperations.sum(num1, num2);
        				break;
        			case "Subtract":
        				result = arithmeticOperations.sub(num1, num2);
        				break;
        			case "Multiply":
        				result = arithmeticOperations.mult(num1, num2);
        				break;
        			case "Divide":
        				result = arithmeticOperations.div(num1, num2);
        				break;
        			}
        			
        			resultStr = calculator.convertTrWord(result);
        			
        			break;
    			}    			
    			
    	}        
        
        textField3.setText(resultStr);
    }
    
    
	
}
