package com.test.serial;


import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public class MarshallingCodeCFactory {

    public static MarshallingDecoder buildMarshallingDecoder() {
        final MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        //配置了版本号为5
        configuration.setVersion(5);
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(factory, configuration);
        //两个参数分别为provider和单个消息序列化后的最大长度1024*1024*1=1M
        MarshallingDecoder decoder = new MarshallingDecoder(provider, 1024*1024*1);
        return decoder;
    }

    public static MarshallingEncoder buildMarshallingEncoder() {
        final MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(factory, configuration);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }
}