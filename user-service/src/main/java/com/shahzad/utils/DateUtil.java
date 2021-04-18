package com.shahzad.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @since Dec 17, 2020
 * @author shahzad.hussain
 */
public final class DateUtil {

	public static final String DD_MM_YYYY = "dd-MM-yyyy";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String HH_MM = "HH:mm";
	public static final String HH_MM_AM_PM = "hh.mmaa";

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";

	public static LocalDate getLocalDateFromDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDate parseLocalDate(String date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(date, formatter);

	}

	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatLocalDate(LocalDate date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return formatter.format(date);
	}

	public static Date getDateFromMillis(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public static Date getDateBeforeXDays(Date date, int getDateBeforeXDays) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -getDateBeforeXDays);
		return c.getTime();
	}

	public static LocalDate getLocalDateFromInstant(Integer emiDay) {
		return LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), emiDay).plusMonths(1);
	}

	public static Date getDateAfterXDays(Date date, int getDateBeforeXDays) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getDateBeforeXDays);
		return c.getTime();
	}

	public static String getDateAfterXDays(Integer getDateAfterXDays, String format) {
		if (getDateAfterXDays == null)
			getDateAfterXDays = 0;
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, getDateAfterXDays);
		return format(c.getTime(), format);
	}

	public static String getLocalDateToString(LocalDate localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static String getLocalDateTimeToString(LocalDateTime localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static String getDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static long getDaysFromLocalDatedifference(LocalDate fromDate, LocalDate toDate) {
		try {
			return ChronoUnit.DAYS.between(fromDate, toDate) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getLocalTimeToString(LocalTime time, String formatter) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formatter);
		return time.format(format);
	}

	public static LocalTime getStringToLocalTime(String time, String formatter) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formatter);
		return LocalTime.parse(time, format);
	}

	public static boolean isSecondOrFourthSaturday(LocalDate date) {
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		int weekNumber = date.get(weekFields.weekOfMonth());
		if (weekNumber == 1 || weekNumber == 3) {
			return true;
		}
		return false;
	}

	public static Date instantToDate(Instant instant) {
		return Date.from(instant);
	}

	public static String getDateFromInstant(Instant instantDate, String format) {
		LocalDateTime datetime = LocalDateTime.ofInstant(instantDate, ZoneOffset.UTC);
		return DateTimeFormatter.ofPattern(format).format(datetime);
	}

	public static long daysBetweenDates(Date fromDate, Date toDate) {
		Instant startDate = fromDate.toInstant();
		Instant endDate = toDate.toInstant();
		return ChronoUnit.DAYS.between(startDate, endDate);
	}

	public static long daysBetweenDates(LocalDate d1, LocalDate d2) {
		long diff = ChronoUnit.DAYS.between(d1, d2);
		return diff;
	}

	public static Date getLastDateOfMonth(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date lastDayOfMonth = calendar.getTime();
		return lastDayOfMonth;
	}

	public static Date getFirstDateOfNextMonth(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	public static Date getFirstDateOfPreviousMonth(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	public static Date getLastDateOfPreviousMonth(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		aCalendar.add(Calendar.MONTH, -1);
		aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return aCalendar.getTime();
	}

	public static Date getXDaysDateOfPreviousMonth(Date date, int days) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Date getXDaysDateOfMonth(Date date, int days) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static long getDaysFromDatedifference(Date startDate, Date endDate) {
		try {
			return ChronoUnit.DAYS.between(getLocalDateFromDate(startDate), getLocalDateFromDate(endDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
