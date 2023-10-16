package com.marginallyclever.makelangelo.makeart.turtlegenerator.truchet;

import com.marginallyclever.convenience.helpers.MathHelper;
import com.marginallyclever.makelangelo.turtle.Turtle;

import javax.vecmath.Vector2d;

public class TruchetCurved implements TruchetTileGenerator {
    private final Turtle turtle;
    private final double spaceBetweenLines;
    private final double tileSize;

    public TruchetCurved(Turtle turtle,double spaceBetweenLines,double linesPerTileCount) {
        super();
        this.turtle=turtle;
        this.spaceBetweenLines = spaceBetweenLines;
        tileSize = spaceBetweenLines * linesPerTileCount;
    }

    @Override
    public void drawTile(double x,double y) {
        double r = Math.random();

             if(r<0.25) tileA1(x,y);
        else if(r<0.50) tileB1(x,y);
        else if(r<0.75) tileA2(x,y);
        else            tileB2(x,y);
    }

    /**
     * Style=/
     * @param x0 top-left corner
     * @param y0 top-left corner
     */
    public void tileA1(double x0,double y0) {
        double x1=x0+tileSize;
        double y1=y0+tileSize;
        double d=Math.sqrt(tileSize*tileSize+tileSize*tileSize);

        for(double r1=spaceBetweenLines;r1<=tileSize;r1 += spaceBetweenLines) {
            interTile(x1,y1,r1,Math.PI*1.5,Math.PI*1.0);

            double v;
            try {
                Vector2d p = MathHelper.intersectionOfCircles(r1,tileSize,d);
                v = Math.abs(Math.atan(p.y/p.x)) - Math.PI * 0.25;
                interTile(x0, y0, r1, Math.PI * 0.0, -v);
                interTile(x0, y0, r1, Math.PI * 0.5, Math.PI * 0.5+v);
            } catch(IllegalArgumentException e) {
                interTile(x0,y0,r1,Math.PI*0.0,Math.PI*0.5);
            }
        }
    }

    /**
     * Style=/
     * @param x0 top-left corner
     * @param y0 top-left corner
     */
    public void tileA2(double x0,double y0) {
        double x1=x0+tileSize;
        double y1=y0+tileSize;
        double d=Math.sqrt(tileSize*tileSize+tileSize*tileSize);

        for(double r1=spaceBetweenLines;r1<=tileSize;r1 += spaceBetweenLines) {
            interTile(x0,y0,r1,Math.PI*0.0,Math.PI*0.5);

            double v;
            try {
                Vector2d p = MathHelper.intersectionOfCircles(r1,tileSize,d);
                v = Math.abs(Math.atan(p.y/p.x)) - Math.PI * 0.25;
                interTile(x1,y1, r1, Math.PI * 1.0, Math.PI * 1.0-v);
                interTile(x1,y1, r1, Math.PI * 1.5, Math.PI * 1.5+v);
            } catch(IllegalArgumentException e) {
                interTile(x1,y1,r1,Math.PI*1.5,Math.PI*1.0);
            }
        }
    }

    /**
     * Style=\
     * @param x0 top-left corner
     * @param y0 top-left corner
     */
    public void tileB1(double x0,double y0) {
        double x1=x0+tileSize;
        double y1=y0+tileSize;
        double d=Math.sqrt(tileSize*tileSize+tileSize*tileSize);

        for(double r1=spaceBetweenLines;r1<=tileSize;r1 += spaceBetweenLines) {
            interTile(x0,y1,r1,Math.PI*2.0,Math.PI*1.5);

            double v;
            try {
                Vector2d p = MathHelper.intersectionOfCircles(r1,tileSize,d);
                v = Math.abs(Math.atan(p.y/p.x)) - Math.PI * 0.25;
                interTile(x1, y0, r1, Math.PI * 0.5, Math.PI * 0.5-v);
                interTile(x1, y0, r1, Math.PI * 1.0, Math.PI * 1.0+v);
            } catch(IllegalArgumentException e) {
                interTile(x1,y0,r1,Math.PI*1.0,Math.PI*0.5);
            }
        }
    }

    /**
     * Style=\
     * @param x0 top-left corner
     * @param y0 top-left corner
     */
    public void tileB2(double x0,double y0) {
        double x1=x0+tileSize;
        double y1=y0+tileSize;
        double d=Math.sqrt(tileSize*tileSize+tileSize*tileSize);

        for(double r1=spaceBetweenLines;r1<=tileSize;r1 += spaceBetweenLines) {
            interTile(x1,y0,r1,Math.PI*1.0,Math.PI*0.5);

            double v;
            try {
                Vector2d p = MathHelper.intersectionOfCircles(r1,tileSize,d);
                v = Math.abs(Math.atan(p.y/p.x)) - Math.PI * 0.25;
                interTile(x0, y1, r1, Math.PI * 1.5, Math.PI * 1.5-v);
                interTile(x0, y1, r1, Math.PI * 2.0, Math.PI * 2.0+v);
            } catch(IllegalArgumentException e) {
                interTile(x0,y1,r1,Math.PI*2.0,Math.PI*1.5);
            }
        }
    }

    // Interpolate from (x0,y0) to (x1,y1) in steps of length iterSize.
    private void interTile(double cx,double cy,double radius,double a0, double a1) {
        turtle.drawArc(cx,cy,radius,a0,a1,10);
    }
}
