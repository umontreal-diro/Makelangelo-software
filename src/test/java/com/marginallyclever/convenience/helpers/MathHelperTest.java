package com.marginallyclever.convenience.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point2d;
import javax.vecmath.Tuple2d;
import javax.vecmath.Vector2d;

public class MathHelperTest {
    @Test
    public void testBetween() {
        Point2d a = new Point2d();
        Point2d b = new Point2d();
        Point2d c;
        double epsilon = 1e-9;

        for (int i = 0; i < 50; ++i) {
            a.set(Math.random() * 500 - 250, Math.random() * 500 - 250);
            b.set(Math.random() * 500 - 250, Math.random() * 500 - 250);
            c = MathHelper.lerp(a, b, Math.random());
            assert (MathHelper.between(a, b, c, epsilon));
        }
    }

    @Test
    public void testNotBetween() {
        Point2d a = new Point2d();
        Point2d b = new Point2d();
        Point2d c;
        double epsilon = 1e-9;

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,1.0+epsilon+Math.random());
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,-epsilon-Math.random());
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }
    }

    @Test
    public void testOffLine() {
        Point2d a = new Point2d();
        Point2d b = new Point2d();
        Point2d ortho = new Point2d();
        Point2d c;
        double epsilon = 1e-9;

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,Math.random());
            ortho.set(b);
            ortho.sub(a);
            c.x+=ortho.y;
            c.y+=ortho.x;
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,1.0+epsilon+Math.random());
            ortho.set(b);
            ortho.sub(a);
            c.x+=ortho.y;
            c.y+=ortho.x;
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,-epsilon-Math.random());
            ortho.set(b);
            ortho.sub(a);
            c.x+=ortho.y;
            c.y+=ortho.x;
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }
    }

    // NEW TEST
    @Test
    void testEquals() {
        Tuple2d a0 = new Vector2d(0.0,0.0);
        Tuple2d a1 = new Vector2d(1.0,0.0);
        Tuple2d b0 = new Vector2d(0.0,0.0);
        Tuple2d b1 = new Vector2d(1.0,0.0);
        Assertions.assertTrue(MathHelper.equals(a0, a1, b0, b1, 0.01));
        Assertions.assertFalse(MathHelper.equals(a0, a1, b0, b1, 0.0));

        Tuple2d c0 = new Vector2d(0.0,0.09);
        Tuple2d c1 = new Vector2d(1.0,0.09);
        Assertions.assertFalse(MathHelper.equals(c0, c1, a0, a1, 0.08));
        Assertions.assertTrue(MathHelper.equals(c0, c1, a0, a1, 0.1));
        Assertions.assertFalse(MathHelper.equals(c0, c1, a0, a1, 0.09));

        Tuple2d d0 = new Vector2d(0.0,0.0);
        Tuple2d d1 = new Vector2d(0.0,0.0);
        Tuple2d e0 = new Vector2d(0.0,0.0);
        Tuple2d e1 = new Vector2d(0.0,0.0);
        Assertions.assertTrue(MathHelper.equals(d0, d1, e0, e1 ,0.1));
        Assertions.assertFalse(MathHelper.equals(d0, d1, e0, e1 ,0.0));

        // TODO: possible bug?
        //Tuple2d f0 = new Vector2d(0.0,0.0);
        //Tuple2d f1 = new Vector2d(2.0,0.0);
        //Assertions.assertFalse(MathHelper.equals(f0, f1, a0, a1 ,0.1));
        //Assertions.assertTrue(MathHelper.equals(f0, f1, a0, a1 ,1.1));
    }
}
