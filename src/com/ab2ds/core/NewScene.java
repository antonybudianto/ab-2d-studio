/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ab2ds.core;

import com.falcron.core.Renderable;
import com.falcron.core.SimpleGame;
import com.falcron.graphics.core.SimpleText;
import com.falcron.graphics.scene.SimpleScene;
import com.falcron.sprite.AnimatedSprite;
import com.falcron.sprite.Entity;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 *
 * @author Antony
 */

public class NewScene extends SimpleScene{
    
    public NewScene(SimpleGame game) {
        super(game);
        //setSize(720, 480);
    }
    
    public Vector<Renderable> getRenderables() {return renderables;}
    
    public Renderable checkClick(MouseEvent e){
        synchronized(renderables){
            for(Renderable r : renderables){
                if(((Entity)r).getBounds().contains(e.getPoint())){
                    if(r instanceof SimpleText || r instanceof AnimatedSprite){
                        return r;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public void update(float f) {
        MainFrame.labelups.setText(getUPS()+"");
    }

    @Override
    public void render(Graphics2D gd) {
        MainFrame.labelfps.setText(getFPS()+"");
    }

    @Override
    public void initResource() {
        
    }
    
}
