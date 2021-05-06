//package com.exanple.demo.stringtest.test;
//
//import com.fpaas2.exception.BusinessException;
//import com.fpaas2.utils.DateUtil;
//import org.apache.commons.lang3.time.DateFormatUtils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//
///**
// * @description 时间日期工具
// * @author leo
// * @date 2016年12月30日
// */
//public class DateUtils extends DateUtil {
//
//    /**
//     * @deccription 将年月日和时分秒拼接成新的时间
//     * @param date
//     * @param time
//     * @return
//     * @return Date
//     */
//    public static Date getDtTime(Date date, Date time) {
//        Calendar calendarDate = Calendar.getInstance();
//        calendarDate.setTime(date);
//
//        Calendar calendarTime = Calendar.getInstance();
//        calendarTime.setTime(time);
//
//        calendarDate.set(Calendar.HOUR_OF_DAY, calendarTime.get(Calendar.HOUR_OF_DAY));
//        calendarDate.set(Calendar.MINUTE, calendarTime.get(Calendar.MINUTE));
//        calendarDate.set(Calendar.SECOND, calendarTime.get(Calendar.SECOND));
//        return calendarDate.getTime();
//    }
//
//
//    /**
//     * 比较两个日期
//     *
//     * @param firstDate
//     * @param secondDate
//     * @return
//     */
//    public static int isEqual(Date firstDate, Date secondDate) {
//        Calendar calendarFisrt = Calendar.getInstance();
//        calendarFisrt.setTime(firstDate);
//        calendarFisrt.set(Calendar.HOUR_OF_DAY, 0);
//        calendarFisrt.set(Calendar.MINUTE, 0);
//        calendarFisrt.set(Calendar.SECOND, 0);
//        calendarFisrt.set(Calendar.MILLISECOND, 0);
//
//        Calendar calendarSecond = Calendar.getInstance();
//        calendarSecond.setTime(secondDate);
//        calendarSecond.set(Calendar.HOUR_OF_DAY, 0);
//        calendarSecond.set(Calendar.MINUTE, 0);
//        calendarSecond.set(Calendar.SECOND, 0);
//        calendarSecond.set(Calendar.MILLISECOND, 0);
//
//        return calendarFisrt.compareTo(calendarSecond);
//
//    }
//
//
//    /**
//     * 指定日期加上天数后的日期
//     *
//     * @param oriDate
//     * @param num
//     * @return
//     */
//    public static Date plusDay(int num, Date oriDate) {
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(oriDate);
//        ca.add(Calendar.DATE, num);
//        Date currentDate = ca.getTime();
//        return currentDate;
//    }
//
//
//    /**
//     * 获取系统时间
//     *
//     *
//     * @return
//     */
//    public static Date getSysTime() {
//        Calendar ca = Calendar.getInstance();
//        return ca.getTime();
//    }
//
//
//    /**
//     * 获取时间+N分钟后的时间
//     *
//     * @param txnTime
//     * @param min
//     * @return Date
//     * @author qulu
//     */
//    public static Date getTimeByMin(Date txnTime, String min) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(txnTime);
//        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + new Integer(min));
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//    // 获取时间+N分钟前的时间
//    public static Date getTimeBeforMin(Date txnTime, String min) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(txnTime);
//        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - new Integer(min));
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//
//    /**
//     * 获取时间+N小时后的时间
//     *
//     * @param txnTime
//     * @param hour
//     * @return Date
//     * @author luyang
//     */
//    public static Date getTimeByHour(Date txnTime, String hour) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(txnTime);
//        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + new Integer(hour));
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//    /**
//     * 获取时间+N小时前的时间
//     *
//     * @param txnTime
//     * @param hour
//     * @return Date
//     * @author luyang
//     */
//    public static Date getTimeBeforeHour(Date txnTime, String hour) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(txnTime);
//        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - new Integer(hour));
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//
//    /**
//     * 获取时间+N天后的时间
//     *
//     * @param txnTime
//     * @param day
//     * @return Date
//     * @author luyang
//     */
//    public static Date getTimeByDay(Date txnTime, String day) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(txnTime);
//        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + new Integer(day));
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//
//    /**
//     * 获取时间+N月后的时间
//     *
//     * @param date
//     * @param month
//     * @return Date
//     * @author luyang
//     */
//    public static Date getTimeByMonth(Date date, int month) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//
//    /**
//     * 获取按日的预约计划表
//     *
//     * @param beginDate
//     * @param finishDate
//     * @return List<Date>
//     * @author luyang
//     */
//    public static List<Date> getOrderDay(Date beginDate, Date finishDate) {
//        Calendar calendar = Calendar.getInstance();
//        Date temp = null;
//        List<Date> result = new ArrayList<Date>();
//        if (beginDate != null && finishDate != null) {
//            temp = beginDate;
//            while (temp.before(finishDate) || temp.equals(finishDate)) {
//                calendar.setTime(temp);
//                calendar.add(Calendar.DATE, 1);
//                result.add(temp);
//                temp = calendar.getTime();
////                if (temp.equals(finishDate))
////                    result.add(temp);
//
//            }
//        }
//        return result;
//    }
//
//
//    /**
//     * 获取按周的预约计划表
//     *
//     * @param beginDate
//     * @param finishDate
//     * @return List<Date>
//     * @author luyang
//     */
//    public static List<Date> getOrderWeek(Date beginDate, Date finishDate, int weekDay) {
//        Calendar calendar = Calendar.getInstance();
//        Date temp = null;
//        boolean flag = true;
//        boolean flag1 = true;
//        List<Date> result = new ArrayList<Date>();
//        if (beginDate != null && finishDate != null) {
//            temp = beginDate;
//            if(weekDay == 7){
//                weekDay = 0;
//            }
//            while (temp.before(finishDate)) {
//                calendar.setTime(temp);
//                int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//                if (flag) {
//                    if (week == weekDay) {
//                        result.add(temp);
//                        flag = false;
//                        flag1 = false;
//                    }
//                    if (flag1) {
//                        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
//                        temp = calendar.getTime();
//                    }
//
//                } else {
//                    calendar.setTime(temp);
//                    calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 7);
//                    temp = calendar.getTime();
//                    if (temp.before(finishDate))
//                        result.add(temp);
//                    if (temp.equals(finishDate))
//                        result.add(temp);
//                }
//            }
//        }
//        return result;
//    }
//
//
//    /**
//     * 获取按月的预约计划表
//     *
//     * @param beginDate
//     * @param finishDate
//     * @return List<Date>
//     * @author luyang
//     */
//    public static List<Date> getOrderMonth(Date beginDate, Date finishDate, int monthDay) {
//        Calendar calendar = Calendar.getInstance();
//        Date temp = null;
//        List<Date> result = new ArrayList<Date>();
//        if (beginDate != null && finishDate != null) {
//            temp = beginDate;
//            while (temp.before(finishDate)) {
//                calendar.setTime(temp);
//                calendar.set(Calendar.DAY_OF_MONTH, monthDay);
//                temp = calendar.getTime();
//                calendar.add(Calendar.MONTH, 1);
//                if (temp.before(finishDate)) {
//                    if (temp.after(beginDate)) {
//                        result.add(temp);
//                    } else if (temp.equals(beginDate)) {
//                        result.add(temp);
//                    }
//                }
//                temp = calendar.getTime();
//            }
//            if (temp.equals(finishDate)) {
//                result.add(temp);
//            }
//        }
//        return result;
//    }
//
//
//    /**
//     * 解析字符串成指定格式日期
//     *
//     * @param dateStr
//     *            日期
//     * @param dateFormat
//     *            自定义格式
//     * @return Date
//     * @throws ParseException
//     */
//    public static Date parseStrToDate(String dateStr, String dateFormat) {
//        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
//        Date d = null;
//        try {
//            d = sdf.parse(dateStr);
//        } catch (ParseException e) {
////            throw new BusinessException("BBPF0025", "日期转换");
//        }
//
//        // 如果不包括年份，将其设为当前年份或者当前年份减1
//        if (dateFormat.indexOf("yy") == -1) {
//            Calendar cal = Calendar.getInstance();
//            Date now = cal.getTime();
//            int year = cal.get(Calendar.YEAR);
//            cal.setTime(d);
//            cal.set(Calendar.YEAR, year);
//            d = cal.getTime();
//            if (now.compareTo(d) < 0) {
//                cal.set(Calendar.YEAR, year - 1);
//            }
//            d = cal.getTime();
//        }
//
//        return d;
//    }
//
//
//    /**
//     * 格式化日期成指定格式字符串
//     *
//     * @param date
//     * @param strFormat
//     * @return String
//     */
//    public static String formatDateToStr(Date date, String strFormat) {
//        String dateFormat = null;
//        if (date != null) {
//            SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
//            dateFormat = sdf.format(date);
//        }
//
//        return dateFormat;
//    }
//
//    /**
//     * 获取时间-N天后的时间
//     *
//     * @param txnTime
//     * @param day
//     * @return Date
//     * @author luyang
//     */
//    public static Date getTimeReduceDay(Date txnTime, String day) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(txnTime);
//        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - new Integer(day));
//        Date outTime = calendar.getTime();
//        return outTime;
//    }
//
//
//    /**
//     * 时间格式转化
//     *
//     * @throws ParseException
//     *
//     *
//     */
//    public static Date getFormatDate(Date date, String format) {
//        Date newDate = null;
//        if (date != null) {
//            SimpleDateFormat sdf = new SimpleDateFormat(format);
//            try {
//                newDate = sdf.parse(sdf.format(date));
//            } catch (ParseException e) {
////                throw new BusinessException("BBPF0025", "日期转换");
//            }
//        }
//        return newDate;
//
//    }
//
//
//    /**
//     * 获取日期间隔
//     *
//     * @param d1
//     * @param d2
//     * @return
//     * @throws ParseException
//     */
//    public static Long getDaysInterval(Date d1, Date d2) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Date d3 = null;
//        Date d4 = null;
//        try {
//            d3 = sdf.parse(sdf.format(d1));
//            d4 = sdf.parse(sdf.format(d2));
//        } catch (ParseException e) {
////            throw new BusinessException("BBPF0025", "日期转换");
//        }
//
//        return (d4.getTime() - d3.getTime()) / 86400000;
//    }
//
//
//    /**
//     * 功能：判断输入年份是否为闰年<br>
//     *
//     * @param year
//     * @return 是：true 否：false
//     * @author pure
//     */
//    public boolean leapYear(int year) {
//        boolean leap;
//        if (year % 4 == 0) {
//            if (year % 100 == 0) {
//                if (year % 400 == 0)
//                    leap = true;
//                else
//                    leap = false;
//            } else
//                leap = true;
//        } else
//            leap = false;
//        return leap;
//    }
//
//
//    /**
//     * 功能：得到当前月份月初 格式为：xxxx-yy-zz (eg: 2007-12-01)<br>
//     *
//     * @return String
//     * @author pure
//     */
//    public String thisMonth() {
//        Calendar localTime = Calendar.getInstance();
//        String strY = null;
//        int x;
//        int y;
//        x = localTime.get(Calendar.YEAR);
//        y = localTime.get(Calendar.MONTH) + 1;
//        strY = y >= 10 ? String.valueOf(y) : ("0" + y);
//        return x + "-" + strY + "-01";
//    }
//
//
//    /**
//     * 比较间隔时间不能大于参数
//     *
//     * @param beginDate
//     * @param endDate
//     * @return Date
//     * @author luyang
//     */
//    public static boolean getMonthCompare(Date beginDate, Date endDate, int maxMonth) {
//        boolean flag = false;
//        // 获取cBeginDate maxMonth 月之后的日期
//        Date date = getTimeByMonth(beginDate, maxMonth);
//        if (endDate.compareTo(date) > 0) {
//            flag = true;
//        }
//        return flag;
//    }
//
//
//    /**
//     * 获取前一天日期字符串
//     *
//     * @param date
//     * @return
//     */
//    public static String getPreDateStr(Date date) {
//        String dateStr = null;
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        Date ydate = calendar.getTime();
//        dateStr = DateUtil.format(ydate, "yyyyMMdd");
//        return dateStr;
//    }
//
//
//    /***
//     * 时间日期转化为固定模式
//     *
//     * @param yyyyMMddHHmmss
//     * @return
//     */
//
//    public static Date getDate(String yyyyMMddHHmmss) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        try {
//            return sdf.parse(yyyyMMddHHmmss);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//    /**
//     * 计算两个日期之差
//     *
//     * @param nowDate
//     *            (大)
//     * @param passDate
//     *            (小)
//     * @return 日期相差天数
//     */
//    public static long getTimeMinus(Date nowDate, Date passDate) {
//        long a = (nowDate.getTime() - passDate.getTime())
//                / (1000 * 60 * 60 * 24);
//        return a;
//    }
//
//
//    public static long getDistanceDate(String startDate, String endDate) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        long num = 0;
//        try {
//            Date strDate = sdf.parse(startDate);
//            Date stpDate = sdf.parse(endDate);
//            num = getTimeMinus(stpDate, strDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return num;
//    }
//
//
//    /**
//     * 日期计算， +/-年数
//     *
//     * @param nowDate
//     * 			当前日期
//     * @param years
//     * 			+/-年数
//     * @return
//     */
//    public static Date getAddYears(Date nowDate, int years) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(nowDate);
//        cal.add(Calendar.YEAR, years);
//        return cal.getTime();
//    }
//
//    /***
//     * 日期计算,获取当前日期至N年后的今天，共计多少天
//     */
//    public static long getYearPassCountDay(Date nowDate, int years) {
//        Date datePass = DateUtils.getAddYears(nowDate, years);
//        long countDay = DateUtils.getTimeMinus(datePass, nowDate);
//        return countDay;
//    }
//
//    public static void main(String[] args) {
//        Date one = DateUtils.parseStrToDate("2020-06-01", "yyyy-MM-dd");
////        Date two = DateUtils.parseStrToDate(DateFormatUtils.getSysISODateForOne(), "yyyy-MM-dd");
//        System.out.println(isEqual(one, two));
//    }
//
//}
