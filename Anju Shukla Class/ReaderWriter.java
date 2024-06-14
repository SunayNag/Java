import java.io.*;
public class ReaderWriter {
    public static void main(String[] args) {
        try(
        Reader reader = new FileReader("input.txt");
        Writer writer = new FileWriter("output.txt")){
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = reader.read(buffer))!=-1) {
                writer.write(buffer, 0, charsRead);
            }
            System.out.println("Files copied Successfully");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
