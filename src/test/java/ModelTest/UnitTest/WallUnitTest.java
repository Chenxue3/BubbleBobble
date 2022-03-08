package ModelTest.UnitTest;

import com.cw.model.mapUnits.WallUnit;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:WallUnitTest
 * @description:test WallUnit
 * @version: v1.0
 */

public class WallUnitTest {
    private InteractableWorld interactableWorld;
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private WallUnit wallUnit = new WallUnit(interactableWorld,10,10);
    @Test
    public void wallUnitTest(){
        wallUnit.paint(graphicsContext);
    }
}
