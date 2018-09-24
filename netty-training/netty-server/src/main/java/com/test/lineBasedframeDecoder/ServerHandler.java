package com.test.lineBasedframeDecoder;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("server channel activate with %s", ctx.channel().remoteAddress()));
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        String str = (String) msg;
        System.out.println("server:" + str);

        //响应数据按$_进行分隔，以便于客户端拆分
        String response = "响应数据&_";
        ChannelFuture future1 = ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
        //关闭连接
        future1.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
