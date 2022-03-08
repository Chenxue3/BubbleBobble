package ModelTest.GameObjectTest;

import com.cw.model.gameObject.Enemy;
import com.cw.model.mapUnits.CeilingUnit;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author：xueshanChen
 * @ClassName:EnemyTest
 * @description:test enemy
 * @version: v1.0
 */

public class EnemyTest {
    private InteractableWorld interactableWorld;
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private CeilingUnit ceilingUnit = new CeilingUnit(interactableWorld,10,10);
    private FloorUnit floorUnit = new FloorUnit(interactableWorld,10,10);
    private Enemy enemy = new Enemy(interactableWorld,20,20);

    /**
     * test paint
     */
    @Test
    public void enemyTest(){
        enemy.paint(graphicsContext);
    }
}
