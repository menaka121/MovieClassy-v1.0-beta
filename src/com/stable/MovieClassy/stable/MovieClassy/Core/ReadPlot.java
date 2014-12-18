package com.stable.MovieClassy.stable.MovieClassy.Core;

/**
 * Created by menaka on 12/17/14.
 * Reads the given plot and store
 */
public class ReadPlot extends MovieClassy{

    /**
     **********************************************************************************************************************
     * Now, read the given movie plot and put the words into an array.
     * */
    public ReadPlot(String line2){
        System.out.println("Classification process started...");
        String[] newCount;
        newWC = new int[words.length];
        newWordPercentages = new double[words.length];

        newCount = line2.split(" ");

        int total = 0;
        for(int j = 0 ; j < words.length; j++){

            int count = 0;
            for(int i = 0; i < newCount.length; i++){
                if(words[j].equals(newCount[i])) {
                    count++;

                }else{

                    newWC[j] = 0;
                }
            }
            newWC[j] = count;
            total = total + count;
        }

        total_count = total;

        System.out.println(total);

        for(int j = 0 ; j < words.length; j++){
            newWordPercentages[j] = (double)newWC[j]*100/total;
        }
    }


}
