package com.superlht.htloading.spinkit.style;


import com.superlht.htloading.spinkit.sprite.Sprite;
import com.superlht.htloading.spinkit.sprite.SpriteContainer;

/**
 * Created by ybq.
 */
public class MultiplePulse extends SpriteContainer {
    @Override
    public Sprite[] onCreateChild() {
        return new Sprite[]{
                new Pulse(),
                new Pulse(),
                new Pulse(),
        };
    }

    @Override
    public void onChildCreated(Sprite... sprites) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].setAnimationDelay(200 * (i + 1));
        }
    }
}
