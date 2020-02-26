package com.geovis.init;

import com.geovis.client.NettyClient;
import com.geovis.server.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
@Order(1)
public class DbusappRunner implements CommandLineRunner {



    //netty的服务端函数，监听总线的消息端口
    @Autowired
    private NettyServer nettyServer;


    @Autowired
    private NettyClient nettyClient;
    //初始化函数，系统调用
    @Override
    public void run(String... args) throws Exception {
        nettyServer.initServer();
        nettyClient.initWebClient();
    }
}
