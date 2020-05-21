package services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class HolidayServiceTest {
	
	/**
	 * Testing the calculation of holidays.
	 */
	@Test
	void testIsHoliday() {
		
		// Testing "exact date" holiday.
		assertTrue(HolidayService.isHoliday(LocalDate.of(2015, Month.JULY, 4)), "Holiday calculation incorrect.");
		// Testing "specific day of week within range" holiday.
		assertTrue(HolidayService.isHoliday(LocalDate.of(2015, Month.SEPTEMBER, 7)), "Holiday calculation incorrect");
		// Testing day that is not a holiday.
		assertFalse(HolidayService.isHoliday(LocalDate.of(2015, Month.SEPTEMBER, 6)), "Holiday calculation incorrect");
	}
}
