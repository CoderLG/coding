package com.geovis.client;

import com.geovis.client.handler.ClentMsgHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;


@Component
public class NettyClient {

    public void initWebClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NioEventLoopGroup group = new NioEventLoopGroup();
                try {
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(group);
                    bootstrap.option(ChannelOption.SO_TIMEOUT, 5 * 1000);
                    bootstrap.channel(NioSocketChannel.class);
                    bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ClentMsgHandler());
                        }
                    });
                    bootstrap.connect("127.0.0.1", 19372).sync().channel().closeFuture().sync();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                        @Override
                        public void run() {
                            group.shutdownGracefully();
                        }
                    }));
                }
            }
        }).start();
    }
}
