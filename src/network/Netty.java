package network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import utility.Logger;

public class Netty
{
	private String mIp = "127.0.0.1";
	private int mPort = 16800;
	private EventLoopGroup bossGroup = null;
	private EventLoopGroup workerGroup = null;
	
	public void start()
	{
		start(mIp, mPort);
	}
	public void start(String ip, int port)
	{
		mIp = ip;
		mPort = port;
		
		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();
		try
		{
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workerGroup);
			boot.channel(NioServerSocketChannel.class);//tcp
			boot.option(ChannelOption.SO_BACKLOG, 1024);//��ʶ���������������߳�ȫ��ʱ��������ʱ���������������ֵ�����Ķ��е���󳤶ȡ����δ���û������õ�ֵС��1��Java��ʹ��Ĭ��ֵ50
			boot.childOption(ChannelOption.TCP_NODELAY, true);//����nagle�㷨
			boot.childHandler(new NettyInitializer());
			
			Logger.log("network ready...");
			Logger.log("server ip:%s, prot:%d", mIp, mPort);
			
			ChannelFuture future = boot.bind(mIp, mPort).sync();
			future.channel().closeFuture().sync();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			stop();
		}
	}
	public void stop()
	{
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		Logger.error("network shutdown...");
	}
}
