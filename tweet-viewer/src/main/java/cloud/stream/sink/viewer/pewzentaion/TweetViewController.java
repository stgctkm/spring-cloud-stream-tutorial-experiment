package cloud.stream.sink.viewer.pewzentaion;

import cloud.stream.sink.viewer.domain.Tweet;
import cloud.stream.sink.viewer.domain.TweetList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetViewController {

    @GetMapping
    public List<Tweet> viewTweets() {
        return TweetList.tweets;
    }

}
