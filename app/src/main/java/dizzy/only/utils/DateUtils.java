package dizzy.only.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：DateUtils
 */
public class DateUtils {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * 获取当前时间
     *
     * @param pattern
     * @return
     */
    public static String getCurrentTime(String pattern) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * 开始小于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareLDate(String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() < end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始小于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareLDate(String pattern, String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() < end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始大于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareGDate(String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() > end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始大于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareGDate(String pattern, String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() > end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始等于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareEDate(String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() == end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始等于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareEDate(String pattern, String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() == end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始小于等于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareLEDate(String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() <= end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始小于等于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareLEDate(String pattern, String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() <= end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始大于等于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareGEDate(String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() >= end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 开始大于等于结束时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareGEDate(String pattern, String startDate, String endDate) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return start.getTime() >= end.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
