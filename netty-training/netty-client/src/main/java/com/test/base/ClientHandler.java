package com.test.base;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

import java.io.UnsupportedEncodingException;


public class ClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("Channel activate with %s", ctx.channel().remoteAddress()));
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            ByteBuf byteBuffer = (ByteBuf) msg;
            byte[] bytes = new byte[byteBuffer.readableBytes()];
            byteBuffer.readBytes(bytes);
            String str = new String(bytes, "utf-8");
            System.out.println("client:" + str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            //释放ByteBuf
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
