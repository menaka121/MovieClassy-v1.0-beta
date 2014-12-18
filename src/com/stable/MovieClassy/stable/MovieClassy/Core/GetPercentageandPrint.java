package com.stable.MovieClassy.stable.MovieClassy.Core;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;

/**
 * Created by menaka on 12/17/14.
 **/
public class GetPercentageandPrint extends MovieClassy {
    public static int first, second;

    /**
     **********************************************************************************************************************
     *
     * As the final step of the program, take the percentage distance for all values
     *
     **/

    //TODO: If not a plot stop printing genres - Done.
    public static String getPercentage(HashMap dg) {
        System.out.println("*****Result printed.***** " + Time.valueOf(LocalTime.now()));
        Double[] dd = new Double[dg.size()];
        double total = 0.0;
        String result = "";

        for (int i = 0; i < dg.size(); i++) {
            dd[i] = (Double) dg.get(genres[i]);
            total = total + dd[i];
        }


        /**
         * Check whether there are words that matching
         * if not can't classify.
         * */

        if (total_count <= 5) {
           result =  "Error[4]: There are no matching words!";
        } else {

            double[] genre = new double[dd.length];
            for (int j = 0; j < dd.length; j++) {
                double d = (dd[j]) * 100 / total;
                genre[j] = d;
            }

            int count = 0;
            int min = 0;
            while (count < 2) {
                for (int c = 0; c < 2; c++) {

                    for (int d = 0; d < dd.length; d++) {
                        if (dd[min] < dd[d]) {
                            if (count == 0) first = min;
                            if (count == 1) second = min;

                        } else if (genre[min] > genre[d]) {
                            min = d;
                            if (count == 0) first = min;
                            if (count == 1) second = min;

                        }
                    }
                    genre[first] = 100;
                    count++;
                    min = 0;

                }
                result = "1. " + genres[first] + "    " + "2. " + genres[second];
            }
        }
        return result;
    }

    public static String print(){
        String s = getPercentage(Check.check());
        System.out.println(s);
        return s;
    }






}
