package UntilTest;

import com.cw.utility.Sound;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:UntilTest.SoundTest
 * @description:test the sound player
 * @version: v1.0
 */

public class SoundTest {
    @Test
    public void soundTest(){
        Sound.playSound(Sound.DEATH);
    }
}
