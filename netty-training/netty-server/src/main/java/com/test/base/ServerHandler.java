package com.test.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;

public class ServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("Channel activate with %s", ctx.channel().remoteAddress()));
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf byteBuffer = (ByteBuf) msg;
            byte[] bytes = new byte[byteBuffer.readableBytes()];
            byteBuffer.readBytes(bytes);
            String str = new String(bytes, "utf-8");
            System.out.println("server:" + str);
            ChannelFuture future = ctx.writeAndFlush(Unpooled.copiedBuffer("hi client".getBytes()));
            //关闭连接
            future.addListener(ChannelFutureListener.CLOSE);
//            future.addListener(new ChannelFutureListener() {
//                public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                    System.out.println("服务端写数据完成");
//                    ctx.close();
//                }
//            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
