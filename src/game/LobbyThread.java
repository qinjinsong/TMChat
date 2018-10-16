package game;

import chat.lobby.LobbyHelper;

public class LobbyThread extends Thread
{
	public LobbyThread(String name)
	{
		setName(name);
	}
	
	@Override
	public void run()
	{
		LobbyHelper.createLobby("chat");
		
		while(true)
		{
			try
			{
				LobbyHelper.update();
				sleep(100);
			} 
			catch (Exception e)
			{
				// TODO: handle exception
			}
		}
	}
}
