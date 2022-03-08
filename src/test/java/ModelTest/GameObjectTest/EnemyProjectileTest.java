package ModelTest.GameObjectTest;

import com.cw.model.gameObject.EnemyProjectile;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:EnemyProjectileTest
 * @description:test enemy projectile
 * @version: v1.0
 */

public class EnemyProjectileTest {
    private InteractableWorld interactableWorld;
    private EnemyProjectile enemyProjectile = new EnemyProjectile(interactableWorld,10,10,-1);
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    /**
     * test enemy projectile paint
     */
    @Test
    public void enemyProjectileTest(){
        enemyProjectile.paint(graphicsContext);
    }
}
