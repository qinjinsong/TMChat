package network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class NettyInitializer extends ChannelInitializer<SocketChannel>
{
	@Override
	protected void initChannel(SocketChannel arg0) throws Exception
	{
		ChannelPipeline pipeline = arg0.pipeline();
		pipeline.addLast("decoder", new CustomProtobufDecoder());
		pipeline.addLast("encoder", new CustomProtobufEncoder());
		pipeline.addLast("handler", new NettyHandler());
	}

}
