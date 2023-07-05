package com.wenxuezheng.study.bus.common;

import lombok.Data;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @author    
 * @date 2022/3/31 2:49 PM
 */
@Data
public class SelfRemoteApplicationEvent2 extends RemoteApplicationEvent {
    public SelfRemoteApplicationEvent2() {
        super();
    }

    private String value;

    public SelfRemoteApplicationEvent2(String str, String originService,
                                       String destinationService) {
        super(str, originService, destinationService);
        this.value = str;
    }
}
