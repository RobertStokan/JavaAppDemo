package services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Month;

import org.junit.jupiter.api.Test;

class HolidayServiceTest {
	
	/**
	 * Testing the calculation of holidays.
	 */
	@Test
	void testIsHoliday() {
		
		assertAll("Rental Agreement", 
				// Testing "exact date" holiday.
				() -> assertTrue(HolidayService.isHoliday(Month.JULY, 4, DayOfWeek.SATURDAY), "Holiday calculation incorrect."),
				// Testing "specific day of week within range" holiday.
				() -> assertTrue(HolidayService.isHoliday(Month.SEPTEMBER, 7, DayOfWeek.MONDAY), "Holiday calculation incorrect"),
				// Testing day that is not a holiday.
				() -> assertFalse(HolidayService.isHoliday(Month.SEPTEMBER, 6, DayOfWeek.SUNDAY), "Holiday calculation incorrect")
		);
	}

}
