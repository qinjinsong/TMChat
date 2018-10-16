package chat.task;

import chat.lobby.LobbyHelper;
import task.ITask;

public class AddRoomTask implements ITask
{
	private boolean mAbort;
	private int mId;
	private String mName;
	
	public AddRoomTask(int id, String name)
	{
		mId = id;
		mName = name;
	}
	
	@Override
	public boolean process() {
		if(mAbort)
			return false;
		
		LobbyHelper.addRoom(mId, mName);
		return true;
	}

	@Override
	public void onAbort() {
		mAbort = true;
		
	}
}
