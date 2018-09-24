package com.test.delimiterBasedFrameDecoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 按特殊字符形式拆包
 */
public class Server {
    public static void main(String[] args) {
        EventLoopGroup bossGrop = null;
        EventLoopGroup workerGrop = null;

        try {
            //用于接收服务器处理客户端连接的
            bossGrop = new NioEventLoopGroup();
            //进行网络通信（网络读写）
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
                    //将客户端发送过来的请求按&_进行分隔
                    //设置分隔符
                    ByteBuf delimiter = Unpooled.copiedBuffer("&_".getBytes());
                    //设置分隔符解码器
                    pipeline.addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                    //设置字符串解码器，自动将报文转换为字符串，ServerHandler中可以直接使用字符串解析
                    pipeline.addLast(new StringDecoder());

                    pipeline.addLast(new ServerHandler());//配置具体数据接收方法的处理
                }
            });
            ChannelFuture channelFuture = bootstrap.bind(8888).sync();//绑定端口，开始接收进来的连接
            channelFuture.channel().closeFuture().sync();//等待客户端端口关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGrop.shutdownGracefully();
            workerGrop.shutdownGracefully();
        }
    }
}
