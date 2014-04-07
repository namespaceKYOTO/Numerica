
public interface ConvertListener {
	static int ACTION_CONVERT = 0;
	static int ACTION_PUSH_BUTTON = 1;
	public void convertAction(int action, String num);
}
