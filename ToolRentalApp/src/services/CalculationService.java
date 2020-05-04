/**
 * 
 */
package services;

import java.time.LocalDate;

import business.constants.ToolTypes;

import java.time.DayOfWeek;

/**
 * 
 * This class provides methods to perform calculations necessary for the application business logic.
 * 
 * @author Robert Stokan
 *
 */
public class CalculationService {
	
	/**
	 * This method calculates the number of chargeable days based upon the input parameters.
	 * 
	 * @param checkoutDate - The date on which the tool is checked out.
	 * @param rentalDays - The number of days the tool will be rented (beginning the day after checkout).
	 * @param toolRented - The Tool object containing data about the rented tool.
	 * @return the number of chargeable days calculated.
	 */
	public static int getChargeableDays(LocalDate checkoutDate, int rentalDays, ToolTypes toolType) {
		int chargeableDays = 0;
		boolean chargeWeekend = toolType.isWeekendCharge();
		boolean chargeHoliday = toolType.isHolidayCharge();
		
		// Main loop to calculate chargeable days.
		for (int i = 1; i <= rentalDays; i++) {
			
			// Start calculation with day after checkout.
			LocalDate currentDay = checkoutDate.plusDays(i);
			boolean isHoliday = false;
			
			// Is this a holiday?
			int month = currentDay.getMonth().getValue();
			int dayOfMonth = currentDay.getDayOfMonth();
			
			if ((month == 7 && dayOfMonth == 4)) {
				isHoliday = true;
			}
			else if (month == 9 && dayOfMonth <= 7 && currentDay.getDayOfWeek() == DayOfWeek.MONDAY) {
				isHoliday = true;
			}
			
			// Check whether today is a weekend and a holiday.
			if (currentDay.getDayOfWeek() == DayOfWeek.SATURDAY && isHoliday && i > 1) {
				// If not charging holidays, subtract the previous day.
				if (!chargeHoliday)	
					chargeableDays--;
				// If charging weekends, add day.
				if (chargeWeekend)
					chargeableDays++;
			}
			else if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY && isHoliday && i < rentalDays) {
				// If not charging holidays, subtract the next day.
				if (!chargeHoliday)
					chargeableDays--;
				// If charging weekends, add day.
				if (chargeWeekend)
					chargeableDays++;
			}
			else if (isHoliday) {
				if (chargeHoliday)	
					chargeableDays++;
			}
			else if (currentDay.getDayOfWeek() == DayOfWeek.SATURDAY || currentDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
				if (chargeWeekend)
					chargeableDays++;
			}
			else {
				chargeableDays++;
			}
		}
		return chargeableDays;
	}
}
