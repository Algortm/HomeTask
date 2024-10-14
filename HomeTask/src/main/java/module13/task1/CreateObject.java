package module13.task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateObject {

        public static void httpCreate(String url) throws IOException, InterruptedException {
            String object = "{\n" +
                    "    \"name\": \"Glenna Reichert\",\n" +
                    "    \"username\": \"Delphine\",\n" +
                    "    \"email\": \"Chaim_McDermott@dana.io\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Dayna Park\",\n" +
                    "      \"suite\": \"Suite 449\",\n" +
                    "      \"city\": \"Bartholomebury\",\n" +
                    "      \"zipcode\": \"76495-3109\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"24.6463\",\n" +
                    "        \"lng\": \"-168.8889\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"(775)976-6794 x41206\",\n" +
                    "    \"website\": \"conrad.com\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Yost and Sons\",\n" +
                    "      \"catchPhrase\": \"Switchable contextually-based project\",\n" +
                    "      \"bs\": \"aggregate real-time technologies\"\n" +
                    "    }\n" +
                    "  ";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(object))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
}
