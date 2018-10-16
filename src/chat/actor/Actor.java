package chat.actor;

import com.google.protobuf.MessageLite;

import chat.base.Object;
import io.netty.channel.Channel;
import network.NetPack;

public class Actor extends Object
{
	private String mAccount = "";
	private String mPassword = "";
	private Channel mChannel = null;
	
	public Actor(String account, String password, String guid, String name)
	{
		mAccount = account;
		mPassword = password;
		set(guid, name);
	}
	
	public String getAccount()
	{
		return mAccount;
	}
	public String getPassword()
	{
		return mPassword;
	}
	public Channel getChannel()
	{
		return mChannel;
	}
	
	public void setChannel(Channel channel)
	{
		mChannel = channel;
	}
	public void write(MessageLite data)
	{
		short protoId = 0;
		NetPack pack = new NetPack(protoId, data);
		write(pack);
	}
	public void write(NetPack pack)
	{
		if(mChannel.isActive() && mChannel.isWritable())
		{
			mChannel.writeAndFlush(pack);
		}
	}
}
