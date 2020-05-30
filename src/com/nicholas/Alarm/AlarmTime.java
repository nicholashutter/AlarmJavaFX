package com.nicholas.Alarm;

import java.util.Calendar;

public class AlarmTime
{
    Calendar calendar;
    int hour;
    int minute;
    int second;
    public AlarmTime(Calendar calendar,int hour,int minute,int second)
    {
        this.calendar=calendar;
        this.hour=hour;
        this.minute=minute;
        this.second=second;

    }

    public void setAlarm(int x,int y,int z)
    {

        x = hour;

        y = minute;

        z = second;

        calendar.set(Calendar.HOUR_OF_DAY,x);

        calendar.set(Calendar.MINUTE,y);

        calendar.set(Calendar.SECOND,z);
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public int getSecond()
    {
        return second;
    }

}
