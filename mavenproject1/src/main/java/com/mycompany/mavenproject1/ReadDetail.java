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
public class ReadDetail {
    private static final String FILENAME = "test.txt";

    public void readDetails() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            int letter = 0;
            int space = 0;
            int num = 0;
            int other = 0;
            String line = br.readLine();
            while (line != null) {
                String x = line;
                char[] ch = x.toCharArray();

                for (int i = 0; i < x.length(); i++) {
                    if (Character.isLetter(ch[i])) {
                        letter++;
                    } else if (Character.isDigit(ch[i])) {
                        num++;
                    } else if (Character.isSpaceChar(ch[i])) {
                        space++;
                    } else {
                        other++;
                    }
                }

                line = br.readLine();
            }
            System.out.printf("Number of characters - letter \t\t | %6d \n", letter);
            System.out.printf("Number of characters - space \t\t | %6d \n", space);
            System.out.printf("Number of characters - number \t\t | %6d \n", num);
            System.out.printf("Number of characters - other\t\t | %6d \n", other);

       
    }

}
