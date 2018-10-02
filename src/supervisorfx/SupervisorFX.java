/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supervisorfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import kit.StorageSystem;

/**
 *
 * @author worten
 */
public class SupervisorFX extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        StorageSystem storageSystem = new StorageSystem();
        storageSystem.initializeHardwarePorts();
        
        //Setting actuators buttons//        
        //Declaration and setting up of the X axis
        Button buttonXRight = new Button("x-rigth");
        Button buttonXLeft = new Button("x-Left");
        Button buttonXStop = new Button("x-top");
        
        buttonXRight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonXLeft.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonXStop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        buttonXRight.setOnAction(event ->{
        storageSystem.moveXRight();
        System.out.println("X moving right");
        });
        
        buttonXLeft.setOnAction(event ->{
        storageSystem.moveXLeft();
        System.out.println("X moving left");
        });
        
        buttonXStop.setOnAction(event ->{
        storageSystem.stopX();
        System.out.println("X Stop");
        });
    
        //Declaration and setting up of the Y axis
        Button buttonYInside = new Button("Y-inside");
        Button buttonYOutside = new Button("Y-Outside");
        Button buttonYStop = new Button("Y-stop");
        
        buttonYInside.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonYOutside.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonYStop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        buttonYInside.setOnAction(event ->{
        storageSystem.moveYInside();
        System.out.println("Y going Inside");
        });
        
        buttonYOutside.setOnAction(event ->{
        storageSystem.moveYOutside();
        System.out.println("Y going Outside");
        });
        
        buttonYStop.setOnAction(event ->{
        storageSystem.stopY();
        System.out.println("Y Stoped");
        });
        
        //Declaration and setting up of the Z axis
        Button buttonZUp = new Button("Z-up");
        Button buttonZDown = new Button("Z-down");
        Button buttonZStop = new Button("Z-stop");
    
        buttonZUp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonZDown.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonZStop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        buttonZUp.setOnAction(event ->{
        storageSystem.moveZUp();
        System.out.println("Z going up");
        });
        
        buttonZDown.setOnAction(event ->{
        storageSystem.moveZDown();
        System.out.println("Z going Down");
        });
        
        buttonZStop.setOnAction(event ->{
        storageSystem.stopz();
        System.out.println("Z Stop");
        });  
        
        //Declaration and setting up of the Left Pane
        Button buttonLeftPin = new Button("Left Pain - in");
        Button buttonLeftPout = new Button("Left Pain - out");
        Button buttonLeftPStop = new Button("Left Pain - stop");
    
        buttonLeftPin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonLeftPout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonLeftPStop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        buttonLeftPin.setOnAction(event ->{
        storageSystem.moveLeftStationIn();
        System.out.println("Left P moving In");
        });
        
        buttonLeftPout.setOnAction(event ->{
        storageSystem.moveLeftStationOut();
        System.out.println("Left P moving Out");
        });
        
        buttonLeftPStop.setOnAction(event ->{
        storageSystem.stopLeftStation();
        System.out.println("Left Station Stop");
        });
        
        //Sensor buttons and visors
        
        Button buttonGetInfoX = new Button("X-Pos");     
        
        buttonGetInfoX.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);        
        
        buttonGetInfoX.setOnAction(event ->{
        System.out.println("Moving: "+storageSystem.getXMoving());
        });
        
        
        GridPane root = new GridPane();
        root.add(buttonXRight, 1, 1);
        root.add(buttonXLeft, 2, 1);
        root.add(buttonXStop, 3, 1);
        
        root.add(buttonZUp, 1, 2);
        root.add(buttonZDown, 2, 2);
        root.add(buttonZStop, 3, 2);
        
        root.add(buttonYInside, 1, 3);
        root.add(buttonYOutside, 2, 3);
        root.add(buttonYStop, 3, 3);
        
        root.add(buttonLeftPin, 1, 4);
        root.add(buttonLeftPout, 2, 4);
        root.add(buttonLeftPStop, 3, 4);
        
        root.add(buttonGetInfoX, 1, 5);
        
        root.setHgap(10);
        root.setVgap(10);
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();}

   
        
    /**
     * @param args the command line arguments
     */

    
    
}
