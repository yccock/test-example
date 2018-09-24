package com.test.serial;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 请求序列化
 */
public class Server {
    public static void main(String[] args) {
        EventLoopGroup bossGrop = null;
        EventLoopGroup workerGrop = null;

        try {
            //1.第一个线程组是用于接收Client端连接的
            bossGrop = new NioEventLoopGroup();
            //2.第二个线程组是用于实际的业务处理的
            workerGrop = new NioEventLoopGroup();
            //创建辅助通信工具类，用于服务器通道的一系列配置
            ServerBootstrap bootstrap = new ServerBootstrap();
            //绑定两个线程组
            bootstrap.group(bossGrop, workerGrop)
            .channel(NioServerSocketChannel.class) //指定NIO模式
            .option(ChannelOption.SO_BACKLOG, 1024) //设置TCP缓冲区
            .option(ChannelOption.SO_SNDBUF, 32 * 1024) //设置发送缓冲区
            .option(ChannelOption.SO_RCVBUF, 32 * 1024) //设置接收缓冲区
            .option(ChannelOption.SO_KEEPALIVE, true)
            .handler(new LoggingHandler(LogLevel.INFO))//设置日志
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    //设置Marshalling的编码和解码
                    pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                    pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());

                    pipeline.addLast(new ServerHandler());//配置具体数据接收方法的处理
                }
            });
            ChannelFuture channelFuture = bootstrap.bind(8888).sync();//绑定端口，开始接收进来的连接
            channelFuture.channel().closeFuture().sync();//等待关闭(程序阻塞在这里等待客户端请求)
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGrop.shutdownGracefully();//关闭线程
            workerGrop.shutdownGracefully();
        }
    }
}
