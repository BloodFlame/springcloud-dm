package cn.dm.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日志工具类
 *
 * @author dm
 */
@Component
public class LogUtils {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void i(String topic, String msg) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                kafkaTemplate.send(topic, "dm", msg);
            }
        });
    }
}
