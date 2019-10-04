package card.games;

import java.io.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class titleScene {
    
    static Color titleScreen= new Color (54,163,226);
    static Image cardFan;
    static Image unoCards;
    static boolean howTo=false;
    static boolean play=false;
    static boolean startScreen=true;
    
    
    public static int interact(int xpos,int ypos)
    {
        
        if (xpos<Window.getX((Window.getWidth2()/2)-Window.getWidth2()/10)+Window.getWidth2()/5&&xpos>Window.getX((Window.getWidth2()/2)-Window.getWidth2()/10)
            &&ypos<Window.getYNormal((Window.getHeight2()*2/5)+Window.getHeight2()/15)+ Window.getHeight2()/10&&ypos>Window.getYNormal((Window.getHeight2()*2/5)+Window.getHeight2()/15))
        {
            play=true;
            startScreen=false;
        }
        if (xpos<Window.getX((Window.getWidth2()/2)-Window.getWidth2()/10)+Window.getWidth2()/5&&xpos>Window.getX((Window.getWidth2()/2)-Window.getWidth2()/10)
            &&ypos<Window.getYNormal((Window.getHeight2()*1/5)+Window.getHeight2()/15)+ Window.getHeight2()/10&&ypos>Window.getYNormal((Window.getHeight2()*1/5)+Window.getHeight2()/15))
        {
            howTo=true;
            startScreen=false;
        }
        return 0;
    }
    public static void Draw(Graphics2D g)
    {
        
        g.setColor(titleScreen);
        g.fillRect(Window.getX(0), Window.getY(0), Window.getWidth2(), Window.getHeight2());
        
        drawBox(g,50,"Play",(Window.getWidth2()/2),(Window.getHeight2()*2/5),50,Window.getWidth2()/5, Window.getHeight2()/10);
        drawBox(g,45,"How to Play",(Window.getWidth2()/2),(Window.getHeight2()*1/5),125,Window.getWidth2()/5, Window.getHeight2()/10);
        
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));
        g.drawString("Created By: Matthew Busby and Matthew Kilpatrick",Window.getX(5),Window.getY(20));
        
        g.setColor(Color.white);
        g.setFont(new Font("Monospaced",Font.BOLD,200));
        g.drawString("Card Games",Window.getX(360),Window.getY(300));
        if (titleScene.howTo)
        {
            drawHowToPlay(g);
        }
        if (titleScene.play)
        {
            drawPlay(g);
        }


    }
    public static void drawBox(Graphics2D g,int fontSize, String word, int xpos, int ypos, int space, int xscale, int yscale){
        
        g.setColor(Color.white);
        g.fillRect(Window.getX(xpos-Window.getWidth2()/10),Window.getYNormal(ypos+Window.getHeight2()/15),xscale ,yscale);
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,fontSize));
        g.drawString(word,Window.getX(xpos-space),Window.getYNormal(ypos));
    }
    public static void drawHowToPlay(Graphics2D g)
    {
        g.setColor(titleScreen);
        g.fillRect(Window.getX(0), Window.getY(0), Window.getWidth2(), Window.getHeight2());
        g.setColor(Color.white);
        g.setFont(new Font("Monospaced",Font.BOLD,200));
        g.drawString("How To Play",Window.getX(310),Window.getY(300));
        g.setColor(Color.black);
        g.fillRect(Window.getX(Window.getWidth2()/5-10), Window.getY(Window.getHeight2()*2/5-10), Window.getWidth2()*3/5+20, Window.getHeight2()/2+20);
        g.setColor(Color.white);
        g.fillRect(Window.getX(Window.getWidth2()/5), Window.getY(Window.getHeight2()*2/5), Window.getWidth2()*3/5, Window.getHeight2()/2);
        
    }
    public static void drawPlay(Graphics2D g)
    {
        g.setColor(titleScreen);
        g.fillRect(Window.getX(0), Window.getY(0), Window.getWidth2(), Window.getHeight2());
        g.setColor(Color.white);
        g.setFont(new Font("Monospaced",Font.BOLD,100));
        g.drawString("What do you want to play?",Window.getX(190),Window.getY(175));  
        drawBox(g, 45,"Triple Three",Window.getWidth2()/4,(Window.getHeight2()/2),130,Window.getWidth2()/5, Window.getHeight2()/10);
        drawBox(g, 45,"Uno",Window.getWidth2()/4,(Window.getHeight2()*3/10),43,Window.getWidth2()/5, Window.getHeight2()/10);
        
    }
       
    
    
}
