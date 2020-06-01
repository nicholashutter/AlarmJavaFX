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

        AlarmTime alarmTime =new AlarmTime(calendar,7,0,0);
        this.alarmTime = alarmTime;
        helper = new Helper(alarmTime,this);
        currentAlarm.setText("Alarm set for 7:00 by Default. (24 Hour Format)");


        Timer timer = new Timer();
        timer.schedule(helper, 0, 500);
        stateDefault();




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

            String[] timeInput = rawUserInput.split(":");

            int success = 0;

            try
            {
                if(timeInput.length == 2)
                {
                    alarmTime.setAlarm(Integer.parseInt(timeInput[0],10), Integer.parseInt(timeInput[1],10), 0);  // just send zero seconds.

                    success = 1;
                }

                else
                {
                    currentAlarm.setText("Invalid Character Length. Try Again.");
                }

            }
            catch(Exception e)
            {
                currentAlarm.setText("An Error Occurred. Try Again.");
                e.printStackTrace();
            }

            if (success == 1)
            {
                currentAlarm.setText(String.format("Alarm set for %s",rawUserInput));
            }
        }
    }
    public void stateAlarmSounding ()
    {
        stopButton.setVisible(true);
        currentAlarm.setVisible(false);
        enterNewAlarm.setVisible(false);
        newAlarmMessage.setVisible(false);
    }
    public void stateDefault ()
    {
        stopButton.setVisible(false);
        currentAlarm.setVisible(true);
        enterNewAlarm.setVisible(true);
        newAlarmMessage.setVisible(true);

    }
}
