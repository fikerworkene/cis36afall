/*
 * Program Name: FractionFikerW.java
 * Discussion:    Functions
 * Written By:   Fiker Workene
 * Date:         2019/10/24
 */

import java.util.*;

public class FractionFikerW 
{
    private int num;
    private int denom;
    
    public FractionFikerW()
    {
        num = 0;
        denom = 1;
    }
    
    public FractionFikerW(int n) {
        num = n < 0 ? -n : n;
        denom = 1;
    }
    
    public FractionFikerW(int n, int d)
    {
        int gcd = gcdBF(n, d);
        num = ((n / gcd) < 0 ? 
                -(n / gcd) : (n / gcd));
        if (n == 0)
            denom = 1;
        else
            denom = ((d / gcd) < 0 ? 
                    -(d / gcd) : (d / gcd));
    }
    
    public int getNum() 
    {
        return num;
    }
    
    public int getDenom() 
    {
        return denom;
    }
    
    public void setNum(int n) 
    {
    	int gcd = gcdBF(n, denom);
        
        num = n / gcd < 0 ? -n / gcd : n / gcd;
        denom /= gcd;
    }
    
    public void setDenom(int d) 
    {
    	int gcd = gcdBF(num, d);
        
        denom = d / gcd < 0 ? -d / gcd : d / gcd;
        num /= gcd;
    }
    
    public void update(int n, int d)
    {
        if ((n < 0 && d < 0) || (d < 0)) {
            n = -n;
            d = -d;
        }
        if (n == 0)
            denom = 1;            
        else
            denom = d / gcdBF(n,d) ; 
        num = n / gcdBF(n, d); 
    }
    
    public void print()
    {
        System.out.println("\n  {num: " +
                num + ", denom: " + denom + "}");
    }
    
    public static int gcdBF(int n, int d)
    {
        int gcd = 1;
        
        if (n < 0)
            n = -n;
        
        if (d < 0)
            d = -d;
        
        for (int i = 1; i <= n && i <= d; i++)
            if (n % i == 0 && d % i == 0)
                gcd = i;
        
        return gcd;
    }
    
    public int[] getUncommonDigit()
    {
        int[] ary = null;
        int size;
        int[] deAryForNum = new int[10];
        int[] deAryForDenom = new int[10];
        int tmp;
        int allDigit;
        
        tmp = (num < 0) ? -num : num;
        do
        {
            deAryForNum[tmp % 10] = 1;
            
            tmp /= 10;
        } while(tmp != 0);
        
        tmp = (denom < 0) ? -denom : denom;
        do
        {
            deAryForDenom[tmp % 10] = 1;
            
            tmp /= 10;
        } while(tmp != 0);
        
        size = 0;
        for (int i = 0; i < 10; i++)
        {
            deAryForNum[i] += deAryForDenom[i];
            
            if (deAryForNum[i] == 1)
            {
                size++;
            }
        }
        
        ary = new int [size];
        allDigit = 0;
        for (int i = 0; i < 10; i++)
        {
            if (deAryForNum[i] == 1)
            {
                ary[allDigit] = i;
                allDigit++;
            }
        }
        return ary;
    }
    
       public FractionFikerW add(FractionFikerW fr)
    {
        int resultNum = (this.num) * fr.denom + 
                (fr.num) * denom;
        int resultDenom = this.denom * fr.denom;
        return new FractionFikerW (resultNum, resultDenom);
    }
    
      public FractionFikerW sub(FractionFikerW fr)
    {
        int resultNum = (this.num) * fr.denom - 
                (fr.num) * denom;
        int resultDenom = this.denom * fr.denom;
        return new FractionFikerW (resultNum, resultDenom);
    }
    
     public FractionFikerW mul(FractionFikerW fr)
    {
        int resultNum = this.num * fr.num;
        int resultDenom = this.denom * fr.denom;
        return new FractionFikerW(resultNum, resultDenom);
    }
     public FractionFikerW div(FractionFikerW fr)
    {
        int resultNum = this.num * fr.denom;
        int resultDenom = this.denom * fr.num;
        return new FractionFikerW(resultNum, resultDenom);
    }
}