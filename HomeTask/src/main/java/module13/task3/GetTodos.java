package module13.task3;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetTodos {
    public static void httpGetTodos(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();
        List<JsonObject> jsonObjects = new ArrayList<>();;
        JsonObject iterable;
        for(JsonElement element: jsonArray){
            iterable = element.getAsJsonObject();
            if(!iterable.get("completed").getAsBoolean()) {
                jsonObjects.add(iterable);
            }else {
                continue;
            }
        }
        System.out.println(jsonObjects.toString());
    }
}
