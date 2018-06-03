/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Diyana
 */
public class CountingWord {
    private static final String FILENAME = "test.txt";

    public void countWord() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            int count = 0;
            int charCount = 0;
            int charCount2 = 0; 
            int ttlline = 0;
            int max = 0;
            int min = 0;
            int lines = 0;
            int sum = 0;
            double avg = 0;
            String line = br.readLine();
            while (line != null) {
                ttlline++;
                charCount = charCount + line.length();

                String[] myWords = line.replaceAll("\\s", " ").split(" ");

                for (String s : myWords) {
                    charCount2 = charCount2 + s.length();

                }
                count = count + myWords.length;

                line = br.readLine();
            }

            System.out.printf("Number of words \t\t\t | %6d \n", count);
            //System.out.println("|:--|--:|");
            System.out.printf("Number of lines \t\t\t | %6d \n", ttlline);
            System.out.printf("Number of characters without space \t | %6d \n", charCount2);
            System.out.printf("Number of characters with space \t | %6d \n", charCount);
      

    }
}
