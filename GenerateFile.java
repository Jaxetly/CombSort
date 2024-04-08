import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class GenerateFile {

    public static void main(String[] args) {
        String fileName = "Input.txt";
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i=100; i<10001; i+=100) {
                genArray(writter, i);
                writter.write("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void genArray(BufferedWriter writter, int size) throws IOException{
        for (int i=0; i<size; i++){
            writter.write((int)(Math.random()*10001) + " ");
        }
    }
}