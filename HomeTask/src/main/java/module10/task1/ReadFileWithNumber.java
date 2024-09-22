package module10.task1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

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
        String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Text after check valid format:");
        for(String txt: readersArray){
            Matcher matcher = pattern.matcher(txt);
            if(matcher.matches()){
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
