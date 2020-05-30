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

    public static int alarmSounding = 0;


    @FXML
    public void initialize()
    {

        AlarmTime alarmTime =new AlarmTime(calendar,7,0,0);
        this.alarmTime = alarmTime;
        helper = new Helper(alarmTime);
        currentAlarm.setText("Alarm set for 7:00 by Default. (24 Hour Format)");
        this.timer = new Timer();

        if (alarmSounding == 0)
        {
            stopButton.setVisible(false);
            currentAlarm.setVisible(true);
            newAlarmMessage.setVisible(true);
            enterNewAlarm.setVisible(true);
        }
        else if(alarmSounding == 1)
        {
            stopButton.setVisible(true);
            currentAlarm.setVisible(false);
            newAlarmMessage.setVisible(false);
            enterNewAlarm.setVisible(false);
        }





       // timer.schedule(helper,)

    }

    public void stopAlarm(javafx.event.ActionEvent actionEvent)
    {
        helper.stop();

    }
    public void setAlarm(KeyEvent event)
    {
        if(event.getCode() == KeyCode.ENTER)
        {

            String rawUserInput =enterNewAlarm.getText();
            String userInput = rawUserInput.replace(":","");


            int success = 0;

            try
            {
                if (userInput.length() == 3)
                {
                    alarmTime.setAlarm(Integer.parseInt(userInput.substring(0,1)),Integer.parseInt(userInput.substring(1,2)),Integer.parseInt(userInput.substring(2,3)));
                    success = 1;
                }
                else if (userInput.length() == 4)
                {
                    alarmTime.setAlarm(Integer.parseInt(userInput.substring(0,2)),Integer.parseInt(userInput.substring(2,3)),Integer.parseInt(userInput.substring(3,4)));
                    success = 1;
                }
                else
                {
                    this.currentAlarm.setText("Invalid Character Length. Try Again.");
                }

            }
            catch(Exception e)
            {
                this.currentAlarm.setText("An Error Occurred. Try Again.");
            }

            if (success == 1)
            {
                this.currentAlarm.setText(String.format("Alarm set for %s",rawUserInput));
            }
        }
    }

}
