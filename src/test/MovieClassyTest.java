package test;

import com.mc_app.MC_Read;

import java.io.*;

/**
 * Created by Menaka Madushanka on 12/11/2014.
 */
public class MovieClassyTest{

    public static String filedir = "Resources/Test/";
    private static String genre;
    public static String result;


    public MovieClassyTest(String s) throws IOException {
        MovieClassyTest.genre = s;
        read();
    }

    /**Should read the plot file
     * pass plots to the MC_Read
     * Get the output to a string variable
     * check if that contains the given genre
     * if contains true else false
     * finally give the output as accuracy value
     * */

    public static void read() throws IOException {
        int yes = 0, no = 0;
        double percentage = 0.0;
        File file = new File(filedir+genre+"Test"+".txt");
        FileReader fread = new FileReader(file);
        BufferedReader bfRead = new BufferedReader(fread);


        String line;
        while((line=bfRead.readLine())!=null){
           line = line.replace("null ", "");
            line = line.replace("MV: ", "");
            line = line.replace("PL: ", "");
            line = line.toLowerCase();
            MC_Read.ReadPlot(line);
            MC_Read.check();
            result = MC_Read.print();
            if(result.contains(genre)){
                yes++;
            }else{
                no++;
            }

        }
        percentage = yes*100/(yes+no);
        System.out.println("Check on "+genre+" Percentage accuracy = " + percentage +"%");


        bfRead.close();
    }



}
