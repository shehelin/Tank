package com.mashibing.tank.Frame;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.model.Bullet;
import com.mashibing.tank.model.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author hl.she
 * @Date 2020/5/16 19:59
 */
public class TankFrame extends Frame {

   Tank myTank = new Tank(25,25,Dir.DOWN);
   Bullet b = new Bullet(50,50,Dir.DOWN);

    public TankFrame() {

        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());



    }

    @Override
    public void paint(Graphics g){
        myTank.paint(g);
        b.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
//            System.out.println("keyTyped");
        }

        Boolean bL = false;
        Boolean bR = false;
        Boolean bU = false;
        Boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }
           else{
                myTank.setMoving(true);
                if (bL) { myTank.setDir(Dir.LEFT);}
                if (bR) { myTank.setDir(Dir.RIGHT);}
                if (bU) { myTank.setDir(Dir.UP);}
                if (bD) { myTank.setDir(Dir.DOWN);}
            }

        }

    }

}
