package module10.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileWithNumber {
    static final String DEFAULT_PATH_FILE = "src/main/resources/file1.txt";
    public static void main(String[] args) {
        File file = new File(DEFAULT_PATH_FILE);
        checkFIle(file);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            List<String> readersArray = new ArrayList<>();
            String text = reader.readLine();
            while(text!=null){
                readersArray.add(text);
                text = reader.readLine();
            }
            System.out.println("Text from file before check format: ");
            System.out.println(readersArray);
            checkValidFormatNumber(readersArray);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    static public void checkValidFormatNumber(List<String> readersArray){
        System.out.println("Text after check valid format:");
        for(String txt: readersArray){
            char[] txtArrayChar = txt.toCharArray();
            if((txtArrayChar[0] =='('&&txtArrayChar[4]==')'&&txtArrayChar[9]=='-')||(txtArrayChar[3] =='-'&&txtArrayChar[7]=='-')){
                System.out.println(txt);
            }
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
