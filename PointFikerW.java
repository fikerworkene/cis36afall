/*
 * Program Name: PointFikerW.java
 * Discussion:   Points and Operations
 * Written By:   Fiker Workene
 * Date:         2019/11/14
 */

import java.util.*;

public class PointFikerW
{
    private FractionFikerW fx;
    private FractionFikerW fy;
    
    public PointFikerW()
    {
        fx = new FractionFikerW();
        fy = new FractionFikerW();
    }
    
    public PointFikerW(int n1, int d1, int n2, int d2)
    {
        fx = new FractionFikerW(n1, d1);
        fy = new FractionFikerW(n2, d2);
    }
    
    public PointFikerW(PointFikerW p)
    {
        fx = new FractionFikerW(p.getX());
        fy = new FractionFikerW(p.getY());
    }

    PointFikerW(FractionFikerW add, FractionFikerW add0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    PointFikerW(FractionFikerW add, FractionFikerW add0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public FractionFikerW getX()
    {
        return new FractionFikerW(fx.getNum(), fx.getDenom());
    }
    
    public FractionFikerW getY()
    {
        return new FractionFikerW(fy.getNum(), fy.getDenom());
    }
    
    public int getQuadrant(PointFikerW origin)
    {
        if (fx.toDouble() > origin.getX().toDouble() && 
                fy.toDouble() > origin.getY().toDouble())
        {
            return 1;
        }
        else if (fx.toDouble() < origin.getX().toDouble() && 
                fy.toDouble() > origin.getY().toDouble())
        {
            return 2;
        }
        else if (fx.toDouble() < origin.getX().toDouble() && 
                fy.toDouble() < origin.getY().toDouble())
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
    
    public int getQuadrant()
    {
        if (fx.toDouble() > 0 && fy.toDouble() > 0)
        {
            return 1;
        }
        else if (fx.toDouble() < 0 && fy.toDouble() > 0)
        {
            return 2;
        }
        else if (fx.toDouble() < 0 && fy.toDouble() < 0)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
    
    public void move(int delta)
    {
        fx.update(delta);
        fy.update(delta);
    }
    
    public void move(FractionFikerW delta)
    {
        fx.update(delta);
        fy.update(delta);
    }
    
    public void move(FractionFikerW dX, FractionFikerW dY)
    {
        fx.update(dX);
        fy.update(dY);
        fx.update(dX);
        fy.update(dY);
    }
    
    public void moveByInt(int p) 
    {        
        move(p);
    }
    
    public void flipByX()
    {
        fy.update();
    }
    
    public void flipByY()
    {
        fx.update();
    }
    
    public void flipByP(PointFikerW p)
    {
        fx.update(fx.sub(p.getX()));
        fy.update(fy.sub(p.getY()));
    }
    
    
    public void display()
    {
        System.out.println("\n  x num: " + fx.getNum() +
                "\n  x denom:  " +fx.getDenom() + 
                "\n  y num: " + fy.getNum() + 
                "\n  y denom: " + fy.getDenom());
    }
}