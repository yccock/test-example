package com.test.serial;

import com.test.serial.domain.Request;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 请求序列化
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
                    //设置Marshalling的编码和解码
                    pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                    pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                    // 注册handler
                    pipeline.addLast(new ClientHandler());
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888).sync();
            channel = channelFuture.channel();
            for (int i = 0; i < 5; i++) {
                Request request = new Request();
                request.setId(i);
                request.setName("name"+i);
                request.setAttach(("message"+i).getBytes());
                channel.writeAndFlush(request);
            }
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
