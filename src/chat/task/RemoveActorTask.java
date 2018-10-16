package chat.task;

import chat.lobby.LobbyHelper;
import task.ITask;

public class RemoveActorTask implements ITask
{
	private boolean mAbort;
	private String mValue;
	private int mByType;
	
	public RemoveActorTask(String value, int byType)
	{
		mValue = value;
		mByType = byType;
	}
	
	@Override
	public boolean process() {
		if(mAbort)
			return false;
		
		if(mByType == 0)
			LobbyHelper.removeActorByAccount(mValue);
		else if(mByType == 1)
			LobbyHelper.removeActorByGuid(mValue);
		return true;
	}

	@Override
	public void onAbort() {
		mAbort = true;
	}

}
