/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softcons.lab07.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mmahad.bese14seecs
 */
public class CSVReader {

    //Parse and read CSV file
    String csvFile = "C:\\Users\\mmahad.bese14seecs\\Documents\\NetBeansProjects\\MMahad_111701_B_Lab07\\src\\main\\java\\softcons\\lab07\\model\\test_two-anon.csv";
    String line = "";
    String cvsSplitBy = ",";

    ArrayList<String> list = new ArrayList<String>();//Creating arraylist

    public ArrayList<String> readCSV(int indexOfColumn) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] test_two_anon = line.split(cvsSplitBy);

                System.out.println("User ID= " + test_two_anon[indexOfColumn]);
                if (indexOfColumn == 0 && !test_two_anon[indexOfColumn].equals("test")) {
                    list.add(test_two_anon[indexOfColumn]);
                } else if (indexOfColumn == 3 && ! !test_two_anon[indexOfColumn].equals("0")) {
                    list.add(test_two_anon[indexOfColumn]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return list;
    }

}
