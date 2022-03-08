package ModelTest.GameObjectTest;

import com.cw.model.gameObject.HeroProjectile;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:HeroProjectileTest
 * @description:HeroProjectile test
 * @version: v1.0
 */

public class HeroProjectileTest {
    private InteractableWorld interactableWorld;
    private HeroProjectile heroProjectile = new HeroProjectile(interactableWorld,10,10,-1);
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    /**
     * test the paint
     */
    @Test
    public void heroProjectileTest(){
        heroProjectile.paint(graphicsContext);
    }
}
