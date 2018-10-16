package network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utility.Logger;

public class NettyHandler extends ChannelInboundHandlerAdapter
{
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		Logger.log("connect address:%s", ctx.channel().remoteAddress());
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Logger.log("disconnect address:%s", ctx.channel().remoteAddress());
	}
}
