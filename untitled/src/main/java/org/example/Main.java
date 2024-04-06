package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "/home/sirma/IdeaProjects/untitled/src/main/resources/base64data.txt";
        String outputFilePath = "output.pdf";

        try {
            byte[] byteArray = Files.readAllBytes(Paths.get(inputFilePath));

            byte[] decodedBytes = Base64.getDecoder().decode(byteArray);

            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            outputStream.write(decodedBytes);
            outputStream.close();

            System.out.println("File successfully created: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid base64 data. Check the content of the input file.");
            e.printStackTrace();
        }
    }
}