package com.stable.MovieClassy.stable.MovieClassy.Core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Timer;

/**
 * Created by menaka on 12/17/14.
 * ReadCSV class reads the main csv file and store the term document matrix
 * those variables are declared in MovieClassy.java.
 * So we extend that class
 */
public class ReadCSV extends MovieClassy{


    //Read the training data set
    public static String ReadCSV() {
        File file = new File("Words.csv");
        System.out.println("*****Program Started***** " + Time.valueOf(LocalTime.now()));

        try {
            FileReader fRead = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fRead);
            String line;
            line = bfr.readLine();
            line = line.replace("\"", "");


            words = line.split(",");
            int count = 0;

/**            Next, read each line of numbers and put them into an Integer array.
 *			   Finally, store them in a hashmap (genre and related int array)and return
 */

            while ((line = bfr.readLine()) != null) {
                String[] temp = line.split(",");
                int[] wordCount = new int[words.length];
                for (int i = 0; i < temp.length; i++) {

                    wordCount[i] = Integer.parseInt(temp[i]);
                }

                /**
                 * Other than taking the count, we normalize them to improve the accuracy
                 * */

                double[] temp2 = new double[wordCount.length];
                double total = 0;
                for (int i = 0; i < temp2.length; i++) {
                    for (int j = 0; j < temp2.length; j++) {
                        total = total + wordCount[j];
                    }
                    temp2[i] = 100.0 * wordCount[i] / total;

                }

                hMap.put(genres[count], temp2);
                count++;

            }
            System.out.println("*****Matrix Created successfully.***** " + Time.valueOf(LocalTime.now()));
            return "OK";

        } catch (IOException e) {
            System.out.println("*****Creating matrix failed*****");
            return "END";
        }
    }


}
