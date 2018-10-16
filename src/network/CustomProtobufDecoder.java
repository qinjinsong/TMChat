package network;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import utility.Logger;

public class CustomProtobufDecoder extends ByteToMessageDecoder
{
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		while(in.readableBytes() > 4)
		{
			in.markReaderIndex();
			
			int len = in.readInt();
			if(in.readableBytes() < len)
			{
				in.resetReaderIndex();
				return;
			}
			short protoId = in.readShort();
			//ByteBuf bb = in.readBytes(in, len);
			//byte[] body = bb.array();
			byte[] body = ByteBufUtil.getBytes(in, in.readerIndex(), len);
			NetPack pack = new NetPack(protoId, len, body);
			out.add(pack);
			Logger.log("------------ decode, protoId:%d", protoId);
			
			in.resetReaderIndex();
		}
	}

}
