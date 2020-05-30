package com.nicholas.Alarm;

import java.time.LocalTime;
import java.util.TimerTask;

public class Helper extends TimerTask
{
    LocalTime localTime = LocalTime.now();

    AePlayWave aw = new AePlayWave("alarm.wav");    // renamed the wav file and placed in top most directory so it can be found properly

    AlarmTime alarmTime;

    Boolean interrupt = false;              // interrupt can be altered by UI to stop

    public Helper(AlarmTime alarmTime)
    {
        this.alarmTime=alarmTime;
    }

    public void run()
    {
        //THIS CODE WAS CHANGED
        int hr = alarmTime.getHour();       // no need to continually call this method.  We will just get it once.
        int min = alarmTime.getMinute();    // same here

        localTime = LocalTime.now();        // we need to update the localtime variable each cycle

        if ((localTime.getHour()== hr && localTime.getMinute()== min && localTime.getSecond() == 0) && interrupt == false)  
        {
            if (!aw.isAlive())              // make sure the aw thread isnt already playing the audio
            {
                aw.start();
                Controller.alarmSounding=1;
            }
            
        }
        //END OF CHANGE
    }

    public void stop()
    {
        aw.stop();
    }

}
