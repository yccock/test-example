package com.test.delimiterBasedFrameDecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 按特殊字符形式拆包
 */
public class Client {
    public static void main(String[] args){
        EventLoopGroup eventLoopGroup = null;
        Channel channel = null;
        try {
            eventLoopGroup = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    //对服务端发送过来的数据进行拆分
                    //设置分隔符
                    ByteBuf delimiter = Unpooled.copiedBuffer("&_".getBytes());
                    //设置分隔符解码器
                    pipeline.addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                    //设置字符串解码器，自动将报文转换为字符串，ClientHandler中可以直接使用字符串解析
                    pipeline.addLast(new StringDecoder());
                    // 注册handler
                    pipeline.addLast(new ClientHandler());
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888);
            channel = channelFuture.channel();
            //向服务端发送多条数据，结尾以&_分隔，以便于服务端拆分
            channel.writeAndFlush(Unpooled.copiedBuffer("aaaa&_".getBytes()));
            channel.writeAndFlush(Unpooled.copiedBuffer("bbbb&_".getBytes()));
            channel.writeAndFlush(Unpooled.copiedBuffer("cccc&_".getBytes()));
            System.out.println("向服务端发送数据成功...");
            // 绑定端口，开始接收进来的连接
            channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
