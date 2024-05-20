package com.mashibing.tank.Frame;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.model.Bullet;
import com.mashibing.tank.model.Tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hl.she
 * @Date 2020/5/16 19:59
 */
public class TankFrame extends Frame {

   private Tank tank;
   public List<Bullet> bullets = new ArrayList<Bullet>();
   public List<Tank> badTanks = new ArrayList<Tank>();
   public List<Tank> onlineTanks = new ArrayList<Tank>();
   public final static int GAME_WIDTH= 800 , GAME_HEIGHT = 600;

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public TankFrame() {

//        setSize(GAME_WIDTH, GAME_HEIGHT);
//        setResizable(false);
//        setTitle("坦克大战");
//        setVisible(true);
//
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//        this.addKeyListener(new TankKeyListener(tank));
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.GRAY);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        print(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);

    }

    /**
     * 画柄
     * @param g
     */
    @Override
    public void paint(Graphics g){

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawString("子弹的数量:" + bullets.size(),10,60);
        g.drawString("敌人的数量:" + badTanks.size(),10,80);
        g.setColor(c);


        tank.paint(g);
        for (int i = 0 ; i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        for (int i = 0 ; i<badTanks.size();i++){
            badTanks.get(i).paint(g);
        }

        for(int i = 0 ; i<bullets.size();i++){
            for (int j = 0 ; j < badTanks.size(); j++){
                bullets.get(i).collideWith(badTanks.get(j));
            }
        }




    }



}
