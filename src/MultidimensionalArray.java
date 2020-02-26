/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Math.pow;

public class MultidimensionalArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

    int[] size = new int[2];                                                    // array to store size of an array 

    int i = 0;

    File file = new File("src/ELEVATIONS.TXT");                            // File input providing path in args

        Scanner scanner = new Scanner(file);                                    // Class for reading a file
        
        while(scanner.hasNext() && i <2){                                       // reads file until it encounters next value
            size[i] = scanner.nextInt();
            i++;
        }
        
        int[][] data = new int[size[0]][size[1]];                               // 2d - array for actual data 
        
        for(int row = 0; row<data.length;row++){
            
            for(int column = 0; column< data[row].length;column++){             // looping through data
                data[row][column] = scanner.nextInt();                          // loading array with data
                
            }
        }

        scanner.close();                                                        // file must be closed

        
    int smallestValue = data[0][0] + 1;                                         // intializing all values
    int valueReps = 0;
    int rowForValue = 0;
    int columnForValue =0;
    float distance  = data[size[0] -1][size[1] - 1];
    float distanceOfValue;
    
    
    for(int row = 0; row<data.length;row++){
        for(int column = 0; column< data[row].length;column++){                 // looping through data
            
            if(data[row][column] < smallestValue){                              // checking the conditions
                smallestValue = data[row][column];
                distance = (float) pow((row*row + column*column),0.5);          // calculting the distance
                rowForValue = row;                                              // storing the index
                columnForValue = column;
                valueReps = 1;                                                  // intialize the value with 1 for first time
            }
            else if(data[row][column] == smallestValue){                        // encountering second time
                    valueReps++;                                                // increasing the repition value
                    distanceOfValue = (float) pow((row*row + column*column),0.5);   // distance calculated for new value
                    if(distanceOfValue < distance){                             // checking the condition if distance we calclated is 
                        rowForValue = row;                                      // less than distance we calculated first
                        columnForValue = column;                                // updating the index values
                        distance = distanceOfValue;                             // updating the distance value
                        
                    }
                }
        }
    }
    
        System.out.println("Smallest number is " + smallestValue + " and it is on row " + rowForValue + " and column " + columnForValue
            + " and the distance is " + distance + " it is repeated for " + valueReps);
     
        int containerCount = 0;                                             
        int peakCounter = 0;
        int tempCounter = 0;
        boolean peakFlag;    
        
        for(int down =0;down<data.length - 5;down++){                           // loops through all rows except 2 at the top and bottom
            
            for(int side = 0;side<data[size[0] - 1].length -4;side++){          // loops through all columns except 2 on very right and left
        
                
                        if(data[down+2][side+2] <= 9000 && data[down+2][side+2] >=8900){    // is number between defined range
                            
                                
//                            System.out.print(data[down+2][side+2] + " ");
                            peakFlag = true;                                    // assuming the value is peak
                            
                        
                            for(int row= down;row<=down+4;row++){               // looping through data surrounded with peak
                    
                                for(int col = side;col<=side+4;col++){
                                    
                                    
                                    if(data[down+2][side+2] >= data[row][col] && peakFlag ){    // if value is grater than the surrounded data so far
                                        peakFlag =true;
                                        
                                    }
                                    else{                                       // otherwise value is not a peak and it is intialized as false
                                        peakFlag =false;
                                    }
                                    
                                    
                                }
                            }
                            
                            if(peakFlag == true){                               // checks if the value has been given the flag true then is counter is increased
                                peakCounter++;
                            }
                            
                            
                        }
                        
                        
                        
            }
        }
        System.out.println("The total number of peaks is "+ peakCounter);

     
    int[] loops = new int[data.length*data[0].length];                          // assigning the 2-d array size as a 1-d array to store it
    for(int row =0; row < data.length; row++){
        for(int col =0; col < data[row].length;col++){                          // looping through the data
            loops[data[row][col]]++;                                            // increasing the counter for the pecific data if it is repeated
        }
    }
    
    int maxElevation = 0;
    int commonElevation = 0;
    for(int elevation =0;elevation< loops.length;elevation++){                  // looping through whole 1-d rray data
        if(loops[elevation] > maxElevation){                                    // updating the number to store maximum number of elevation to stored in
            maxElevation = loops[elevation];
            commonElevation = elevation;                                        // updating the common elevation value with the maximum number of elevation
        }
    }
        System.out.println("The most repeated elevation is "+commonElevation + " and it repeated for " + maxElevation);
    }
}
