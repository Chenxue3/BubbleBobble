package UntilTest;

import com.cw.model.gameObject.Coin;
import com.cw.model.world.World;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InteractableWorldTest {
    private Canvas canvas;
    private World world;
    private InteractableWorld interactableWorld = new InteractableWorld(canvas,world);
    private Coin coin = new Coin(interactableWorld,10,10);
    private ArrayList<Coin> coins;

    @Test
    public void addTest(){
        interactableWorld.getCanvas();
    }
}