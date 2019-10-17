/*
 * Program Name: Cis36Fall2019FikerWHw1Ex1.java
 * Discussion:   Hw #1, Ex #1
 * Written By:   Fiker workene
 * Date:         2019/09/03
 */

import java.util.*;

public class Cis36Fall2019FikerWHw1Ex1 
{
    public static void main(String[] arg)
    {
        System.out.println("CIS 36A - Java Programming I" +
		"\nLaney College" +
		"\nFiker workene" +
		"\n\nAssignment Information --" +
		"\n  Assignment Number: Homework 01," +
		"\n                     Exercise #1" +
		"\n  Written by:        Fiker workene" +
		"\n  Due Date:          2019/09/03");
        
        runMenu();
    }
    
    public static int runMenu()
    {
        int option;
        int usrValue;
        int size;
        int[] ary = null;
        Scanner scanner = new Scanner(System.in);
        int smallestValueWithSmallestTODC;
        
        do
        {
            System.out.println(
                  "\n************************************************" +
                  "\n*              MENU - Hw #1                    *" +
                  "\n* 1. getSmallestIntegerWithSmallestTODC()      *" +
                  "\n* 2. Quit                                      *" +
                  "\n************************************************");
            
            System.out.print("\nSelect an option (use integer value only): ");  
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print("\nWhat is the size of the array? ");
                    size = scanner.nextInt();
                    System.out.print("\n");
                    
                    ary = new int[size];
                    for (int i = 0; i < ary.length; i++)
                    {
                        System.out.print("  Value #" + 
                                (i + 1) + ": ");
                        ary [i] = scanner.nextInt();
                    }
                    
                    System.out.println("\nThe working array has " +
                            size + " values of");
                    for (int i = 0; i < ary.length; i++)
                    {
                        System.out.println("  " +ary[i]);
                        
                    }
                    
                    System.out.println("\nCalling getSmallestInteger" +
                            "WithSmallestTODC() with arguments of\n");
                    
                    System.out.print("1. The array of {");
                    for (int i = 0; i < ary.length -1; i++)
                            System.out.print(ary[i] + ", ");
                    System.out.print(ary[ary.length - 1] + "}\n");
                    
                    smallestValueWithSmallestTODC = 
                            getSmallestIntegerWithSmallestTODC(ary);
                    
                    System.out.println("\nThe smallest integer" +
                            " with smallest TODC : " +
                            smallestValueWithSmallestTODC);
                    break;
                case 2:
                    System.out.println("\n  Having Fun ...");
                    break;
                default:
                    System.out.println("\nYou are very funny here!");
            }
        } while (option != 2);
        
        return 0;
    }
    
    public static int getSmallestIntegerWithSmallestTODC(int[] ary)
    {
        int smallestInt = getIntWithSmallestTODC(ary);
        int smallestTODC = getSmallestTODC(ary);
        
        for (int i = 0; i < ary.length; i++)
        {
            if (getTODC(ary[i]) == smallestTODC)
            {
                if (smallestInt > ary[i])
                {
                    smallestInt = ary[i];
                }
            }
        }
        
        return smallestInt;
    }
    
    public static int getIntWithSmallestTODC(int[] ary)
    {
        int intWithSmallestTodc = 0;
        int smallestTodc = getSmallestTODC(ary);
        
        for (int i = 0; i < ary.length; i++)
        {
            if(smallestTodc == getTODC (ary[i]))
            {
                intWithSmallestTodc = ary[i];
                i = ary.length;
            }
        }
        
        return intWithSmallestTodc;
    }
    
    public static int getSmallestTODC(int[] ary)
    {
        int smallestTodc = getTODC(ary[0]);
        
        for (int i = 1; i < ary.length; i++)
        {
            if (smallestTodc > getTODC(ary[i]))
            {
                smallestTodc = getTODC(ary[i]);
            }
        }
        
        return smallestTodc;
    }
    
    public static int getTODC(int arg)
    {
        int todc = 0;
        
        while (arg != 0)
        {
            if (arg % 2 != 0)
            {
                todc++;
            }
            
            arg /= 10;
        }
        
        return todc;
    }
}

/**Program Output
 CIS 36A - Java Programming I
Laney College
Fiker workene

Assignment Information --
  Assignment Number: Homework 01,
                     Exercise #1
  Written by:        Fiker workene
  Due Date:          2019/09/03

************************************************
*              MENU - Hw #1                    *
* 1. getSmallestIntegerWithSmallestTODC()      *
* 2. Quit                                      *
************************************************

Select an option (use integer value only): -4

You are very funny here!

************************************************
*              MENU - Hw #1                    *
* 1. getSmallestIntegerWithSmallestTODC()      *
* 2. Quit                                      *
************************************************

Select an option (use integer value only): 1

What is the size of the array? 3

  Value #1: 1004
  Value #2: -2103451
  Value #3: 80645

The working array has 3 values of
  1004
  -2103451
  80645

Calling getSmallestIntegerWithSmallestTODC() with arguments of

1. The array of {1004, -2103451, 80645}

The smallest integer with smallest TODC : 1004

************************************************
*              MENU - Hw #1                    *
* 1. getSmallestIntegerWithSmallestTODC()      *
* 2. Quit                                      *
************************************************

Select an option (use integer value only): 1

What is the size of the array? 4

  Value #1: -1
  Value #2: -22
  Value #3: 88
  Value #4: 66

The working array has 4 values of
  -1
  -22
  88
  66

Calling getSmallestIntegerWithSmallestTODC() with arguments of

1. The array of {-1, -22, 88, 66}

The smallest integer with smallest TODC : -22

************************************************
*              MENU - Hw #1                    *
* 1. getSmallestIntegerWithSmallestTODC()      *
* 2. Quit                                      *
************************************************

Select an option (use integer value only): 1

What is the size of the array? 5

  Value #1: 1
  Value #2: -3
  Value #3: 9
  Value #4: -7
  Value #5: 5

The working array has 5 values of
  1
  -3
  9
  -7
  5

Calling getSmallestIntegerWithSmallestTODC() with arguments of

1. The array of {1, -3, 9, -7, 5}

The smallest integer with smallest TODC : -7

************************************************
*              MENU - Hw #1                    *
* 1. getSmallestIntegerWithSmallestTODC()      *
* 2. Quit                                      *
************************************************

Select an option (use integer value only): 2

  Having Fun ...
 */

/**Logic Code Output Issues
 * No comment!
 */