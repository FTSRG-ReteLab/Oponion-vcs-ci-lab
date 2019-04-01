package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockController;
    TrainUser mockUser;
    TrainSensor sensor;

    @Before
    public void before() {
        mockController = mock(TrainController.class);
        mockUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void SpeedLimitAboveAbsoluteMargin() {

        sensor.overrideSpeedLimit(501);
        verify(mockUser, times(1)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }

    @Test
    public void SpeedLimitNegative() {
        sensor.overrideSpeedLimit(-1);
        verify(mockUser, times(1)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }

    @Test
    public void SpeedLimitLessThanHalfOfRefSpeed() {
        // Arrange
        when(mockController.getReferenceSpeed()).thenReturn(10);

        // Act
        sensor.overrideSpeedLimit(4);

        // Assert
        verify(mockUser, times(1)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }

    @Test
    public void ValidOverrideSpeedLimit() {
        // Arrange
        when(mockController.getReferenceSpeed()).thenReturn(10);

        // Act
        sensor.overrideSpeedLimit(6);

        // Assert
        verify(mockUser, times(0)).setAlarmState(true);
        verify(mockUser, times(1)).setAlarmState(false);
    }
}
