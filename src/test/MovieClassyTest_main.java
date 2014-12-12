package test;

import com.mc_app.MC_Read;

import java.io.IOException;

/**
 * Created by Menaka Madushanka on 12/11/2014.
 */
public class MovieClassyTest_main {
    public static void main(String[] args) throws IOException {
        MC_Read.ReadCSV();
        new MovieClassyTest("Action");
        new MovieClassyTest("Adventure");
        new MovieClassyTest("Comedy");
        new MovieClassyTest("Drama");
        new MovieClassyTest("Romance");


    }
}
