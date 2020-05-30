package com.nicholas.Alarm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class Main extends Application
    {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("alarmLayout.fxml"));
        primaryStage.setTitle("Alarm Application");
        primaryStage.setScene(new Scene(root, 375, 375));
        primaryStage.show();

    }


    public static void main(String[] args)
    {
        launch(args);

        Controller controller = new Controller();
    }


}
