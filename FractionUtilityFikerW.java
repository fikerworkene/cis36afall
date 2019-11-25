/**
 * Program Name: FractionUtilityFikerW.java
 * Discussion:   Stand-Alone Functions
 * Written By:   fiker workene
 * Date:         2019/10/24
 */

import java.util.*;

public class FractionUtilityFikerW 
{
    public static void runMenuHw4()
    {
        int option;
        FractionFikerW[] obj = new FractionFikerW[3];
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n\n*****************************" +
                    "\n*    MENU - Hw #4           *" +
                    "\n*  1. Initializing          *" +
                    "\n*  2. Arithmetic Operations *" +
                    "\n*  3. Uncommon Digit Search *" +
                    "\n*  4. Printing              *" +
                    "\n*  5. Quit                  *" +
                    "\n*****************************" +
                    "\nSelect an option (use integer value only): ");
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print("\nInitializing SubMENU -");
                    obj = init(obj);
                    
                    break;
                case 2:
                    System.out.print("\nArithmetic Operatioins -");
                    
                    if (obj[0] != null || obj[1] != null)
                        obj = arithOperation(obj);
                    else
                        System.out.print(
                                "\n\n    Not a proper call as" +
                                " no Fraction's are available!");
                    
                    break;
                case 3:
                    System.out.print("\nUncommon Digit Search -");
                    UnCommonDSearch(obj);
                    
                    break;
                case 4:
                    if (obj[0] != null || obj[1] != null)
                    {
                        System.out.print("\nPrinting SubMENU -");
                        printMenu(obj);
                    } else
                    {
                        System.out.print(
                                "\n\n    Not a proper call as" +
                                " no Fraction's are available!");
                    }
                    
                    break;
                case 5:
                    System.out.print("\nHave Fun ...!");
                    
                    break;
                default:
                    System.out.print("\nToo Funny!");
            }
        } while (option != 5);
    }
    
    public static FractionFikerW[] init(FractionFikerW[] ary) {
        int ln;
        int rn;
        int ld;
        int rd;
        Scanner scanner = new Scanner(System.in);
        
        if (ary[0] == null || ary[1] == null)
        {
            System.out.print("\nLeft Num: ");
            ln = scanner.nextInt();
            
            do
            {
                System.out.print("\nLeft Denom: ");
                ld = scanner.nextInt();
            } while (ld == 0);
            
            ary[0] = new FractionFikerW(ln, ld);
            
            System.out.print("\nRight Num: ");
            rn = scanner.nextInt();
            do
            {
                System.out.print("Right Denom: ");
                rd = scanner.nextInt();
            } while (rd == 0);
            
            ary[1] = new FractionFikerW(rn, rd);
        }
        else
        {
            System.out.print("\nLeft Num: ");
            ln = scanner.nextInt();
            
            do
            {
                System.out.print("\nLeft Denom: ");
                ld = scanner.nextInt();
            } while (ld == 0);
            
            ary[0].update(ln, ld);
            
            System.out.print("\nRight Num: ");
            rn = scanner.nextInt();
            do
            {
                System.out.print("Right Denom: ");
            rd = scanner.nextInt();
            } while (rd == 0);
            
            ary[1].update(rn, rd);
        }
        
        if (ary[2] == null)
        {
            ary[2] = new FractionFikerW();
        }
        
        return ary;
    }
    
    public static void printMenu(FractionFikerW[] ary) {
        int options;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n  ********************************" +
                    "\n    *         PRINTING MENU        *" +
                    "\n    *  (leftOp, rightOp, result)   *" +
                    "\n    *  1. print() - Member         *" +
                    "\n    *  2. print() - Stand Alone    *" +
                    "\n    *  3. Return to Previous MENU  *" +
                    "\n    ********************************" +
                    "\n    Select an option (1, 2, or 3): ");
            options = scanner.nextInt();
            
            switch (options)
            {
                case 1:
                    System.out.print(
                            "\n    Printing Member Objects -" +
                            "\n\n    Left Fraction: ");
                    ary[0].print();
                    
                    System.out.print("\n    Right Fraction: ");
                    ary[1].print();
                    
                    System.out.print("\n    Result Fraction: ");
                    ary[2].print();
                    
                    break;
                case 2:
                    System.out.print(
                            "\n    Printing Stand-Alone Objects -");
                    print(ary);
                    break;
                case 3:
                    System.out.print("\n    Return to Main MENU!");
                    
                    break;
                default:
                    System.out.print("\n    WRONG OPTION!...");
            }
        } while (options != 3);
    }
    
    public static FractionFikerW[] arithOperation(FractionFikerW[] ary) {
    
        int option;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n    *******************************" +
                    "\n    *     Arithmetic SubMENU      *" +
                    "\n    *  1. Addition                *" +
                    "\n    *  2. Subtraction             *" +
                    "\n    *  3. Multiplication          *" +
                    "\n    *  4. Division                *" +
                    "\n    *  5. Return to Previous MENU *" +
                    "\n    *******************************" +
                    "\n    Select an option: ");
            option = scanner.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.print(
                            "\n    Addition Options --");
                     ary = addMenu(ary);
                    
                    break;
                case 2:
                    System.out.print(
                            "\n    Subtraction Options --");
                    ary = subMenu(ary);
                    
                    break;
                case 3:
                    System.out.print(
                            "\n    Multiplication Options --");
                    ary = mulMenu(ary);
                    
                    break;
                case 4:
                    System.out.print(
                            "\n    Division Options --");
                    ary = divMenu(ary);
                    
                    break;
                case 5:
                    System.out.print("\n    Return to Previous MENU!");
                    
                    break;
                default:
                    System.out.print("\n    WRONG OPTION!...");
            }
        } while (option != 5);
        
        return ary;
    }
    
    public static void UnCommonDSearch(FractionFikerW[] ary) {
        int options;
        int[] result1 = null;
        int[] result2 = null;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n    ***********************************" +
                    "\n    *  Uncommon Digit Search SubMENU  *" +
                    "\n    *  1. Using Left Fraction         *" +
                    "\n    *  2. Using Right Fraction        *" +
                    "\n    *  3. Return to Main MENU         *" +
                    "\n    ***********************************" +
                    "\n    Select an option: ");
            options = scanner.nextInt();
            
            switch (options)
            {
                case 1:
                    System.out.print("\n    Using Left Fraction --");
                    result1 = ary[0].getUncommonDigit();
                    
                    for (int tmp : result1)
                        System.out.print("    " + tmp);
                    
                    break;
                case 2:
                    System.out.print("\n    Using Right Fraction --");
                    result2 = ary[1].getUncommonDigit();
                    
                    for (int tmp : result2)
                        System.out.print("    " + tmp);
                    
                    break;
                case 3:
                    System.out.print("\n    Return to Main MENU!");
                    
                    break;
                default:
                    System.out.print("\n    WRONG OPTION!...");
            }
        } while (options != 3);
    }
    
    public static FractionFikerW[] addMenu(FractionFikerW[] fr) {
        int options;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n      ********************************" +
                    "\n      *       Addition SubMENU       *" +
                    "\n      *  1. add() - Member           *" +
                    "\n      *  2. add() - Stand Alone      *" +
                    "\n      *  3. Return to Previous MENU  *" +
                    "\n      ********************************" +
                    "\n      Select an option (1, 2, or 3): ");
            options = scanner.nextInt();
            
            switch (options)
            {
                case 1:
                    System.out.println(
                            "\n      Calling member add() ---");
                    fr[2] = fr[0].add(fr[1]);
                    fr[1].print();
                    
                    break;
                case 2:
                    System.out.println(
                            "\n      Calling stand-alone add() ---");
                    fr[2] = add(fr[0], fr[1]);
                    print(fr);
                    
                    break;
                case 3:
                    System.out.print(
                            "\n      Return to Previous MENU!");
                    
                    break;
                default:
                    System.out.print("\n      WRONG OPTION!...");
            }
        } while (options != 3);
        
        return fr;
    }
    
    public static FractionFikerW[] subMenu(FractionFikerW[] fr) {
        int options;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n      ********************************" +
                    "\n      *     Subtraction SubMENU      *" +
                    "\n      *  1. sub() - Member           *" +
                    "\n      *  2. sub() - Stand Alone      *" +
                    "\n      *  3. Return to Previous MENU  *" +
                    "\n      ********************************" +
                    "\n      Select an option: ");
            options = scanner.nextInt();
            
            switch (options)
            {
                case 1:
                    System.out.println(
                            "\n      Calling member sub() ---");
                    fr[2] = fr[0].sub(fr[1]);
                    fr[1].print();
                    
                    break;
                case 2:
                    System.out.println(
                            "\n      Calling stand-alone sub() ---");
                    fr[2] = sub(fr[0], fr[1]);
                    print(fr);
                    
                    break;
                case 3:
                    System.out.print("\n       Return to Previous MENU!");
                    
                    break;
                default:
                    System.out.print("\n       WRONG OPTION!...");
            }
        } while (options != 3);
        
        return fr;
    }
    
    public static FractionFikerW[] mulMenu(FractionFikerW[] fr) {
        int options;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n      ********************************" +
                    "\n      *    Multiplication SubMENU    *" +
                    "\n      *  1. mul() - Member           *" +
                    "\n      *  2. mul() - Stand Alone      *" +
                    "\n      *  3. Return to Previous MENU  *" +
                    "\n      ********************************" +
                    "\n      Select an option: ");
            options = scanner.nextInt();
            
            switch (options)
            {
                case 1:
                    System.out.println(
                            "\n      Calling member mul() ---");
                    fr[2] = fr[0].mul(fr[1]);
                    fr[1].print();
                    
                    break;
                case 2:
                    System.out.println(
                            "\n      Calling stand-alone mul() ---");
                    fr[2] = mul(fr[0], fr[1]);
                    print(fr);
                    
                    break;
                case 3:
                    System.out.print("\n      Return to Previous MENU!");
                    
                    break;
                default:
                    System.out.print("\n      WRONG OPTION!...");
            }
        } while (options != 3);
        
        return fr;
    }
    
    public static FractionFikerW[] divMenu(FractionFikerW[] fr) {
        int options;
        
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print(
                    "\n\n      ********************************" +
                    "\n      *       Division SubMENU       *" +
                    "\n      *  1. div() - Member           *" +
                    "\n      *  2. div() - Stand Alone      *" +
                    "\n      *  3. Return to Previous MENU  *" +
                    "\n      ********************************" +
                    "\n      Select an option: ");
            options = scanner.nextInt();
            
            switch (options)
            {
                case 1:
                    System.out.println(
                            "\n      Calling member div() ---");
                    fr[2] = fr[0].div(fr[1]);
                    fr[1].print();
                    break;
                case 2:
                    System.out.println(
                            "\n      Calling stand-alone div() ---");
                    fr[2] = div(fr[0], fr[1]);
                    print(fr);
                    break;
                case 3:
                    System.out.print(
                            "\n      Return to Previous MENU!");
                    break;
                default:
                    System.out.print("\n      WRONG OPTION!...");
            }
        } while (options != 3);
        
        return fr;
    }
    
    public static FractionFikerW add(FractionFikerW lfr, FractionFikerW rfr) {
        int rNum = lfr.getNum() * rfr.getDenom() + 
                lfr.getDenom() * rfr.getNum();
        int rDenom = lfr.getDenom() * rfr.getDenom();
        return new FractionFikerW(rNum, rDenom);
    }
    
    public static FractionFikerW sub(FractionFikerW lfr, FractionFikerW rfr) {
        int rNum = lfr.getNum() * rfr.getDenom() - 
                lfr.getDenom() * rfr.getNum();
        int rDenom = lfr.getDenom() * rfr.getDenom();
        return new FractionFikerW(rNum, rDenom);
    }
    
    public static FractionFikerW mul(FractionFikerW lfr, FractionFikerW rfr) {
        int rNum = lfr.getNum() * rfr.getNum();
        int rDenom = lfr.getDenom() * rfr.getDenom();
        return new FractionFikerW(rNum, rDenom);
    }
    
    public static FractionFikerW div(FractionFikerW lfr, FractionFikerW rfr) {
        int rNum = lfr.getNum() * rfr.getDenom();
        int rDenom = lfr.getDenom() * rfr.getNum();
        return new FractionFikerW(rNum, rDenom);
    }
    
    public static void print(FractionFikerW[] fr) {
        System.out.print("\n      Left Fraction: \n      Num:" +
                fr[0].getNum() + "    Denom: " + fr[0].getDenom() +
                "\n      Right Fraction: \n      Num:" + 
                fr[1].getNum() + "    Denom: " + fr[1].getDenom() +
                "\n      Result:    Num:" + fr[2].getNum() + 
                "    Denom:" + fr[2].getDenom());
    }
}
