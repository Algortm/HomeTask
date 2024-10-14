package module13.task1;

import java.io.IOException;

public class Main {
    private static final String URL = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) throws IOException, InterruptedException {
    //Make new user:
        CreateObject.httpCreate(URL);
    // Update user:
        PutObject.httpPut(URL+"/9");
    // Delete user
        DeleteObject.httpDelete(URL+"/6");
    // Get all users:
        GetObjects.httpGet(URL);
    // Get user by id:
        GetObjects.httpGet(URL+"/2");
    // Get user by username:
        GetObjects.httpGet(URL+"?username=Delphine");
    }
}
