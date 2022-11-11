import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class alien extends Actor
{
    /**
     * Act - do whatever the alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(),getY()+5);
        if(isAtEdge())
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()),0);
        if(isTouching(bullet.class))
        {
            removeTouching(bullet.class);
            getWorld().addObject(new Blast(), getX(), getY());
            Greenfoot.playSound("blast.wav");
            MyWorld.score.add(10);
            getWorld().addObject(new alien(), Greenfoot.getRandomNumber(getWorld().getWidth()),0);
            getWorld().removeObject(this);
        }
        else if(isTouching(Hero.class))
        {
            MyWorld.hp.add(-1);
            getWorld().addObject(new alien(), Greenfoot.getRandomNumber(getWorld().getWidth()),0);
            if(MyWorld.hp.getValue()==0)
            {
                getWorld().addObject(new GameOver(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                MyWorld.bg.stop();
                MyWorld.bg = new GreenfootSound("bg3.wav");
                MyWorld.bg.playLoop();
                removeTouching(Hero.class);
            }
            
            getWorld().removeObject(this);
        }
    }
}
