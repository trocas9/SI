/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supervisorfx;

import kit.StorageSystem;
import org.jpl7.Query;

/**
 *
 * @author worten
 */
public class MonitoringThread extends Thread {
    
    private boolean interrupted=false;
    private StorageSystem storageSystem;

    public MonitoringThread(StorageSystem storageSystem) {
        super();
        this.storageSystem = storageSystem;        
    }

    @Override
    public void run() {
        while(!interrupted) {
            try {Thread.sleep(1); }catch(InterruptedException e){}
            readSystemState();
        }
    }
     public void readSystemState() {
        updateEvent("x_is_at", storageSystem.getXPos()); 
        updateEvent("y_is_at", storageSystem.getYPos());
        updateEvent("z_is_at", storageSystem.getzPos());
        updateEvent("x_moving", storageSystem.getXMoving());
        updateEvent("y_moving", storageSystem.getYMoving());
        updateEvent("z_moving", storageSystem.getZMoving());
        // complete for the remaining sensors
        // ....        
    }
    
    public void updateEvent(String name, int value) { //prolog term with one argument
        String query = String.format("update_event(%s, %d)", name, value);
        String result = (Query.hasSolution(query) ? "" : "query " + name+ " failed");
        if(!result.equalsIgnoreCase(""))
            System.out.println(result);
    }
    
    public void updateEvent(String name) { //prolog term without argument
        String query = String.format("update_event(%s)", name);
        String result = (Query.hasSolution(query) ? "" : "query " + name+ " failed");
        if(!result.equalsIgnoreCase(""))
            System.out.println(result);
    }

    public void setInterrupted() {
        this.interrupted = true;
    }
    
    static public void main(String []args) {

        StorageSystem storageSystem = new StorageSystem();
        storageSystem.initializeHardwarePorts();        
        TestProlog.consultFile("events_model.pl");
        
        
       
        MonitoringThread monitoringThread = new MonitoringThread(storageSystem);
     
        monitoringThread.start();
        TestProlog.userInputPrologRoutine();
    }


}

