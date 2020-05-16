package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author hl.she
 * @Date 2020/5/16 19:44
 */
public class T {

    public static void main(String[] args)  throws InterruptedException{

         TankFrame tankFrame = new TankFrame();
         while(true){
             Thread.sleep(50);
             tankFrame.repaint();
         }


    }


    /**
     * test 初始化  jframe过渡
     */
    public static void initFrame(){
        Frame f = new Frame();
        f.setSize(800,600);
        f.setResizable(false);
        f.setTitle("tank war");
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}


