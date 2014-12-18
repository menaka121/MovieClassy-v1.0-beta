package com.stable.MovieClassy.stable.MovieClassy.Core;

import java.util.HashMap;

/**
 * Created by menaka on 12/17/14.
 */
public class Check extends MovieClassy{

    /**
     * *********************************************************************************************************************
     *
     * For checking, we get a plot as an user input.
     * separate it in to words
     * put those words in to an array if those words present in the array that we create by reading the data file.
     *
     * We calculate the eucledean distance between each of the plots and store them in hashmap and return.
     * */
    public static HashMap check() {
        HashMap<String, Double> distGen = new HashMap<>();
        for (int i = 0; i < hMap.size(); i++) {
            double dist = 0.0;

            /**
             * calculating eucledean distance
             * */

            for (int j = 0; j < hMap.get(genres[i]).length; j++) {
                dist = dist + (Math.pow((hMap.get(genres[i])[j] - newWordPercentages[j]), 2));
            }
            dist = Math.sqrt(dist);
            dist = Math.abs(dist);
            distGen.put(genres[i], dist);
        }

        return distGen;
    }



}
