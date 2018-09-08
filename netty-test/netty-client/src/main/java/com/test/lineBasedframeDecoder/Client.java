package com.test.lineBasedframeDecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 按定长形式拆包
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
                    //设置定长字符串接收
                    pipeline.addLast(new FixedLengthFrameDecoder(5));
                    //设置字符串解码器，自动将报文转换为字符串，ClientHandler中可以直接使用字符串解析
                    pipeline.addLast(new StringDecoder());
                    // 注册handler
                    pipeline.addLast(new ClientHandler());
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888);
            channel = channelFuture.channel();
            //向服务端发送多条数据，当设置定长为5后，如果要发送的字符串不够5，则处理等待状态，不会发送到服务器
            channel.writeAndFlush(Unpooled.copiedBuffer("aaaaaaa".getBytes()));
            channel.writeAndFlush(Unpooled.copiedBuffer("bbbbb".getBytes()));
            channel.writeAndFlush(Unpooled.copiedBuffer("ccccccc".getBytes()));
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
