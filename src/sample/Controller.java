package sample;


/**
 * this class is the main class that controls the gui.
*/


import com.stable.MovieClassy.stable.MovieClassy.Core.GetPercentageandPrint;
import com.stable.MovieClassy.stable.MovieClassy.Core.ReadCSV;
import com.stable.MovieClassy.stable.MovieClassy.Core.ReadPlot;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;

public class Controller {
    public Label result;
    public TextArea plot;

    //Create an object to read the csv file
    String a = ReadCSV.ReadCSV();


    public void getGenre(ActionEvent actionEvent) throws IOException {

        String newPot = plot.getText();

        //If the plot is null, system should warn the user to enter a plot
        if(newPot.equals("")){
            result.setTextFill(Color.MAROON);
            result.setText("Error[1]: Enter a plot!");

            System.out.println("*****Error: No plot (ref 1)*****" + " " + Time.valueOf(LocalTime.now()));

        //If the system cannot find the data source
        }else if(a.equals("END")){
            result.setTextFill(Color.RED);
            System.out.println("*****Error: Cannot find Word.csv! (ref 2)*****" + " " + Time.valueOf(LocalTime.now()));

            result.setText("Error[2]: Missing Word.csv file");

        //If the entered plot is not valid
        }else if (newPot.length() < 100) {
            result.setTextFill(Color.ORANGE);
            System.out.println("*****Error: Entered plot is not valid (ref 3)*****" + " " + Time.valueOf(LocalTime.now())) ;

            result.setText("Error[3]: Entered plot is not valid!");
        } else {

            /**
             * if the plot is present the system should run and give the output
             * */
            String result1;


            //Create an object to read the plot and store the words in the matrix
            ReadPlot readplot = new ReadPlot(newPot);


            result1 = GetPercentageandPrint.print();

            result.setTextFill(Color.ROYALBLUE);
            result.setText(result1);
        }
        }


    /**
     * when clear button is pressed, the result and the text area must be cleared.
     * */
    public void clear(ActionEvent actionEvent) {
        plot.clear();
        result.setText("");
        System.out.println("*****Cleared***** " + Time.valueOf(LocalTime.now()));
    }
}
