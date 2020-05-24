package com.mashibing.tank;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.model.Tank;

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

         for(int i = 0 ; i < 5; i++){
             tankFrame.tanks.add(new Tank(50 + i*80,200, Dir.UP, Group.BAD,tankFrame));
         }
         while(true){
             Thread.sleep(40);
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


