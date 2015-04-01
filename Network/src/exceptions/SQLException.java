package exceptions;


public class SQLException extends Exception
{
	private static final long serialVersionUID = 1L; 
    public SQLException()
    {
        this("错误");
    }

    public SQLException(String s)
    {
        super(s);
    }
}
