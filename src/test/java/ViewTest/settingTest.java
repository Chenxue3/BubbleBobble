package ViewTest;

import com.cw.view.Setting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:settingTest
 * @description:test setting
 * @version: v1.0
 */

public class settingTest {
    private Setting setting = new Setting();

    /**
     *test setting
     */
    @Test
    public void setTest(){
        Setting.setLevel("easy");
        String str1 = Setting.getLevel();
        Assertions.assertTrue("easy".equals(str1));
    }
}
