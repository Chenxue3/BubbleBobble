package ModelTest.UnitTest;

import com.cw.model.mapUnits.CeilingUnit;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:CeilingUnitTest
 * @description:test the class CeilingUnit
 * @version: v1.0
 */

public class CeilingUnitTest {
    private InteractableWorld interactableWorld;
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private CeilingUnit ceilingUnit = new CeilingUnit(interactableWorld,10,10);

    @Test
    public void ceilingUnitTest(){
        System.out.println(ceilingUnit.imageDirection);
        ceilingUnit.paint(graphicsContext);
    }
}
