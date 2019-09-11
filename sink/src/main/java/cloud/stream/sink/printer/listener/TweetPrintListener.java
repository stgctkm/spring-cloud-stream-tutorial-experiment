package cloud.stream.sink.printer.listener;

import cloud.stream.sink.printer.domain.Tweet;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class TweetPrintListener {

    @StreamListener(Sink.INPUT)
    public void print(Tweet tweet) {
        System.out.println("Received : " + tweet);
    }
}
