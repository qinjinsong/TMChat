package chat.lobby;

import java.util.ArrayList;

import chat.actor.Actor;
import chat.base.Box;
import utility.Logger;

public class Room extends Box
{
	private ArrayList<Actor> mActorList = null;
	
	public Room(int id, String name)
	{
		super("", id, name);
		mActorList = new ArrayList<Actor>();
	}
	
	public void update()
	{
		
	}
	public void addActor(Actor actor)
	{
		if(!mActorList.contains(actor))
		{
			mActorList.add(actor);
			Logger.log("----------- actor enter, room id:%d, actor guid:%s,   actor account:%s,   actor name:%s", getId(), actor.GetGuid(), actor.getAccount(), actor.GetName());
			return;
		}
		Logger.error(">>>>>>>>>>>>> actor enter fail, room id:%d, actor guid:%s,   actor account:%s,   actor name:%s", getId(), actor.GetGuid(), actor.getAccount(), actor.GetName());;
	}
	public void removeActorByGuid(String guid)
	{
		boolean flag = mActorList.removeIf(it -> it.GetGuid() == guid);
		if(flag)
			Logger.log("----------- actor exit, room id:%d,   actor guid:%s", getId(), guid);
	}
	public void removeActorByAccount(String account)
	{
		boolean flag = mActorList.removeIf(it -> it.getAccount() == account);
		if(flag)
			Logger.log("----------- actor exit, room id:%d,   actor account:%s,", getId(), account);
	}
	public void removeActorByAccount(Actor actor)
	{
		if(mActorList.contains(actor))
		{
			mActorList.remove(actor);
			Logger.log("----------- actor exit, room id:%d,   actor guid:%s,   actor account:%s,   actor name:%s", getId(), actor.GetGuid(), actor.getAccount(), actor.GetName());
		}
	}
}
