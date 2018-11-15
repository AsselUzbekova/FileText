package com.epam.training.filetext;

import java.io.*;

public class ComEpamTrainingFiletext {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            System.out.println("Output only the middle part:\n");
            int length = sb.toString().length();
            int begin = length / 3;
            int end = begin + begin;
            String example = sb.toString().substring(begin, end);
            System.out.println(example);

            String reverseString = sb.reverse().toString();
            String lowerString = sb.toString().toLowerCase();
            String upperString = sb.toString().toUpperCase();

            try (FileWriter fw = new FileWriter("out.txt");
                    BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(reverseString);
                bw.write("\n");
                bw.write(lowerString);
                bw.write("\n");
                bw.write(upperString);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
