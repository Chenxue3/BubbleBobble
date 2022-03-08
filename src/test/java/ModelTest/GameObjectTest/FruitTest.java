package ModelTest.GameObjectTest;

import com.cw.model.gameObject.Enemy;
import com.cw.model.gameObject.Fruit;
import com.cw.model.mapUnits.CeilingUnit;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;


/**
 * @author：xueshanChen
 * @title:FruitTest
 * @description:test fruit
 * @version: v1.0
 */

public class FruitTest {
    private InteractableWorld interactableWorld;
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private CeilingUnit ceilingUnit = new CeilingUnit(interactableWorld,10,10);
    private FloorUnit floorUnit = new FloorUnit(interactableWorld,10,10);
    private Enemy enemy = new Enemy(interactableWorld,20,20);
    private Fruit fruit = new Fruit(1,2,10,interactableWorld);

    /**
     * test the variable in the fruit class
     */
    @Test
    public void fruitTeat(){
        System.out.println(fruit.canRemove);
    }
}
