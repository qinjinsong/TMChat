package game;

import network.Netty;
import utility.Logger;

public class Launch
{
	private static LobbyThread mLobbyThread;
	private static Netty mNetty;
	
	public static void main(String[] args)
	{
		try
		{
			Logger.log("chat server init...");
			
			mLobbyThread = new LobbyThread("chat");
			mLobbyThread.start();
			
			mNetty = new Netty();
			mNetty.start();
		}
		catch(Exception e)
		{
			stop();
		}
		
		Logger.log(">>>>>>>>>>>> exit <<<<<<<<<<<<");
	}
	public static void stop()
	{
		Thread tmp = mLobbyThread;
		mLobbyThread = null;
		tmp.interrupt();
		
		mNetty.stop();
		mNetty = null;
	}
}
