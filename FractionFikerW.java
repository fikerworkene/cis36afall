/*
 * Program Name: FractionFikerW.java
 * Discussion:   FractionFikerW class
 * Written By:   Fiker Workene
 * Date:         2019/11/14
 */

public class FractionFikerW 
{
    private int num;
    private int denom;
    
    public FractionFikerW()
    {
        num = 0;
        denom = 1;
    }
    
    public FractionFikerW(FractionFikerW fr) {
        num = 0;
        denom = 1;
    }
    
    public FractionFikerW(int n) {
        num = n < 0 ? -n : n;
        denom = 1;
    }
    
    public FractionFikerW(int n, int d) {
        if ((n < 0 && d < 0) || (d < 0)) {
            n = -n;
            d = -d;
        }
        if (n == 0)
            denom = 1;            
        else
            denom = d /gcdBF(n,d) ; 
        num = n / gcdBF(n, d);
    }
    
    public void update(int delta) {
        num = num + (denom * delta);
    }
    
    public void update() {
        num = -num;
    }
    
    public void update(FractionFikerW fr) {
        int temp1 = (num * fr.denom) + (denom * fr.num);
        int temp2 = denom * fr.denom;
        num = temp1 / gcdBF(temp1, temp2); 
        denom = temp2 / gcdBF(temp1, temp2);
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
        int gcf = gcdBF(n, denom);
        
        num = n / gcf < 0 ? -n / gcf : n / gcf;
        denom /= gcf;
    }
    
    public void setDenom(int d) 
    {
    	int gcd = gcdBF(num, d);
        
        denom = d / gcd < 0 ? -d / gcd : d / gcd;
        num /= gcd;
    }
    
    public double toDouble()
    {
        return num / denom;
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
            if(n % i == 0 && d % i == 0)
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
        } while(tmp != 10);
        
        tmp = (denom < 0) ? -denom : denom;
        do
        {
            deAryForDenom[tmp % 10] = 1;
            
            tmp /= 10;
        } while(tmp != 10);
        
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
        return new FractionFikerW(resultNum, resultDenom);
    }
    
    public FractionFikerW sub(FractionFikerW fr)
    {
        int resultNum = (this.num) * fr.denom - 
                (fr.num) * denom;
        int resultDenom = this.denom * fr.denom;
        return new FractionFikerW(resultNum, resultDenom);
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
