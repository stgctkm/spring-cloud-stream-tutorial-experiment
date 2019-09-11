package cloud.stream.source.listener;

import cloud.stream.source.domain.Tweet;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class TweetListener {

    @StreamListener(Sink.INPUT)
    public void print(Tweet tweet) {
        System.out.println("Received : " + tweet);
    }
}
