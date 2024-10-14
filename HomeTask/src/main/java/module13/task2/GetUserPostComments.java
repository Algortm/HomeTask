package module13.task2;

import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetUserPostComments {
    public static void getLastUserPost(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();
        JsonElement lastPost = jsonArray.get(jsonArray.size()-1);
        JsonObject lastObj = lastPost.getAsJsonObject();

        int userId = lastObj.get("userId").getAsInt();
        int id = lastObj.get("id").getAsInt();
        getCommentsByLastUserPost(userId, id);
    }
    private static void getCommentsByLastUserPost(int userId, int PostId) throws IOException, InterruptedException {
        String commentsUrl = "https://jsonplaceholder.typicode.com/posts/"+PostId+"/comments";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(commentsUrl))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        File file = new File("user - "+ userId +" - post - "+ PostId +" - comments.txt");

        try(FileWriter outstream = new FileWriter(file)){
            outstream.write(response.body());
        }catch (IOException e){
            e.getMessage();
        };
    }
}