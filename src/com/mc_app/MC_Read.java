package com.mc_app;

import java.io.*;
import java.util.*;


public class MC_Read {

	/**
	 * Main variable declarations.
	 * I this program, all the common variables are declared as static because they can be accessed by any method from any where.
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


	/**
	 * *********************************************************************************************************************
	 * ----------------------Training Data File--------------------------
	 * our data file contains a matrix, which is called Document term matrix.
	 * This matrix is consists of words, and the count of each word in each document
	 * The Training data file is created by using R separately.
	 * We use that data file as our source of data
	 *
	 * */


	//Read the training data set
	public static void ReadCSV() {
		File file = new File("Resources/Words.csv");

		try {
			FileReader fRead = new FileReader(file);
			@SuppressWarnings("resource")
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


		} catch (IOException e) {
			System.out.println("*.csv file doesn't exists or cannot find!");
		}
	}

	/**
	 **********************************************************************************************************************
	 * Now, read the given movie plot and put the words into an array.
	 * */
	public static void ReadPlot(String line2) throws IOException {

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


		for(int j = 0 ; j < words.length; j++){
			newWordPercentages[j] = (double)newWC[j]*100/total;
		}
	}

	/**
	 * *********************************************************************************************************************
	 *
	 * For checking, we get a plot as an user input.
	 * separate it in to words
	 * put those words in to an array if those words present in the array that we create by reading the data file.
	 *
	 * We calculate the eucledean distance between each of the plots and store them in hashmap and return.
	 * */


	public static  HashMap<String, Double> check() {
		Double[] temp_int = new Double[genres.length];
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
				temp_int[i] = dist;
				distGen.put(genres[i], dist);
			}

		return distGen;
	}

	/**
	 **********************************************************************************************************************
	 *
	 * As the final step of the program, take the percentage distance for all values
	 * */

		public static String getPercentage(HashMap<String, Double> dg){
			Double[] dd = new Double[dg.size()];
			double total = 0.0;
			 result = "";

			for(int i = 0; i<dg.size(); i++){
				dd[i] = (Double) dg.get(genres[i]);
				total = total + dd[i];
			}


			/**
			 * if all the distances are equal or very close, then the maximum value that one genre could get is 0
			 * So, as we take the shortest distances, we separate the distances below 20;
			 * */

			for(int j = 0; j<dd.length; j++){
				double d = (dd[j])*100/total;
				if(d<20){
					result = result +" "+  genres[j];
				}
			}


			return result;
	}


	/**
	 * *********************************************************************************************************************
	 * */

	public static String print(){
		String s = getPercentage(check());
		return s;
	}

}

