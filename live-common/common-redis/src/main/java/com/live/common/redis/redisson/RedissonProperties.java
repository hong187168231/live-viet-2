package com.live.common.redis.redisson;

import lombok.Data;
import org.redisson.config.ClusterServersConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @desc redisson 连接配置类
 * @email huawei_code@163.com
 * @date 2021/2/22
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonProperties {

    private String password;
    private cluster cluster;
    private String host;
    private String port;

    public static class cluster {
        private List<String> nodes;

        public List<String> getNodes() {
            return nodes;
        }

        public void setNodes(List<String> nodes) {
            this.nodes = nodes;
        }
    }


}
