package module10.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UniqueWordCount {
    static final String DEFAULT_PATH_FILE = "src/main/resources/file3.txt";

    public static void main(String[] args) {
        File file = new File(DEFAULT_PATH_FILE);
        checkFIle(file);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            Map<String, Integer> hashText = new HashMap<>();
            String textFromFile = reader.readLine();
            String[] textArray;
            Integer value;
            while(textFromFile!=null){
                textArray = textFromFile.split(" ");
                for(String txt: textArray){
                    if(hashText.get(txt)==null){
                        hashText.put(txt, 1);
                    }else{
                        value = hashText.get(txt);
                        hashText.replace(txt, ++value);
                    }
                }
                textFromFile = reader.readLine();
            }
            System.out.println("After count words");
            System.out.println(hashText.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    static public void checkFIle(File file){
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try{
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
