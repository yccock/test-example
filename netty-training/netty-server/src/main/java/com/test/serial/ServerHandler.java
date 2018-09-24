package com.test.serial;

import com.test.serial.domain.Response;
import com.test.serial.domain.Request;
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
        Request request = (Request) msg;
        System.out.println("client发送："+ request.getName());

        Response response = new Response();
        response.setId(request.getId());
        response.setMsg("成功");
        response.setName(request.getName());
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
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
