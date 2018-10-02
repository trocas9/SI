/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kit;

/**
 *
 * @author worten
 */
public class StorageSystem {
    static{
        System.load("C:\\str2018\\SI\\Labwork1\\x64\\Debug\\Labwork1.dll");
    }
    
    native public void initializeHardwarePorts();
    //Sensors
    native public int getXPos();
    native public int getYPos();
    native public int getzPos();
    native public int getXMoving();
    native public int getYMoving();
    native public int getZMoving();
    native public int getLeftStationMoving();
    native public int getRigthStationMoving();
    native public boolean isAtZUp();
    native public boolean isAtZDown();
    native public boolean isPartInCage();
    native public boolean isPartAtLeftStation();
    native public boolean isPartAtRightStation();
    
    //Past sensor values
    native public void setPreviousXPos(int pos);
    native public void setPreviousYPos(int pos);
    native public void setPreviousZPos(int pos);

    native public int getPreviousXPos();
    native public int getPreviousYPos();
    native public int getPreviousZPos();
    
    //actuator Signature
    
    native public void moveXRight();
    native public void moveXLeft();
    native public void stopX();
    native public void stopY();
    native public void stopz();
    native public void moveYInside();
    native public void moveYOutside();
    native public void moveZUp();
    native public void moveZDown();
    native public void moveLeftStationIn();
    native public void moveLeftStationOut();
    native public void stopLeftStation();
    native public void stopRightStation();
    native public void moveRightStationIn();
    native public void moveRightStationOut();




}   
