package network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import utility.Logger;

public class CustomProtobufEncoder extends MessageToByteEncoder<NetPack>
{
	@Override
	protected void encode(ChannelHandlerContext arg0, NetPack arg1, ByteBuf arg2) throws Exception
	{
		arg2 = arg1.getPackByteBuf();
		Logger.log("------------ encode, protoId:%d", arg1.getProtoId());
	}

}
