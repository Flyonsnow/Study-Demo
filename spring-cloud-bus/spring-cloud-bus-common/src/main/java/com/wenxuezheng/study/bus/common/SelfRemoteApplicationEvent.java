package com.wenxuezheng.study.bus.common;

import lombok.Data;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @author    
 * @date 2022/3/31 2:49 PM
 */
@Data
public class SelfRemoteApplicationEvent extends RemoteApplicationEvent {
    public SelfRemoteApplicationEvent() {
        super();
    }

    private String value;

    public SelfRemoteApplicationEvent(String str, String originService,
                                      String destinationService) {
        super(str, originService, destinationService);
        this.value = str;
    }
}
