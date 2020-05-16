package com.mashibing.tank;

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

    int x = 200,y = 100;

    public TankFrame(){

        setSize(800,600);
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
    public void paint(Graphics graphics){
//        System.out.println("paint");
        graphics.fillRect(x,y,50,50);
        x+=10;
        x-=10;
    }

    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
//            System.out.println("keyTyped");
        }

        Boolean bL = false;
        Boolean bR = false;
        Boolean bU = false;
        Boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:  bL = true;
                    break;
                case KeyEvent.VK_RIGHT: bR = true;
                    break;
                case KeyEvent.VK_UP:bU = true;
                    break;
                case KeyEvent.VK_DOWN:bD = true;
                    break;
                default:break;
            }


        }
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:  bL = false;
                    break;
                case KeyEvent.VK_RIGHT: bR = false;
                    break;
                case KeyEvent.VK_UP:bU = false;
                    break;
                case KeyEvent.VK_DOWN:bD = false;
                    break;
                default:break;
            }

        }

    }

}
