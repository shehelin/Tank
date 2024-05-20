package com.mashibing.tank;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.Frame.TankKeyListener;
import com.mashibing.tank.confmgr.ResourceMgr;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.model.Tank;
import com.mashibing.tank.model.sub.BadTank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author hl.she
 * @Date 2020/5/16 19:44
 */
public class T {

    public static void main(String[] args)  throws InterruptedException{

//         TankFrame tankFrame = new TankFrame();
        TankFrame tankFrame= (TankFrame) initFrame();
         for(int i = 0 ; i < 9; i++){
             tankFrame.badTanks.add(new BadTank(50 + i*80,600- ResourceMgr.tankU.getHeight()/2, Dir.UP, Group.BAD,tankFrame));
         }
         while(true){
             Thread.sleep(40);
             tankFrame.repaint();
         }


    }


    /**
     * test 初始化  jframe过渡
     */
    public static Frame  initFrame(){

        TankFrame f = new TankFrame();
        Tank myTank = new Tank(100,25,Dir.DOWN, Group.GOOD,f);
        myTank.setMoving(false);
        f.setTank(myTank);
        f.setSize(800,600);
        f.setResizable(false);
        f.setTitle("坦克大战");
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.addKeyListener(new TankKeyListener(myTank));
        return f;
    }

}


