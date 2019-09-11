package cloud.stream.sink.viewer.listener;

import cloud.stream.sink.viewer.domain.Tweet;
import cloud.stream.sink.viewer.domain.TweetList;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class TweetListener {


    @StreamListener(Sink.INPUT)
    public void collect(Tweet tweet) {
        TweetList.tweets.add(tweet);
    }
}
