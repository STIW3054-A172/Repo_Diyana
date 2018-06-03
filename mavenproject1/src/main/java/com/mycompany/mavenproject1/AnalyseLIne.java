/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Diyana
 */
public class AnalyseLIne {
    private static final String FILENAME = "test.txt";

    public void analyseLine() throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            int count = 0;
            int charCount = 0;
            int charCount2 = 0;
            int ttlline = 0;
            int max = 0;
            int min = 100;
            int lines = 0;
            double sum = 0;
            double avg = 0;
            String line = br.readLine();
            System.out.println("| Line \t| No of Words \t|");
            //System.out.println("|:--:|:--:|");
            int m;
            while (line != null) {
                ttlline++;
                charCount = charCount + line.length();

                String[] myWords = line.replaceAll("\\s", " ").split(" ");

                m = myWords.length;
                System.out.printf("| %2d\t| %2d \t\t|\n", ttlline, m);
                if (m > max) {
                    lines = ttlline;
                    max = m;
                }
                if (m < min) {
                    lines = ttlline;
                    min = m;
                }
                sum += m;
                avg = sum / ttlline;

                for (String s : myWords) {
                    charCount2 = charCount2 + s.length();

                }
                count = count + myWords.length;

                line = br.readLine();
            }

            System.out.println("<b> Highest number of words | <b> " + max);

            System.out.println("<b> Lowest number of words | <b> " + min);
            System.out.printf("<b> Average number of words for each line | <b> %.2f \n ", avg);

       
    }
}
