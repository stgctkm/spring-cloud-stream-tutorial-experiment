package cloud.stream.source;

import cloud.stream.source.domain.Tweet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SinkApplicationTests {
    @Autowired
    Sink sink;
    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void testPrint() {
        Tweet tweet = new Tweet();
        tweet.text = "Hello";
        sink.input().send(MessageBuilder.withPayload(tweet).build());

        assertThat(capture.toString())
                .isEqualTo("Received Hello" + System.lineSeparator());
    }

}