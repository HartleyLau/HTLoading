package loadinglibrary.spinkit;


import loadinglibrary.spinkit.sprite.Sprite;
import loadinglibrary.spinkit.style.ChasingDots;
import loadinglibrary.spinkit.style.Circle;
import loadinglibrary.spinkit.style.CubeGrid;
import loadinglibrary.spinkit.style.DoubleBounce;
import loadinglibrary.spinkit.style.FadingCircle;
import loadinglibrary.spinkit.style.FoldingCube;
import loadinglibrary.spinkit.style.MultiplePulse;
import loadinglibrary.spinkit.style.MultiplePulseRing;
import loadinglibrary.spinkit.style.Pulse;
import loadinglibrary.spinkit.style.PulseRing;
import loadinglibrary.spinkit.style.RotatingCircle;
import loadinglibrary.spinkit.style.RotatingPlane;
import loadinglibrary.spinkit.style.ThreeBounce;
import loadinglibrary.spinkit.style.WanderingCubes;
import loadinglibrary.spinkit.style.Wave;

/**
 * Created by ybq.
 */
public class SpriteFactory {

    public static Sprite create(Style style) {
        Sprite sprite = null;
        switch (style) {
            case ROTATING_PLANE:
                sprite = new RotatingPlane();
                break;
            case DOUBLE_BOUNCE:
                sprite = new DoubleBounce();
                break;
            case WAVE:
                sprite = new Wave();
                break;
            case WANDERING_CUBES:
                sprite = new WanderingCubes();
                break;
            case PULSE:
                sprite = new Pulse();
                break;
            case CHASING_DOTS:
                sprite = new ChasingDots();
                break;
            case THREE_BOUNCE:
                sprite = new ThreeBounce();
                break;
            case CIRCLE:
                sprite = new Circle();
                break;
            case CUBE_GRID:
                sprite = new CubeGrid();
                break;
            case FADING_CIRCLE:
                sprite = new FadingCircle();
                break;
            case FOLDING_CUBE:
                sprite = new FoldingCube();
                break;
            case ROTATING_CIRCLE:
                sprite = new RotatingCircle();
                break;
            case MULTIPLE_PULSE:
                sprite = new MultiplePulse();
                break;
            case PULSE_RING:
                sprite = new PulseRing();
                break;
            case MULTIPLE_PULSE_RING:
                sprite = new MultiplePulseRing();
                break;
            default:
                break;
        }
        return sprite;
    }
}
