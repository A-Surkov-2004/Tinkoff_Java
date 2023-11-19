package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackerNews {

    private static final int TITLE_LEN = 8;
    private static final int TIMEOUT = 20;
    private final static Logger LOGGER = LogManager.getLogger();

    public long[] hackerNewsTopStories() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
            .GET()
            .build();

        long[] longs = new long[0];
        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(TIMEOUT))
            .build()) {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String[] strings = response.body().split("\\[")[1].split("]")[0].split(",");
            longs = new long[strings.length];
            for (int i = 0; i < strings.length; i++) {
                longs[i] = Long.parseLong(strings[i]);
            }
        } catch (Exception e) {
            return longs;
        }
        return longs;

    }

    public String news(long id) throws URISyntaxException, IOException, InterruptedException {

        String sid = Long.toString(id);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + sid + ".json"))
            .GET()
            .build();

        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(TIMEOUT))
            .build()) {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String string = response.body();
            Pattern pattern = Pattern.compile("\"title\":\".+?\"");
            Matcher matcher = pattern.matcher(string);
            String title;

            if (matcher.find()) {
                title = string.substring(matcher.start() + TITLE_LEN, matcher.end());
                LOGGER.info(title);
                return title;
            }

        }
        return null;

    }
}
