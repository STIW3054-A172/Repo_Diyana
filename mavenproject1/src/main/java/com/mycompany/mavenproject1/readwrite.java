/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.opencsv.CSVReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Diyana
 */
public class readwrite {
   
    Writer writer = null;

    boolean test = true;

    public void createFile() throws IOException {
        File file = new File("test.txt");
        writer = new BufferedWriter(new FileWriter(file));
    }

    public void readData() throws IOException, InvalidFormatException {
        System.out.println("Generating new txt file......\n");
        createFile();
        
        String csvFile = "tweets.csv";
        
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            System.out.println("Write to txt file......\n");
            while ((line = reader.readNext()) != null) {
                //System.out.println("" + line[0] + ", " + line[1] + "");
                
                writer.write("" + line[0] + " , " + line[1] + "\n");
                
                
            }
            System.out.println("Closing txt file......\n");
            closeFile();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
/**
        Workbook workbook = WorkbookFactory.create(new File("tweets.csv"));
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("Read from xlsx file......\n");
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        System.out.println("Write to txt file......\n");
        Iterator<Row> rowIterator = sheet.rowIterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                //System.out.print(cellValue + " ");
                writer.write(cellValue + " ");
            }
            //System.out.println();
            writer.write("\n");

        }
        System.out.println("Closing txt file......\n");
        closeFile();
        * */
    }

    public void closeFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
