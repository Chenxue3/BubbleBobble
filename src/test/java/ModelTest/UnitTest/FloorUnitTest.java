package ModelTest.UnitTest;

import com.cw.model.mapUnits.CeilingUnit;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:FloorUnitTest
 * @description:test floor
 * @version: v1.0
 */

public class FloorUnitTest {
    private InteractableWorld interactableWorld;
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private CeilingUnit ceilingUnit = new CeilingUnit(interactableWorld,10,10);
    private FloorUnit floorUnit = new FloorUnit(interactableWorld,10,10);

    @Test
    public void floorUnitTest(){
        floorUnit.collideWith(ceilingUnit);
    }
}
