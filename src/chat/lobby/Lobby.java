package chat.lobby;

import utility.Logger;
import java.util.ArrayList;
import chat.actor.Actor;
import chat.base.Box;

public class Lobby extends Box
{
	private ArrayList<Actor> mActorList = null;
	private ArrayList<Room> mRoomList = null;
	
	public Lobby(String name)
	{
		super("", 0, name);
		mActorList = new ArrayList<Actor>();
		mRoomList = new ArrayList<Room>();
		setName(name);
		
		Logger.log("------------ create lobby, name: %s", name);
	}

	public void update()
	{	
		//Logger.log("------------ lobby update");
		mRoomList.forEach((it) -> it.update());
	}
	public void addActor(String account, String password, String guid, String name)
	{
		Actor actor = new Actor(account, password, guid, name);
		addActor(actor);
	}
	public void addActor(Actor actor)
	{
		if(!mActorList.contains(actor))
		{
			mActorList.add(actor);
			Logger.log("----------- actor enter lobby, actor account:%s,   actor name:%s", actor.getAccount(), actor.GetName());
		}
	}
	public Actor getActorByGuid(String guid)
	{
		for(Actor actor : mActorList)
		{
			if(actor.GetGuid() == guid)
				return actor;
		}
		return null;
	}
	public Actor getActorByAccount(String account)
	{
		for(Actor actor : mActorList)
		{
			if(actor.getAccount() == account)
				return actor;
		}
		return null;
	}
	public void removeActorByGuid(String guid)
	{
		boolean flag = mActorList.removeIf(it -> it.GetGuid() == guid);
		if(flag)
			Logger.log("----------- actor exit lobby, actor guid:%s", guid);
	}
	public void removeActorByAccount(String account)
	{
		boolean flag = mActorList.removeIf(it -> it.getAccount() == account);
		if(flag)
			Logger.log("----------- actor exit lobby, actor account:%s", account);
	}
	public void addRoom(int id, String name)
	{
		if(!containRoom(id))
		{
			Room room = new Room(id, name);
			mRoomList.add(room);
			Logger.log("-------------- add room, id:%d, name:%s", id, name);
		}
		
	}
	public Room getRoom(int id)
	{
		 for(Room room : mRoomList)
		 {
			 if(room.getId() == id)
				 return room;
		 }
		 return null;
	}
	public boolean containRoom(int id)
	{
		 for(Room room : mRoomList)
		 {
			 if(room.getId() == id)
				 return true;
		 }
		 return false;
	}
	public boolean removeRoom(int id)
	{
		boolean flag = mRoomList.removeIf(it -> it.getId() == id);
		if(flag)
			Logger.log(">>>>>>>>>>>>>> remove room, id:%d", id);
		return flag;
	}
	public void removeRoom(Room room)
	{
		if(mRoomList.contains(room))
		{
			mRoomList.remove(room);
			Logger.log(">>>>>>>>>>>>>> remove room, id:%d, name:%s", room.getId(), room.GetName());
		}
	}
}
