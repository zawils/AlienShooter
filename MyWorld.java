import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static Counter score = new Counter("Score:   ");
    public static Counter hp = new Counter("hp:    "); 
    public static GreenfootSound bg = new GreenfootSound("bg0.wav");
    public MyWorld()
    {    
        // Create a new world with 400x600 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        bg.playLoop();
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        for(int i = 1;i <= 7; i++)
            addObject(new alien(),Greenfoot.getRandomNumber(getWidth()),0);

        for(int i = 1;i <= 5; i++)
            addObject(new Alien2(),Greenfoot.getRandomNumber(getWidth()),0);
        
        Hero hero = new Hero();
        addObject(hero,207,578);
    
        addObject(score,56,26);
        score.setValue(0);
        
        addObject(hp,350,31);
        hp.setValue(5);
    }
}
