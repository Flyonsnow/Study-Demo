package com.wenxuezheng.study.bus.provider.listener;

import com.wenxuezheng.study.bus.common.SelfRemoteApplicationEvent;
import com.wenxuezheng.study.bus.common.SelfRemoteApplicationEvent2;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/31 2:47 PM
 */
@Configuration
@RemoteApplicationEventScan(basePackageClasses = SelfRemoteApplicationEvent.class)
public class SelfBusConfiguration {

    @EventListener
    public void onUserRemoteApplicationEvent(SelfRemoteApplicationEvent selfRemoteApplicationEvent) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("SelfRemoteApplicationEvent - " +
                        " Source : %s , 发送源 : %s , 接收源 : %s \n",
                selfRemoteApplicationEvent.getSource(),
                selfRemoteApplicationEvent.getOriginService(),
                selfRemoteApplicationEvent.getDestinationService());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(selfRemoteApplicationEvent.getValue());
    }

    @EventListener
    public void onUserRemoteApplicationEvent2(SelfRemoteApplicationEvent2 selfRemoteApplicationEvent) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("SelfRemoteApplicationEvent2 - " +
                        " Source : %s , 发送源 : %s , 接收源 : %s \n",
                selfRemoteApplicationEvent.getSource(),
                selfRemoteApplicationEvent.getOriginService(),
                selfRemoteApplicationEvent.getDestinationService());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(selfRemoteApplicationEvent.getValue());
    }
}
