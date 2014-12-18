package com.stable.MovieClassy.stable.MovieClassy.Core;


import java.util.HashMap;

/**
 * Created by menaka on 12/17/14.
 * this is the parent class of the program.
 * All other classes are extends this class
 */
public class MovieClassy {
    /**
     * Contains,
     *      All variable declarations
     *      Parent methods null
     * */

    /**The main array to store movie genres that we are going to do our classification*/
    public static String[] genres = {"Action", "Adventure", "Comedy", "Drama", "Romance"};

    /**This array is to store words that are read from the training data file*/
    public static String[] words;

    /**This HashMap stores the genre and the array containing the percentage values*/
    public static HashMap<String, double[]> hMap = new HashMap<>();

    /**Read the given movie plot and store the word counts*/
    public static int[] newWC;

    /**Stores the percentage of words based on the newWC array*/
    static double[] newWordPercentages;

    /**Final string that returns*/
    static String result = "";

    /**To store the number of words in the given plot*/
    static double total_count = 0.0;

 }
