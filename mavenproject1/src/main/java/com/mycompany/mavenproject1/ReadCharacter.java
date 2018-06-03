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
import java.util.HashMap;

/**
 *
 * @author Diyana
 */
public class ReadCharacter {
    private static final String FILENAME = "test.txt";

    public void readChar() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));

            String line = br.readLine();
            int value;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            System.out.println("|Char \t|Count\t\t|");
            //System.out.println("|:--:|:--:|");
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (map.containsKey(line.charAt(i))) {
                        value = map.get(line.charAt(i));
                        value++;
                        map.put(line.charAt(i), value);
                    } else {
                        map.put(line.charAt(i), 1);
                    }
                }
                line = br.readLine();
            }
            for (Character key : map.keySet()) {
                System.out.printf("| '%c' \t|   %5d\t|\n", key, map.get(key));
            }

        
    }
}
