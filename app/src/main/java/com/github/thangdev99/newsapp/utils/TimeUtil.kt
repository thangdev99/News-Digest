package com.github.thangdev99.newsapp.utils

import java.util.Calendar

object TimeUtil {
    fun getInitialDelay(): Long {
        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)
        
        // Schedule for 5 AM daily
        val targetHour = 5
        
        val targetCalendar = Calendar.getInstance()
        targetCalendar.set(Calendar.HOUR_OF_DAY, targetHour)
        targetCalendar.set(Calendar.MINUTE, 0)
        targetCalendar.set(Calendar.SECOND, 0)
        
        // If target time has already passed today, schedule for tomorrow
        if (targetCalendar.timeInMillis <= System.currentTimeMillis()) {
            targetCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        
        val delayMillis = targetCalendar.timeInMillis - System.currentTimeMillis()
        return if (delayMillis > 0) delayMillis else 0
    }
}

