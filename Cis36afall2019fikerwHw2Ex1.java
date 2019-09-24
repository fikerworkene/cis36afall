
/*
 * Program name:  Cis36aFall2019FikerWHw2Ex1.java
 * Discussion:    Hw #2, Ex #1
 * Written by: 	  Fiker Workene
 * Date:          2019/09/17
 */

import java.util.*;

  class Cis36aFall2019FikerwHw2Ex1
  {
    public static void main(String[] args)
    {  
        System.out.println("CIS 36A - Java Programming "
                +"\nLaney College" + "\nFiker Workene");   
        System.out.println("\nAssignment Information --" +
                          "\n\tAssignment Number: \tHomework 02," +
                          "\n\t\t\t\tCoding Assignment -- Exersice #1" +
                          "\n\tWritten by: " + "\t\tFiker Workene"+
                          "\n\tDue date: "+ "\t\t2019/09/17"); 
    
        menuHw2();
    } 
    
    public static void menuHw2() 
    {
        int[] array1;
        int[] array2;
        int option;
        Scanner scanner = new Scanner(System.in);
        int sizeInput;
        
        do
        { 
            System.out.println(
                  "\n************************************************" +
                  "\n*              MENU                            *" +
                  "\n* (1) Calling extractLargestAndSmallestFikerW()*" +
                  "\n* (2) Quit                                     *" +
                  "\n************************************************");
                    
            System.out.print("Select an option (1 or 2): ");
            option = scanner.nextInt();
            
            switch(option) 
            {
                case 1:
                    System.out.print("\nBuilding the first array - ");
                    System.out.print("\n\tEnter the array size: ");
                    sizeInput = scanner.nextInt();
                    array1 = new int[sizeInput];
                    
                    System.out.print("\tEnter the array element values - ");
                    
                    for (int i = 0; i < array1.length; i++) 
                    {
                        array1[i]= scanner.nextInt();
                    }
                    for (int i = 0; i < array1.length; i++) 
                    {
                        System.out.println("\t\tIndex " + i + ": "+ array1[i]);
                    }
                    
                    System.out.print("\nBuilding the second array - ");
                    System.out.print("\n\tEnter the array size: ");
                    sizeInput = scanner.nextInt();
                    array2 = new int[sizeInput];
                    
                    System.out.print("\tEnter the array element values - ");
                    for (int i = 0; i < array2.length; i++) 
                    
                    {
                        array2[i]= scanner.nextInt();
                    }
                    for (int i = 0; i < array2.length; i++) 
                    {
                        System.out.println("\t\tIndex " + i + ": "+ array2[i]);
                    }
                    
                    System.out.println("\nCalling " + 
                            "extractLargestAndSmallestFikerW() --");
                    
                    System.out.println("\nAfter finishing the call "+
                            "the returning array - ");
                    extractLargestAndSmallestFikerW(array1, array2);
                    
                    break;
                case 2:
                    System.out.println("\nHaving fun!");
                    break;
                    
                default:
                    System.out.println("\nWRONG OPTION!");
            }
            
        }while (option != 2);
     
    }
    
    public static void extractLargestAndSmallestFikerW
    (int[] ary1, int[] ary2) 
    {
        int[] result1;
        int[] result2;  
        
        result1 = extractLargest(ary1, ary2);
        result2 = extractSmallest(ary1, ary2);
        
        for (int i = 0; i < result1.length; i++)
        {
            System.out.print(result1[i] + " ");
        }
        for (int i = 0; i < result2.length; i++) 
        {
            if (i == ary2.length - 1) 
                System.out.print(result2[i] + "\n"); 
            else 
                System.out.print(result2[i] + " ");
        }
    }
    
    public static int[] extractLargest(int ary1[], int ary2[]) 
    {  
        int[] resultAry = null;
        int largest;
        int count = 0; 
        int arrayIndexFlag = 0;
        //int tmp= resultAry.length;
        //int tmp;
        
        largest = ary1[0];
        
        for (int i = 1; i < ary1.length; i++) 
        {
            if (largest < ary1[i])
                largest = ary1[i];
        }
        
        for (int i = 0; i < ary2.length; i++) 
        {
            if (largest < ary2[i])
                largest = ary2[i];
        }
        
        for (int i = 0; i < ary1.length; i++)
        {
            if (ary1[i] == largest)
            {
                count++;
                i = ary1.length;
            }
        }
       
        for (int i = 0; i < ary2.length; i++) 
        {
            if (ary2[i]==largest)
            {
                count++;
                i = ary2.length;
            }
        }
        
        for (int i = 0; i < ary1.length; i++) 
        {
            if (count !=2)
                if(ary1[i] == largest)
                    arrayIndexFlag = 1;
        }
        
        for (int i = 0; i < ary2.length; i++) 
        {
            if (count !=2)
                if(ary2[i] == largest)
                    arrayIndexFlag = 2;
        }
        
        resultAry = new int[1 + 1 + ((arrayIndexFlag != 0) ? 1 : 2)];
        
        resultAry[0] = largest;
        resultAry[1] = count;
        if (count == 2){
            resultAry[2] = 1;
            resultAry[3] = 2;
            
        }
        else 
            resultAry[2] = arrayIndexFlag;
        
        return resultAry;
    }
    
    public static int[] extractSmallest(int ary1[], int ary2[]) 
    {   
        int[] resultAry =null;
        int smallest;
        int count = 0; 
        int arrayIndexFlag = 0;
        //int tmp= resultAry.length;
        //int tmp;
        
        smallest = ary1[0];
        
        for (int i = 1; i < ary1.length; i++) 
        {
            if (smallest > ary1[i])
                smallest = ary1[i];
        }
        
        for (int i = 0; i < ary2.length; i++) 
        {
            if (smallest > ary2[i])
                smallest = ary2[i];
        }
        
        for (int i = 0; i< ary1.length; i++) 
        {
            if (ary1[i] == smallest)
            {
                count++;
                i = ary1.length;
            }
        }
       
        for (int i = 0; i < ary2.length; i++)
        {
            if (ary2[i]==smallest)
            {
                count++;
                i = ary2.length;
            }
        }
        
        for (int i = 0; i<ary1.length; i++) 
        {
            if (count !=2)
                if(ary1[i] == smallest)
                    arrayIndexFlag = 1;
        }
        
        for (int i = 0; i < ary2.length; i++) 
        {
            if (count !=2)
                if(ary2[i] == smallest)
                    arrayIndexFlag = 2;
        }
        
        resultAry = new int[1 + 1 + ((arrayIndexFlag != 0) ? 1 : 2)];
        
        resultAry[0] = smallest;
        resultAry[1] = count;
        if (count == 2){
            resultAry[2] = 1;
            resultAry[3] = 2;
            
        }
        else 
            resultAry[2] = arrayIndexFlag;
        
        return resultAry;
    } 
  }
    
    
 /**PROGERAM OUTPUT 
  CIS 36A - Java Programming 
Laney College
Fiker Workene

Assignment Information --
	Assignment Number: 	Homework 02,
				Coding Assignment -- Exersice #1
	Written by: 		Fiker Workene
	Due date: 		2019/09/17

************************************************
*              MENU                            *
* (1) Calling extractLargestAndSmallestFikerW()*
* (2) Quit                                     *
************************************************
Select an option (1 or 2): 1

Building the first array - 
	Enter the array size: 5
	Enter the array element values - -15 450 63 -9 90
		Index 0: -15
		Index 1: 450
		Index 2: 63
		Index 3: -9
		Index 4: 90

Building the second array - 
	Enter the array size: 6
	Enter the array element values - 100 -151 450 6 -91 9
		Index 0: 100
		Index 1: -151
		Index 2: 450
		Index 3: 6
		Index 4: -91
		Index 5: 9

Calling extractLargestAndSmallestFikerW() --

After finishing the call the returning array - 
450 2 1 2 -151 1 2 
************************************************
*              MENU                            *
* (1) Calling extractLargestAndSmallestFikerW()*
* (2) Quit                                     *
************************************************
Select an option (1 or 2): 3

WRONG OPTION!

************************************************
*              MENU                            *
* (1) Calling extractLargestAndSmallestFikerW()*
* (2) Quit                                     *
************************************************
Select an option (1 or 2): 1

Building the first array - 
	Enter the array size: 7
	Enter the array element values - 15 450 63 -900 90 -900 90
		Index 0: 15
		Index 1: 450
		Index 2: 63
		Index 3: -900
		Index 4: 90
		Index 5: -900
		Index 6: 90

Building the second array - 
	Enter the array size: 6
	Enter the array element values - 100 -151 4500 6 -91 9
		Index 0: 100
		Index 1: -151
		Index 2: 4500
		Index 3: 6
		Index 4: -91
		Index 5: 9

Calling extractLargestAndSmallestFikerW() --

After finishing the call the returning array - 
4500 1 2 -900 1 1 
************************************************
*              MENU                            *
* (1) Calling extractLargestAndSmallestFikerW()*
* (2) Quit                                     *
************************************************
Select an option (1 or 2): 2

Having fun!
  */ 

/**Logic_Code_Output Issues
 * 
 */

 



    
    

