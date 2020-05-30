package com.nicholas.Alarm;

import java.time.LocalTime;
import java.util.TimerTask;

public class Helper extends TimerTask
{
    LocalTime localTime = LocalTime.now();

    AePlayWave aw = new AePlayWave("alarm.wav");

    AlarmTime alarmTime;

    public Helper(AlarmTime alarmTime)
    {
        this.alarmTime=alarmTime;
    }

    public void run()
    {
        if (localTime.getHour()== alarmTime.getHour() & localTime.getMinute()==alarmTime.getMinute() & localTime.getSecond() == alarmTime.getSecond())

        {
            aw.start();
        }

    }

    public void stop()
    {
        aw.stop();
    }
}
