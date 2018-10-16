package chat.lobby;

import chat.actor.Actor;
import chat.task.AddActorTask;
import chat.task.AddRoomTask;
import chat.task.RemoveActorTask;
import chat.task.RemoveRoomTask;
import task.TaskQueue;

public class LobbyHelper
{
	private static Lobby mLobby;
	
	private static TaskQueue mTaskQueue = new TaskQueue();
	
	public static void createLobby(String name)
	{
		mLobby = new Lobby(name);
	}
	public static void update()
	{
		mTaskQueue.process();
		mTaskQueue.lockQueue(); 
		
		mLobby.update();
		
		mTaskQueue.unLockQueue();
	}
	
	public static void addRoom(int id, String name)
	{
		AddRoomTask task = new AddRoomTask(id, name);
		mTaskQueue.addTask(task);
	}
	public static Room getRoom(int id)
	{
		return mLobby.getRoom(id);
	}
	public static void removeRoom(int id)
	{
		RemoveRoomTask task = new RemoveRoomTask(id);
		mTaskQueue.addTask(task);
	}
	
	public static void addActor(String account, String password, String guid, String name)
	{
		AddActorTask task = new AddActorTask(account, password, guid, name);
		mTaskQueue.addTask(task);
	}
	public static void addActor(Actor actor)
	{
		mLobby.addActor(actor);
	}
	public static void getActorByGuid(String guid)
	{
		mLobby.getActorByGuid(guid);
	}
	public static void getActorByAccount(String account)
	{
		mLobby.getActorByAccount(account);
	}
	public static void removeActorByGuid(String guid)
	{
		RemoveActorTask task = new RemoveActorTask(guid, 1);
		mTaskQueue.addTask(task);
	}
	public static void removeActorByAccount(String account)
	{
		RemoveActorTask task = new RemoveActorTask(account, 0);
		mTaskQueue.addTask(task);
	}
}
