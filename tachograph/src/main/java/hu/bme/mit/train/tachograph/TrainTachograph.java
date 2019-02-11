package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {
    Table<String, String, Integer> table
            = HashBasedTable.create();

    public void recordValue(){
        
    }
}
