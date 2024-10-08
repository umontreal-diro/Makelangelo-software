package com.marginallyclever.convenience.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point2d;

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
 @Test
    public void testLerpDouble() {
        //Nous testons la classe MathHelper car elle contient des fonctions utilitaires mathématiques
        // essentielles utilisées dans diverses parties de l'application. Assurer la précision et la fiabilité
        // de ces méthodes est crucial pour la validité des calculs géométriques et autres opérations mathématiques
        // effectuées par le programme. En validant ces fonctions, nous évitons la propagation d'erreurs qui
        // pourraient entraîner des dysfonctionnements importants dans d'autres modules du système.
        // Test case 1: Vérifie que l'interpolation linéaire à t=0.0 retourne a
        // Arrange
        double t = 0.0;
        double a = 0.0;
        double b = 10.0;
        double expected = a;

        // Act
        double result = MathHelper.lerp(t, a, b);

        // Assert
        Assertions.assertEquals(expected, result, 1e-9);

        // Test case 2: Vérifie que l'interpolation linéaire à t=0.5 retourne 5.0
        // Arrange
        t = 0.5;
        expected = 5.0;

        // Act
        result = MathHelper.lerp(t, a, b);

        // Assert
        Assertions.assertEquals(expected, result, 1e-9);

        // Test case 3: Vérifie que l'interpolation linéaire à t=1.0 retourne b
        // Arrange
        t = 1.0;
        expected = b;

        // Act
        result = MathHelper.lerp(t, a, b);

        // Assert
        Assertions.assertEquals(expected, result, 1e-9);
    }

}
