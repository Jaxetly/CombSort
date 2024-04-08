import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CombSort {

    public static void main(String[] args) {
        String outputName = "File.csv";
        String inputName = "Input.txt";
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputName))) {
            try(BufferedReader br = new BufferedReader(new FileReader(inputName))) {
                writter.write("n,nanosec,iterations\n");
                int[] data;
                int iterations;
                long startTime;
                long duration;
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    i+=100;
                    data = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
    
                    startTime = System.nanoTime();
                    iterations = combSort(data);
                    duration = (System.nanoTime() - startTime);
    
                    writter.write(i + "," + duration + "," + iterations + "\n");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        int iterations = 0;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
                iterations++;
            }
        }
        return iterations;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getNextGap(int gap) {
        gap = (gap * 100) / 125;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }
}