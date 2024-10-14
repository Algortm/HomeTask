package module13.task3;

import module13.task2.GetUserPostComments;

import java.io.IOException;

public class Main {
    private static final String URL = "https://jsonplaceholder.typicode.com/users/1/todos";
    public static void main(String[] args) throws IOException, InterruptedException {
        GetTodos.httpGetTodos(URL);
    }
}
