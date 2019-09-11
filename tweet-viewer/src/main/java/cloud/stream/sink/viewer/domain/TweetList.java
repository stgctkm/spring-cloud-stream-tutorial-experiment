package cloud.stream.sink.viewer.domain;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TweetList {

    public final static List<Tweet> tweets = new CopyOnWriteArrayList<>();
}
