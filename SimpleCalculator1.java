package Chuong4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SimpleCalculator extends JFrame{
	
	private JTextField tfdisplay;
	private double result = 0;
	private String operator = "=";
	private boolean start = true;
	
	public SimpleCalculator() {
		setTitle("Calculator");
		setSize(300, 400);
		setLayout(new BorderLayout());
		
		tfdisplay = new JTextField("0");
		tfdisplay.setEditable(false);
		add(tfdisplay, "North");
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(4, 4));
		String buttons[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
		for(int i = 0; i < buttons.length; i++) {
			JButton btn = new JButton(buttons[i]);
			p.add(btn);
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String s = e.getActionCommand();
					if('0' <= s.charAt(0) && s.charAt(0) <= '9' || s.equals(".")) {
						if(start) tfdisplay.setText(s);
						else tfdisplay.setText(tfdisplay.getText() + s);
						start = false;
					}
					else {
						if(start) {
							if(s.equals("-")) {
								tfdisplay.setText(s);
								start = false;
							}
							else operator = s;
						}
						else {
							double x = Double.parseDouble(tfdisplay.getText());
							calculate(x);
							operator = s;
							start = true;
						}
					}
				}
			});
		}
		add(p, "Center");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				System.exit(0);
			}
		});
	}
	
	public void calculate(double x) {
		if(operator.equals("+")) result += x;
		else if(operator.equals("-")) result -= x;
		else if(operator.equals("*")) result *= x;
		else if(operator.equals("/")) result /= x;
		else result = x;
		tfdisplay.setText("" + result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleCalculator jframe = new SimpleCalculator();
		jframe.show();
	}

}