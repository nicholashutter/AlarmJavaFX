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

    public void setAlarm(int hour,int minute,int second)
    {

        this.hour = hour;
        this.minute = minute;
        this.second = second;

        calendar.set(Calendar.HOUR_OF_DAY,hour);

        calendar.set(Calendar.MINUTE,minute);

        calendar.set(Calendar.SECOND,second);


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
