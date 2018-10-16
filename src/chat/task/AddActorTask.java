package chat.task;

import chat.lobby.LobbyHelper;
import task.ITask;

public class AddActorTask implements ITask
{
	private boolean mAbort;
	private String mAccount;
	private String mPassword;
	private String mGuid;
	private String mName;
	
	public AddActorTask( String account, String password, String guid, String name)
	{
		mAccount = account;
		mPassword = password;
		mGuid = guid;
		mName = name;
	}

	@Override
	public boolean process() {
		if(mAbort)
			return false;
		
		LobbyHelper.addActor(mAccount, mPassword, mGuid, mName);
		return true;
	}

	@Override
	public void onAbort() {
		mAbort = true;
	}
}
