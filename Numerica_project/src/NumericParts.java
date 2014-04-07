import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.AbstractDocument.BranchElement;


public class NumericParts extends Panel implements ConvertListener, ActionListener {

	static String DECIMAL = "%d";
	static String HEXADECIMAL = "%x";
	static String OCTAL_NOTATION = "%o";

	ConvertListener convertListner;
	public ConvertListener getConvertListner() {
		return convertListner;
	}

	public void setConvertListner(ConvertListener convertListner) {
		this.convertListner = convertListner;
	}

	TextField input;
	Button decide;
	String type; 

	public NumericParts(String title, String type)
	{
		this.type = type;
		this.input = new TextField("", 40);
		this.decide = new Button("convert");
		this.decide.addActionListener(this);
		
		Label label = new Label(title);
		decide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("convert".equals(e.getActionCommand()))
				{
					String text = input.getText();
				}
			}
		});
		
		add(label);
		add(input);
		add(decide);
	}

	public String getNum()
	{
		int radix = 10;
		if( DECIMAL.equals(type) )			radix = 10;
		if( HEXADECIMAL.equals(type) ) 		radix = 16;
		if( OCTAL_NOTATION.equals(type) )	radix = 8;
		
		String text = input.getText();
		if(text == null || text.isEmpty()) {
			return "0";
		}
		
		return String.format("%d", Integer.parseInt(text, radix));
	}
	
	@Override
	public void convertAction(int action, String num)
	{
		if(action == ConvertListener.ACTION_CONVERT)
		{
			try{
				input.setText(String.format(type, Integer.valueOf(num)));
			} 
			catch(NumberFormatException e) {
				input.setText("error");
			}
		}
		else if(action == ConvertListener.ACTION_PUSH_BUTTON) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("convert".equals(e.getActionCommand()))
		{
			convertListner.convertAction(ACTION_PUSH_BUTTON, getNum());
		}
	}
}
