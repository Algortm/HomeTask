package module13.task2;

import java.io.IOException;

public class Main {
    private static final String URL = "https://jsonplaceholder.typicode.com/users/1/posts";
    public static void main(String[] args) throws IOException, InterruptedException {
        GetUserPostComments.getLastUserPost(URL);
    }
}
