package module10.task2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FromTxtToJson {
    static final String DEFAULT_PATH_FILE_TXT = "src/main/resources/file2.txt";
    static final String DEFAULT_PATH_FILE_JSON = "src/main/resources/user.json";

    public static void main(String[] args) {
        File file = new File(DEFAULT_PATH_FILE_TXT);
        checkFIle(file);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            int indexName;
            int indexAge;
            List<User> users = new ArrayList<>();
            String text = reader.readLine();
            String[] textArray = text.split(" ");
            if(textArray[0].equals("name")){
                indexName = 0;
                indexAge = 1;
            }else{
                indexName = 1;
                indexAge = 0;
            }
            text = reader.readLine();
            while(text!=null){
                System.out.println(text);
                textArray = text.split(" ");
                users.add(new User(textArray[indexName], Integer.parseInt(textArray[indexAge])));
                text = reader.readLine();
            }
            toSaveInJson(users);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    static public void checkFIle(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static public void toSaveInJson(List<User> users){
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        File file = new File(DEFAULT_PATH_FILE_JSON);
        checkFIle(file);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            String jsonContent = json.toJson(users);
            writer.write(jsonContent);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}




