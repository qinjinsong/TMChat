package chat.base;

public class Object
{
	private String mGuid = "";
	private String mName = "";
	
	@Override
	public String toString()
	{
		return String.format("guid:%s, name:%s", mGuid, mName);
	}
	
	public void set(String guid, String name)
	{
		setGuid(guid);
		setName(name);
	}
	public void setGuid(String guid)
	{
		mGuid = guid;
	}
	public String GetGuid()
	{
		return mGuid;
	}
	public void setName(String name)
	{
		mName = name;
	}
	public String GetName()
	{
		return mName;
	}
}
