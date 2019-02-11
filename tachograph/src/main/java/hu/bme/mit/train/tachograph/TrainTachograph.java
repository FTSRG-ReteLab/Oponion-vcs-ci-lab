package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.system.TrainSystem;

public class TrainTachograph {
    Table<Long, Integer, Integer> table
            = HashBasedTable.create();

    TrainSystem system;

    public TrainTachograph(TrainSystem ts) {
        system = ts;
    }

    public void recordValue(){
        int referenceSpeed = system.getController().getReferenceSpeed();
        int position = system.getUser().getJoystickPosition();
        long time = System.currentTimeMillis();
        table.put(time, position, referenceSpeed);
    }
}
