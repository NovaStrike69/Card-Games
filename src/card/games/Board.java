package card.games;

import java.awt.*;

public class Board {
    
    static Color boarderBrown= new Color (81,54,31);
    static Color tableGreen= new Color (69,207,74);
    
    
    public static void Draw(Graphics2D g){
        
        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
        int ysize=80;
        
        g.setColor(Color.white);
        g.drawPolyline(x, y, 5);
        
        g.setColor(boarderBrown);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        g.setColor(tableGreen);
        g.fillPolygon(x, y, 4); 

        g.setColor(Color.black);
        drawPilePlace(g,Window.getX(Window.getWidth2()/2),Window.getY(Window.getHeight2()/2),0,77,104);

        g.setColor(Color.black);
        drawPlate(g,Window.getX(Window.getWidth2()/2),Window.getYNormal(Window.YBORDER+Window.YTITLE+30),180,Window.getWidth2()/6,ysize);
        drawPlate(g,Window.getX(ysize),Window.getYNormal(Window.getHeight2()/2),270,Window.getWidth2()/8-10,ysize);
        drawPlate(g,Window.getX(Window.getWidth2()/2),Window.getY(Window.YBORDER+Window.YTITLE+30),0,Window.getWidth2()/6,ysize);
        drawPlate(g,Window.getX(Window.getWidth2()-ysize),Window.getYNormal(Window.getHeight2()/2),90,Window.getWidth2()/8-10,ysize);

        drawOutline(g,Window.getX(Window.getWidth2()*73/200),Window.getYNormal(Window.getHeight2()*7/20),0,125,150);
        drawOutline(g,Window.getX(Window.getWidth2()*93/200),Window.getYNormal(Window.getHeight2()*7/20),0,125,150);
        drawOutline(g,Window.getX(Window.getWidth2()*113/200),Window.getYNormal(Window.getHeight2()*7/20),0,125,150);
        //
        drawOutline(g,Window.getX(Window.getWidth2()*73/200),Window.getYNormal(Window.getHeight2()*16/20),0,125,150);
        drawOutline(g,Window.getX(Window.getWidth2()*93/200),Window.getYNormal(Window.getHeight2()*16/20),0,125,150);
        drawOutline(g,Window.getX(Window.getWidth2()*113/200),Window.getYNormal(Window.getHeight2()*16/20),0,125,150);
        //
        
        
        
    }
    public static void Reset(){

    }
    
    private static void drawPlate(Graphics2D g,int xpos,int ypos, double rot, double xscale, double yscale){
        
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale,yscale );
        
        int xvals[]={-2,-1,1,2};
        int yvals[]={-1,1,1,-1};
        g.fillPolygon(xvals,yvals,xvals.length);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos); 
    }
    private static void drawPilePlace(Graphics2D g,int xpos,int ypos, double rot, double xscale, double yscale){
        
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        int xvals[]={-1,-1,1,1};
        int yvals[]={-1,1,1,-1};
        g.fillPolygon(xvals,yvals,xvals.length);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos); 
    }
    private static void drawOutline(Graphics2D g,int xpos,int ypos, double rot, int xscale, int yscale){

        g.setColor(Color.white);
        g.fillRect(xpos, ypos, xscale, yscale);
        g.setColor(tableGreen);
        g.fillRect(xpos+5, ypos+5, xscale-10, yscale-10);
 
    }
    
}