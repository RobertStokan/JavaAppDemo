package services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import business.constants.ToolTypes;

class CalculationServiceTest {

	/**
	 * Testing the calculation of chargeable days mirroring the 5 valid scenarios from RentalTransactionTest.
	 */
	@Test
	void testGetChargeableDays() {
		/* Testing several scenarios for calculating chargeable days. */
		
		assertEquals(2, CalculationService.getChargeableDays(LocalDate.of(2020, 7, 2), 3, ToolTypes.LADDER), "Calculated days incorrect.");
		assertEquals(3, CalculationService.getChargeableDays(LocalDate.of(2015, 7, 2), 5, ToolTypes.CHAINSAW), "Calculated days incorrect.");
		assertEquals(3, CalculationService.getChargeableDays(LocalDate.of(2015, 9, 3), 6, ToolTypes.JACKHAMMER), "Calculated days incorrect.");
		assertEquals(5, CalculationService.getChargeableDays(LocalDate.of(2015, 7, 2), 9, ToolTypes.JACKHAMMER), "Calculated days incorrect.");
		assertEquals(1, CalculationService.getChargeableDays(LocalDate.of(2020, 7, 2), 4, ToolTypes.JACKHAMMER), "Calculated days incorrect.");
	}
}
