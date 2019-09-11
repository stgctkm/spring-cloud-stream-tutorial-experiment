package cloud.stream.sink.printer;

import cloud.stream.sink.viewer.domain.Tweet;
import cloud.stream.source.presentation.SourceController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SourceApplicationTests {

    @Autowired
    SourceController app;
    @Autowired
    MessageCollector collector;
    @Autowired
    Source source;

    @Test
    @SuppressWarnings("unchecked")
    public void testTweet() {
        Tweet tweet = new Tweet();
        tweet.text = "hello!";
        app.tweet(tweet);

        Message<String> message = (Message<String>) collector.forChannel(source.output())
                .poll();

        assertThat(message.getPayload()).isInstanceOf(String.class);
        assertThat(message.getPayload()).isEqualTo("{\"text\":\"hello!\"}");
        assertThat(message.getHeaders().get("contentType").toString())
                .isEqualTo("application/json");
    }
}
