/**
 * 
 */
package services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to test whether a particular date is a holiday.
 * 
 * @author Robert
 *
 */
public class HolidayService {
	
	// List of holidays that fall upon an exact date.
	@SuppressWarnings("serial")
	private final static List<HolidayExactDate> exactDateHolidays = new ArrayList<HolidayExactDate>() { 
		{ 
			// List of exact date holidays can be expanded in future).
			add(new HolidayExactDate(Month.JULY, 4)); 
		}
	};
	
	// List of holidays that fall upon a particular day of the week within a certain range of the month.
	@SuppressWarnings("serial")
	private final static List<HolidayDateRange> dateRangeHolidays = new ArrayList<HolidayDateRange>() { 
		{ 
			// List of date range holidays can be expanded in future).
			add(new HolidayDateRange(1, 7, DayOfWeek.MONDAY, Month.SEPTEMBER)); 
		}
	};
	
	
	/**
	 * This method calculates whether a given date is a holiday.
	 * 
	 * @param month
	 * @param dayOfMonth
	 * @param dayOfWeek
	 * @return
	 */
	public static boolean isHoliday(LocalDate dateToCheck) {
		boolean isHoliday = false;
		
		Month month = dateToCheck.getMonth();
		int dayOfMonth = dateToCheck.getDayOfMonth();
		DayOfWeek dayOfWeek = dateToCheck.getDayOfWeek();
		
		if (dateToCheck.getDayOfWeek() == DayOfWeek.SUNDAY || dateToCheck.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return false;
		}
		
		// Check whether the current date is an exact date holiday
		for (HolidayExactDate exactDate : exactDateHolidays) {
			if ((month == exactDate.getMonth() && dayOfMonth == exactDate.dayOfMonth)) {
				isHoliday = true;
				break;
			}
			else if (dateToCheck.getDayOfWeek() == DayOfWeek.MONDAY) {
				LocalDate previousDate = dateToCheck.minusDays(1);
				
				if ((previousDate.getMonth() == exactDate.getMonth() && previousDate.getDayOfMonth() == exactDate.dayOfMonth)) {
					isHoliday = true;
					break;
				}
			}
			else if (dateToCheck.getDayOfWeek() == DayOfWeek.FRIDAY) {
				LocalDate nextDate = dateToCheck.plusDays(1);
				
				if ((nextDate.getMonth() == exactDate.getMonth() && nextDate.getDayOfMonth() == exactDate.dayOfMonth)) {
					isHoliday = true;
					break;
				}
			}
		}
		
		// If it is not an exact date holiday, check for date range.
		if (!isHoliday) {
			for (HolidayDateRange rangeDate : dateRangeHolidays) {
				if (month == rangeDate.getMonth() && dayOfMonth >= rangeDate.dateRangeMin 
						&& dayOfMonth <= rangeDate.dateRangeMax && dayOfWeek == rangeDate.dayOfWeek) {
					isHoliday = true;
					break;
				}
				else if (dateToCheck.getDayOfWeek() == DayOfWeek.MONDAY) {
					LocalDate previousDate = dateToCheck.minusDays(1);
					
					if (previousDate.getMonth() == rangeDate.getMonth() && previousDate.getDayOfMonth() >= rangeDate.dateRangeMin 
							&& previousDate.getDayOfMonth() <= rangeDate.dateRangeMax && previousDate.getDayOfWeek() == rangeDate.dayOfWeek) {
						isHoliday = true;
						break;
					}
				}
				else if (dateToCheck.getDayOfWeek() == DayOfWeek.FRIDAY) {
					LocalDate nextDate = dateToCheck.plusDays(1);
					
					if (nextDate.getMonth() == rangeDate.getMonth() && nextDate.getDayOfMonth() >= rangeDate.dateRangeMin 
							&& nextDate.getDayOfMonth() <= rangeDate.dateRangeMax && nextDate.getDayOfWeek() == rangeDate.dayOfWeek) {
						isHoliday = true;
						break;
					}
				}
			}
		}
		return isHoliday;
	}
	
	/**
	 * Private inner class to hold holidays that fall on a specific date.
	 * 
	 * @author Robert
	 *
	 */
	static class HolidayExactDate { 
		Month month;
	    int dayOfMonth;
		
		/**
		 * @param monthInt
		 * @param dayOfMonthInt
		 */
		public HolidayExactDate(Month month, int dayOfMonth) {
			super();
			this.month = month;
			this.dayOfMonth = dayOfMonth;
		}
	    
	    /**
		 * @return the monthInt
		 */
		public Month getMonth() {
			return month;
		}

		/**
		 * @return the dayOfMonthInt
		 */
		public int getDayOfMonth() {
			return dayOfMonth;
		}
		
		
	} 
	
	/**
	 * Private inner class to hold holidays that fall on a certain day of the week 
	 * within a certain range of the month.
	 * 
	 * @author Robert
	 *
	 */
	static class HolidayDateRange { 
		int dateRangeMin;
		int dateRangeMax;
		DayOfWeek dayOfWeek;
		Month month;
		
		/**
		 * @param dateRangeMin
		 * @param dateRangeMax
		 * @param dayOfWeek
		 */
		public HolidayDateRange(int dateRangeMin, int dateRangeMax, DayOfWeek dayOfWeek, Month month) {
			super();
			this.dateRangeMin = dateRangeMin;
			this.dateRangeMax = dateRangeMax;
			this.dayOfWeek = dayOfWeek;
			this.month = month;
		}

		/**
		 * @return the dateRangeMin
		 */
		public int getDateRangeMin() {
			return dateRangeMin;
		}

		/**
		 * @return the dateRangeMax
		 */
		public int getDateRangeMax() {
			return dateRangeMax;
		}

		/**
		 * @return the dayOfWeek
		 */
		public DayOfWeek getDayOfWeek() {
			return dayOfWeek;
		}

		/**
		 * @return the month
		 */
		public Month getMonth() {
			return month;
		}
	} 
}
