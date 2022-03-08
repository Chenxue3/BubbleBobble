package com.cw.utility;

import javafx.scene.media.AudioClip;

/**
 * @author:xueshanChen
 * @title:Sound
 * @description:This class used to play sounds
 * @version: v1.0
 */

public class Sound {
    /**
     * define all the songs as a public static variables so that can be accessed by another methods
     */
    public static final String BUTTON_ON_CLICK_SONG = "/static/sfx/button_click_on.wav";
    public static final String SHOT_SOUND = "/static/sfx/shoot.wav";
    public static final String JUMP_SOUND = "/static/sfx/jump.wav";
    public static final String BUBBLED = "/static/sfx/bubbled.wav";
    public static final String DEATH = "/static/sfx/death.wav";
    public static final String FRUIT = "/static/sfx/fruit.wav";
    public static final String LAND = "/static/sfx/land.wav";
    public static final String POP = "/static/sfx/pop.wav";
    public static final String HIT = "/static/sfx/hit.wav";
    public static final String EXPLODE_SONG="/static/sfx/explode.wav";

    /**
     * play sound
     *
     * @param soundName
     */
    public static void playSound(String soundName) {
        AudioClip audioClip = new AudioClip(Sound.class.getResource(soundName).toString());
        audioClip.play();
    }
}
