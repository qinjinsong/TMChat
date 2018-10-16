package utility;

public class Logger 
{
	public static boolean enable = true;
	
	public static void log(Object o)
	{
		if(enable)
			System.out.println(o);
	}
	public static void log(String format, Object... args)
	{
		if(enable)
		{
			String text = String.format(format, args);
			System.out.println(text);
		}
	}
	public static void error(Object o)
	{
		if(enable)
			System.err.println(o);
	}
	public static void error(String format, Object... args)
	{
		if(enable)
		{
			String text = String.format(format, args);
			System.err.println(text);
		}
	}
}
