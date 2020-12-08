/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignmentsuger;

import java.util.Scanner;

public class Assignmentsuger {

    
    public static void main(String[] args) {
        
        
            // Setting up variables
            Scanner keyIn= new Scanner(System.in);
            int numDays, timesDay;
            double monthAverage, sumAverage=0;
            final double MAX_SUGAR= 10.0; // limit of warning for high blood sugar
            final double MIN_SUGAR= 5.0; // limit of warning for low blood sugar
            final double OK_SUGAR= 7.0; // upper limit of ideal range of blood sugar

            System.out.print("How many days in the month?: ");
            numDays= keyIn.nextInt();

            double[][] bloodSugar= new double[numDays][]; // creating an array of numDays arrays with unknown number of doubles

            for(int i = 1; i < (numDays+1); i++) // for every day of the month, prompt for timesDay
            {
                double sumDay=0, dayAverage;
                System.out.println("Today is day " + i + " of the month.");
                System.out.print("How many times did you test your blood today?: ");
                timesDay= keyIn.nextInt();
                bloodSugar[i-1]= new double[timesDay]; // creating array of timesDay doubles (test results)

                for (int j = 1; j < (timesDay+1); j++)
                {
                    System.out.print("Measurement #" + j +" of day " + i + " : "); // taking user's test results
                    bloodSugar[i-1][j-1]= keyIn.nextDouble();
                    sumDay+= bloodSugar[i-1][j-1]; // adding up the test results of the day
                }

                dayAverage= sumDay/timesDay; // calculating average blood sugar level of the day
                sumAverage+= dayAverage; // adding the day's average to the sum of averages

                System.out.println("Your measurements for today are: "); // repeating the measurements
                for (int j= 1; j < (timesDay+1); j++)
                    System.out.print(bloodSugar[i - 1][j - 1] + "\t");

                System.out.println();
                System.out.printf("Your blood sugar average today is %.1f.", dayAverage);
                System.out.println();

                // daily encouragement
                //---- not sure why, but none of these conditions are being met...
                if ((dayAverage< OK_SUGAR || Math.abs(dayAverage-OK_SUGAR) < 0.0001) && (dayAverage > MIN_SUGAR || Math.abs(dayAverage-MIN_SUGAR) < 0.0001))
                    System.out.println("That's pretty good. Today was a good day. Keep up the good work.");

                if (dayAverage > OK_SUGAR && dayAverage < MAX_SUGAR)
                    System.out.println("That's not bad. Try to bring it down a little bit.");

                // daily warnings
                if (dayAverage > MAX_SUGAR || Math.abs(dayAverage-MAX_SUGAR) < 0.0001)
                    System.out.println("That's too high. Be more careful tomorrow.");

                if (dayAverage < MIN_SUGAR)
                    System.out.print("That's a too low. Be more careful tomorrow.");
            }

            monthAverage= sumAverage/numDays; // calculating monthly average
            System.out.println();
            System.out.printf("Your monthly average is %.1f.", monthAverage);
            System.out.println();

            // monthly encouragement
            //---- not sure why, but none of these conditions are being met...
            if ((monthAverage< OK_SUGAR || Math.abs(monthAverage-OK_SUGAR) < 0.0001) && (monthAverage > MIN_SUGAR || Math.abs(monthAverage-MIN_SUGAR) < 0.0001))
                System.out.println("That's pretty good. This is a good month. Keep up the good work.");

            if (monthAverage > OK_SUGAR && monthAverage < MAX_SUGAR)
                System.out.println("That's not bad. Try to bring it down a little bit.");

            // daily warnings
            if (monthAverage > MAX_SUGAR || Math.abs(monthAverage-MAX_SUGAR) < 0.0001)
                System.out.println("That's too high. Be more careful next month.");

            if (monthAverage < MIN_SUGAR)
                System.out.print("That's a too low. Be more careful next month.");

    } 
    }
    
