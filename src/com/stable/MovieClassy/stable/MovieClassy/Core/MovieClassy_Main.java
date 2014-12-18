package com.stable.MovieClassy.stable.MovieClassy.Core;

/**
 * Created by menaka on 12/17/14.
 */
public class MovieClassy_Main {



    public static void main(String[] args){

        //A sample plot for testing
        String plot = " 109 is a documentary series that examines significant social and cultural trends transforming Canadian society. We live in a world where national borders crumble in the face of sweeping social and cultural trends. Instant communications. Internet and easy travel have created a world where people and ideas move freely. Cultures and trends spread around the globe at the speed of light. And Perhaps because of its cultural diversity. Canada finds itself at the crossroad of these vast and influential trends. 109 examines how Canadian find themselves swept up by trends. A road map to the social and cultural trends that affect your lives today. Magda (Dragoumi) witnesses a lethal car accident, with her own daughter Aimilia (Aktypi) being the victim. The driver leaves the little girl helpless and disappears. Magda discovers the man who is responsible for the death of her daughter (Kazanas), she stalks him, and she also seduces him. Emma Sonnet was mysteriously abducted two years ago during a summer trip to Greece while celebrating her graduation from law school. Today she resurfaces just as mysteriously with a unique take on the law. Upon discovering her strange and remarkable abilities, she becomes torn between battling in the courtroom and dealing justice in the streets her own way as the 10th Muse.\n" +
            "null";

        String result;

        //Create an object to read the csv file
        ReadCSV a = new ReadCSV();

        //Create an object to read the plot and store the words in the matrix
        ReadPlot readplot = new ReadPlot(plot);



        result = GetPercentageandPrint.print();

        System.out.println(result);

    }
}
