import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        String text_to_write = "Hi its my text";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("/home/slavik/repos/java/java_labs/lab5/data/text.txt");
            fileOutputStream.write(text_to_write.getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Hello world!");
    }


}


