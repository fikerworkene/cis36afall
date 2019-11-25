/*
 * Program Name: PointUtilityFikerW.java
 * Discussion:   Points and Operations
 * Written By:   Fiker Workene
 * Date:         2019/11/14
 */

import java.util.*;

public class PointUtilityFikerW {
    public static void runMenuHw5() {
        int option;
        PointFikerW[] obj = new PointFikerW[2];
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n\n*******************************" +
                    "\n*         MENU - Hw #5        *" +
                    "\n*  1. Initializing (2 Points) *" +
                    "\n*  2. Placement               *" +
                    "\n*  3. Moving                  *" +
                    "\n*  4. Flipping                *" +
                    "\n*  5. Displaying              *" +
                    "\n*  6. Quit                    *" +
                    "\n*******************************" +
                    "\nSelect an option " +
                    "(use integer value only): ");
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print(
                            "\nInitializing SubMENU -");
                    obj = init(obj);
                    
                    break;
                case 2:
                    System.out.print("\nPlacement -");
                    getQuadrantMenu(obj);
                    
                    break;
                case 3:
                    System.out.print("\nMoving Points -");
                    moveMenu(obj);
                    
                    break;
                case 4:
                    System.out.print("\nFlipping Points -");
                    flipMenu(obj);
                    
                    break;
                case 5:
                    System.out.print("\nDisplaying Points --" + 
                            "\n  Point 1:");
                    obj[0].display();   //point 1
                    
                    System.out.print("\n  Point 2: ");
                    obj[1].display();  //point 2
                     
                    break;
                case 6:
                    System.out.print("\nHave Fun ...!");
                    
                    break;
                default:
                    System.out.print("\nToo Funny!");
            }
        } while (option != 6);
    }
    
    public static PointFikerW[] init(PointFikerW[] ary)
    {
        int p1n1;
        int p1d1;
        int p1n2;
        int p1d2;
        int p2n1;
        int p2d1;
        int p2n2;
        int p2d2;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nPoint 1 x num:   ");
        p1n1 = scanner.nextInt();
        System.out.print("\nPoint 1 x denom: ");
        p1d1 = scanner.nextInt();
        
        System.out.print("\nPoint 1 y num:   ");
        p1n2 = scanner.nextInt();
        System.out.print("\nPoint 1 y denom: ");
        p1d2 = scanner.nextInt();
        ary[0] = new PointFikerW(p1n1, p1d1, p1n2, p1d2);
        
        System.out.print("\nPoint 2 x num:   ");
        p2n1 = scanner.nextInt();
        System.out.print("\nPoint 2 x denom: ");
        p2d1 = scanner.nextInt();
        
        System.out.print("\nPoint 2 y num:   ");
        p2n2 = scanner.nextInt();
        System.out.print("\nPoint 2 y denom: ");
        p2d2 = scanner.nextInt();
        ary[1] = new PointFikerW(p2n1, p2d1, p2n2, p2d2);
        
        return ary;
    }
    
    public static PointFikerW[] getQuadrantMenu(PointFikerW[] p)
    {
        int option;
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n\n   *******************************" +
                    "\n   *   SUB MENU - Placement      *" +
                    "\n   *  1. Against Origin          *" +
                    "\n   *  2. Against the other Point *" +
                    "\n   *  3. Quit                    *" +
                    "\n   *******************************" +
                    "\n   Select an option " +
                    "(use integer value only): ");
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print("\n     Against Origin -" +
                            "\n     Point 1 placed in Q" +
                            p[0].getQuadrant() + 
                            "\n     Point 2 placed in Q" +
                            p[1].getQuadrant());
                    
                    break;
                case 2:
                    System.out.print(
                            "\n     Against the other Point -" +
                            "\n     Point 1 is in Q" +
                            p[0].getQuadrant(p[1]) + 
                            " against Point 2" +
                            "\n     Point 2 is in Q" +
                            p[1].getQuadrant(p[0]) + 
                            " against Point 1");
                    
                    break;
                case 3:
                    System.out.print(
                            "\n     Return to MENU - HW#5");
                    
                    break;
                default:
                    System.out.print("\nToo Funny!");
            }
        } while (option != 3);
        
        return p;
    }
    
    public static PointFikerW[] moveMenu(PointFikerW[] p)
    {
        int option;
        int input1;
        int input2;
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n\n   *******************************" +
                    "\n   *   SUB MENU - Moving         *" +
                    "\n   *  1. Moving by an int        *" +
                    "\n   *  2. Moving by a Fraction    *" +
                    "\n   *  3. Moving by (delX, delY)  *" +
                    "\n   *  4. Quit                    *" +
                    "\n   *******************************" +
                    "\n   Select an option " +
                    "(use integer value only): ");
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print("\n   Moving by an int -" +
                            "\n\n      Enter number " +
                            "(only integer): ");
                    input1 = scanner.nextInt();
                    p[0].moveByInt(input1);
                    p[1].moveByInt(input1);
                    p[0].display();
                    p[1].display();
                    
                    break;
                case 2:
                    System.out.print("\n   Moving by a Fraction -" +
                            "\n      Enter num: ");
                    input1 = scanner.nextInt();

                    System.out.print("\n      Enter denom:  ");
                    input2 = scanner.nextInt();
                    p[0].move(new FractionFikerW(input1, input2));
                    p[1].move(new FractionFikerW(input1, input2));
                    
                    p[0].display();
                    p[1].display();
                    
                    break;
                case 3:
                    System.out.print("\n   Moving by (delX, delY) -");
                    moveByPoint(p[0]);
                    moveByPoint(p[1]);
                    
                    break;
                case 4:
                    System.out.print(
                            "\n   Returning to Previous Menu!");
                    
                    break;
                default:
                    System.out.print("\n   Too Funny!");
            }
        } while (option != 4);
        
        return p;
    }
    
    public static PointFikerW[] flipMenu(PointFikerW[] p)
    {
        int option;
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n\n   **********************************" +
                    "\n   *   SUB MENU - Flipping          *" +
                    "\n   *  1. Flipped by X               *" +
                    "\n   *  2. Flipped by Y               *" +
                    "\n   *  3. Flipped by the other Point *" +
                    "\n   *  4. Quit                       *" +
                    "\n   **********************************" +
                    "\n   Select an option " +
                    "(use integer value only): ");
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print("\n   Flipped by X -");
                    p[0].flipByX();
                    p[1].flipByX();
                    
                    p[0].display();
                    p[1].display();
                    
                    break;
                case 2:
                    System.out.print("\n   Flipped by Y -");
                    p[0].flipByY();
                    p[1].flipByY();
                    
                    p[0].display();
                    p[1].display();
                    
                    break;
                case 3:
                    System.out.print(
                            "\n   Flipped by the other Point -");
                    p[0].flipByP(p[1]);
                    p[1].flipByP(p[0]);
                    
                    p[0].display();
                    p[1].display();
                    
                    break;
                case 4:
                    System.out.print("\n   Return to MENU - HW#5");
                    
                    break;
                default:
                    System.out.print("\n   Too Funny!");
            }
        } while (option != 4);
        
        return p;
    }
    
    public static PointFikerW moveByPoint(PointFikerW p) 
    {
        int n1;
        int d1;
        int n2;
        int d2;
        
        FractionFikerW fr1 = null;
        FractionFikerW fr2 = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\n      Enter x num: ");
        n1 = scanner.nextInt();
        System.out.print("\n      Enter x denom:  ");
        d1 = scanner.nextInt();
        
        fr1 = new FractionFikerW(n1, d1);
        
        System.out.print("\n      Enter y num: ");
        n2 = scanner.nextInt();
        System.out.print("\n      Enter y denom:  ");
        d2 = scanner.nextInt(); 
        
        fr2 = new FractionFikerW(n2, d2);
        
        p.move(fr1, fr2);
        p.display();
        
        return p;
    }
}