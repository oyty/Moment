package com.xelement.moment.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {

    public static final String DATE_FORMAT = "yyyy.MM.dd HH:mm";
    public static final String DATE_FORMAT_NEW = "yyyy年MM月dd日";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_ZERO = "MM-dd HH:mm";
    public static final String DATETIME_FORMAT_MINUTE = "HH:mm";
    public static final String DATETIME_FORMAT_MS = "yyyy-MM-dd HH:mm:ss SSS";

    public static final String DATE_FORMAT_COMPACT = "yyyyMMdd";
    public static final String DATETIME_FORMAT_COMPACT = "yyyyMMddHHmmssS";
    public static final String DATETIME_FORMAT_POINT = "yyyy.MM.dd";
    public static final String DATETIME_FORMAT_SLASH = "yyyy/MM/dd";
    public static final String DATETIME_NO_YEAR = "MM月dd日 HH:mm";

    private static GregorianCalendar calendar = new GregorianCalendar();

    public static String formatDate(Date paramDateTime, String formatString) {
        if (paramDateTime == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(formatString,
                Locale.CHINA);

        return format.format(paramDateTime);
    }

    public static String formatDate(Date paramDate) {
        return formatDate(paramDate, DATE_FORMAT);
    }

    public static String formatDateTime(Date paramDate) {
        return formatDate(paramDate, DATETIME_FORMAT);
    }

    public static Date parseDate(String paramString, String formatString) {
        if ((paramString == null) || (paramString.trim().equals(""))) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(formatString,
                Locale.CHINA);

        try {
            return format.parse(paramString);
        } catch (Exception e) {

        }
        return null;
    }

    public static Date parseDate(String paramString) {
        return parseDate(paramString, DATE_FORMAT);
    }

    /**
     * 字符串转日期时间
     *
     * @param paramString
     * @return
     */
    public static Date parseDateTime(String paramString) {
        return parseDate(paramString, DATETIME_FORMAT);
    }

    public static void toDayBegin(Calendar calendar) {
        try {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void toDayEnd(Calendar calendar) {
        try {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatMillisToHMS(long millis) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return formatter.format(millis);
    }

    // 将时间戳转为字符串
    public static String getStrTime(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    public static String getStrMinute(String next) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_MINUTE);
        return sdf.format(new Date(Long.parseLong(next)));
    }

    // 将时间戳转为字符串
    public static String getNoYearStrDate(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_NO_YEAR);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    // 将时间戳转为字符串
    public static String getStrDate(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_POINT);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    // 将时间戳转为字符串
    public static String getShortStrTime(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    // 将时间戳转为字符串
    public static String getShortStrTimeNew(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NEW);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    // 将时间戳转为字符串
    public static String getSlashStrTime(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_SLASH);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    // 将时间戳转为字符串
    public static String getZeroStrTime(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_ZERO);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    public static String getCurrentTime() {
        return formatDate(new Date());
    }

    public static String getDayString(long str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date(str));
    }

    public static long getMillis(String dateString) {
        String[] date = dateString.split("-");
        return getMillis(date[0], date[1], date[2]);
    }

    public static long getMillis(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTimeInMillis();

    }

    public static long getMillis(String yearString, String monthString,
                                 String dayString) {
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString) - 1;
        int day = Integer.parseInt(dayString);
        return getMillis(year, month, day);
    }

    // 获得昨天日期
    public static String getYesData(long cur) {
        return getDayString(cur - 86400000L);
    }

    // 获得今天日期
    public static String getTodayData(long cur) {
        return getDayString(cur);
    }


    // 获得明天日期
    public static String getTomoData(long cur) {
        // 86400000为一天的毫秒数
        return getDayString(cur + 86400000);
    }

    public static String getWeek(long millis) {
        calendar.setTimeInMillis(millis);
        String week = "";
        int cweek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (cweek) {
            case 1:
                week = "日";
                break;
            case 2:
                week = "一";
                break;
            case 3:
                week = "二";
                break;
            case 4:
                week = "三";
                break;
            case 5:
                week = "四";
                break;
            case 6:
                week = "五";
                break;
            case 7:
                week = "六";
                break;
        }
        return week;

    }

    public static String getCustomStr(String current, String next) {
        long cur = Long.parseLong(current);
        long ne = Long.parseLong(next);

        if (getMillis(getDayString(ne)) == getMillis(getYesData(cur))) {
            return "昨天";
        } else if (getMillis(getDayString(ne)) == getMillis(getTodayData(cur))) {
            return "今天";
        } else if (getMillis(getDayString(ne)) == getMillis(getTomoData(cur))) {
            return "明天";
        } else {
            return "星期" + getWeek((getMillis(getDayString(ne))));
        }
    }

    public static String getHour(long timestamp) {
        Date date = new Date(timestamp);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String hourStr = (hour < 10) ? ("0" + hour) : String.valueOf(hour);
        String minuteStr = (minute < 10) ? ("0" + minute) : String.valueOf(minute);
        return hourStr + ":" + minuteStr;
    }
}