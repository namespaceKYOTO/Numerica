import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Stack;

public class BaseFrame extends Frame implements WindowListener, ConvertListener {
	
	Stack<NumericParts> convertListener;
	
	public BaseFrame()
	{
		super("Numerica");
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rec = env.getMaximumWindowBounds();
		int width = (int)rec.getWidth() / 2;
		int height = (int)rec.getHeight() / 2;
		int x = ((int)rec.getWidth() / 2) - (width / 2);
		int y = ((int)rec.getHeight() / 2) - (height / 2);
		setBounds( x, y, width, height );
		setVisible(true);
		addWindowListener(this);

		GridLayout layout = new GridLayout(3, 1);
		setLayout(layout);
		
		convertListener = new Stack<NumericParts>();
		
		String[][] initParam = {
			{ "Decimal", NumericParts.DECIMAL },
			{ "Hexadecimal", NumericParts.HEXADECIMAL },
			{ "Octal notation", NumericParts.OCTAL_NOTATION },
		};
		
		for (String[] strings : initParam) {
			NumericParts np = new NumericParts(strings[0], strings[1]);
			//np.addActionListener(this);
			np.setConvertListner(this);
			add(np);
			convertListener.push(np);
		}
		
	}
	
	@Override
	public void windowActivated(WindowEvent e)
	{
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertAction(int action, String num) {
		// TODO Auto-generated method stub
		if(action == ConvertListener.ACTION_PUSH_BUTTON)
		{
			for (NumericParts element : convertListener) {
				element.convertAction(ConvertListener.ACTION_CONVERT, num);
			}
		}
	}
}
