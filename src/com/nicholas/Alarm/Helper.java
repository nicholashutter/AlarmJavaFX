package com.nicholas.Alarm;

import java.time.LocalTime;
import java.util.TimerTask;

public class Helper extends TimerTask
{
    LocalTime localTime = LocalTime.now();

    AePlayWave aw = new AePlayWave("alarm.wav");    // renamed the wav file and placed in top most directory so it can be found properly

    AlarmTime alarmTime;

    Boolean interrupt = false;

    Controller controller = null;// interrupt can be altered by UI to stop

    public Helper(AlarmTime alarmTime,Controller controller)
    {
        this.alarmTime=alarmTime;
        this.controller = controller;
    }

    public void run()
    {

        int hr = alarmTime.getHour();
        int min = alarmTime.getMinute();
        int second = alarmTime.getSecond();

        localTime = LocalTime.now();

        if ((localTime.getHour()== hr && localTime.getMinute()== min && localTime.getSecond() == 0) && interrupt == false)  
        {
            if (!aw.isAlive())
            {
                aw.start();
                controller.stateAlarmSounding();

            }
            
        }
    }

    public void stop()
    {
        aw.stop();
        controller.stateDefault();
    }

}
