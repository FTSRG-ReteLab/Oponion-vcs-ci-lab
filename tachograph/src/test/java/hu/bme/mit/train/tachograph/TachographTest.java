package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.system.TrainSystem;
import org.junit.Assert;
import org.junit.Test;

public class TachographTest {
    TrainSystem system = new TrainSystem();
    TrainTachograph tachograph = new TrainTachograph(system);

    @Test
    public void recordValueTest() {
        system.getSensor().overrideSpeedLimit(10);
        system.getUser().overrideJoystickPosition(5);
        tachograph.recordValue();

        Assert.assertFalse(tachograph.isEmpty());
    }
}
