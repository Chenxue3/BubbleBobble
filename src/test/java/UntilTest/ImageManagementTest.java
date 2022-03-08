package UntilTest;

import com.cw.utility.ImageManagement;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xueshanChen
 * @title:ImageManagementTest
 * @description:test imageManagement
 * @version: v1.0
 */

public class ImageManagementTest {
    public static final Map<String, Image> heroImageMap = new HashMap<>();
    public static final Map<String, Image> enemyImage = new HashMap<>();
    public static final Map<String, Image> enemyBossImage = new HashMap<>();
    public static Image bgImage;
    public static Image unitImage;
    @Test
    public void imageManagementTest(){
        ImageManagement imageManagement = new ImageManagement();
        System.out.println(ImageManagement.enemyBossImage);
    }
}
