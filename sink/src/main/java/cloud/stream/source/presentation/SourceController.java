package cloud.stream.source.presentation;

import cloud.stream.source.domain.Tweet;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SourceController {

    private final Source source;

    @PostMapping
    public void tweet(@RequestBody Tweet tweet) {
        source.output().send(MessageBuilder.withPayload(tweet).build());
    }

    SourceController(Source source) {
        this.source = source;
    }
}
