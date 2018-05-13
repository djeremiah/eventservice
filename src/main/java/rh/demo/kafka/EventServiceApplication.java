package rh.demo.kafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }

    @Bean
    public RouteBuilder config(){
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("kafka:my-cluster-kafka.summit.svc:9092?topic=test&groupId=eventservice&autoOffsetReset=earliest")
                    .to("log:events");
            }
        };
    }


}
