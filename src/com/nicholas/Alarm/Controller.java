package com.nicholas.Alarm;

import javafx.scene.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import java.util.TimerTask;

public class Controller
{


    Timer timer;

    Calendar calendar = Calendar.getInstance();
    Date time = calendar.getTime();
    Helper helper;
    AlarmTime alarmTime;

    public Button stopButton;

    public Label currentAlarm;

    public Label newAlarmMessage;

    public TextField enterNewAlarm;


    @FXML
    public void initialize()
    {
        this.alarmTime = new AlarmTime(calendar,7,0,0);
        helper = new Helper(alarmTime);
        currentAlarm.setText("Alarm set for 7:00 by Default. (24 Hour Format)");

    }

    public void stopAlarm(javafx.event.ActionEvent actionEvent)
    {
        helper.stop();

    }
    public void setAlarm(KeyEvent event)
    {
        if(event.getCode() == KeyCode.ENTER)
        {
            String string = enterNewAlarm.getText();

            try
            {
                alarmTime.setAlarm(Integer.parseInt(string,0,0,10),Integer.parseInt(string,2,2,10),Integer.parseInt(string,3,3,10));
            }
            catch(Exception e)
            {
                this.currentAlarm.setText("Invalid Format. Enter Again.");
            }

            this.currentAlarm.setText(String.format("Alarm set for %s",string));
        }
    }

}
