package chat.task;

import chat.lobby.LobbyHelper;
import task.ITask;

public class RemoveRoomTask implements ITask
{
	private boolean mAbort;
	private int mId;
	
	public RemoveRoomTask(int id)
	{
		mId = id;
	}

	@Override
	public boolean process() {
		if(mAbort)
			return false;
		
		LobbyHelper.removeRoom(mId);
		return true;
	}

	@Override
	public void onAbort() {
		mAbort = true;
	}

}
