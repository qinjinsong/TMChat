package chat.base;

public class Box extends Object
{
	private int mId = 0; //room id
	private int mNum = 0; //actor num
	private Long mCreateRoomTime = 0L; // the time of then room created
	
	public Box(String guid, int id, String name)
	{
		mId = id;
		mNum = 0;
		mCreateRoomTime = System.currentTimeMillis();
		set(guid, name);
	}
	
	public int getId()
	{
		return mId;
	}
	public void setNum(int value)
	{
		mNum = value;
	}
	public int getNum()
	{
		return mNum;
	}
	public Long getCreateRoomTime()
	{
		return mCreateRoomTime;
	}
}
