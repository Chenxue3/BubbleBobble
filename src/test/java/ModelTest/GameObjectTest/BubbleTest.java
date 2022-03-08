package ModelTest.GameObjectTest;

import com.cw.model.gameObject.Bubble;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * @author:xueshanChen
 * @title:BubbleTest
 * @description:test Bubble
 * @version: v1.0
 */

public class BubbleTest {
    private InteractableWorld interactableWorld;
    private Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private Bubble bubble = new Bubble(interactableWorld,10,10);
    @Test
    public void bubbleTest(){
        System.out.println(bubble.yVelocity);
//        bubble.paint(graphicsContext);
    }

}
