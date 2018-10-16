package network;

import com.google.protobuf.MessageLite;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NetPack
{
	private short mProtoId = 0;
	private int mLen = 0;
	private byte[] mBody = null;
	
	public NetPack(short protoId, MessageLite data)
	{
		mProtoId = protoId;
		mLen = data.getSerializedSize();
		mBody = data.toByteArray();
	}
	public NetPack(short protoId, int len, byte[] data)
	{
		mProtoId = protoId;
		mLen = len;
		mBody = data;
	}
	
	public short getProtoId()
	{
		return mProtoId;
	}
	public int getLen()
	{
		return mLen;
	}
	public byte[] getBody()
	{
		return mBody;
	}
	public ByteBuf getBodyByteBuf()
	{
		ByteBuf result = Unpooled.directBuffer();
		result.writeBytes(mBody);
		return result;
	}
	public ByteBuf getPackByteBuf()
	{
		ByteBuf result = Unpooled.directBuffer(); 
		result.writeInt(mLen);
		result.writeShort(mProtoId);
		result.writeBytes(mBody);
		return result;
	}
}
