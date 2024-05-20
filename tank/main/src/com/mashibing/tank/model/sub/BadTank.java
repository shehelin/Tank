package com.mashibing.tank.model.sub;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.confmgr.ResourceMgr;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.model.Tank;

import java.awt.*;

public class BadTank  extends Tank {

    public BadTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super(x, y, dir, group, tf);
    }

    @Override
    public void paint(Graphics g) {
        //边界值的操作
        if (checkBoundary()){

            setMoving(false);
        }
        super.paint(g);
    }
}
