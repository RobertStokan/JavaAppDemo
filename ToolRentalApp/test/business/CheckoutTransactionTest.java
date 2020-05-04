package business;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import business.constants.ToolCodes;
import domain.RentalAgreement;

class CheckoutTransactionTest {
	
	/**
	 * Test scenario 1: invalid discount % of 101.
	 */
	@Test
	void testGenerateRentalTransaction1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new CheckoutTransaction(ToolCodes.JAKR, 5, LocalDate.of(2015, 9, 15), 101);
		});
	}

	/**
	 * Test scenario 2: Ladder rented for time period including holiday weekend.
	 * Discount 10%
	 */
	@Test
	void testGenerateRentalTransaction2() {
		CheckoutTransaction trans = new CheckoutTransaction(ToolCodes.LADW, 3, LocalDate.of(2020, 7, 2), 10);
		RentalAgreement agreement = trans.generateRentalAgreement();
		
		assertAll("Rental Agreement",
				() -> assertEquals(LocalDate.of(2020, 7, 5), agreement.getDueDate(), "Due date incorrect."),
				() -> assertEquals(2, agreement.getChargeDays(), "Chargeable days incorrect."),
				() -> assertEquals(3.98, agreement.getPreDiscountCharge(), "Pre-discount amount incorrect."),
				() -> assertEquals(0.40, agreement.getDiscountAmount(), "Discount amount incorrect."),
				() -> assertEquals(3.58, agreement.getFinalCharge(), "Final charge amount incorrect.")
		);
	}
	
	/**
	 * Test scenario 3: Chainsaw rented for time period including holiday weekend.
	 * Discount: 25%
	 */
	@Test
	void testGenerateRentalTransaction3() {
		CheckoutTransaction trans = new CheckoutTransaction(ToolCodes.CHNS, 5, LocalDate.of(2015, 7, 2), 25);
		RentalAgreement agreement = trans.generateRentalAgreement();
		
		assertAll("Rental Agreement",
				() -> assertEquals(LocalDate.of(2015, 7, 7), agreement.getDueDate(), "Due date incorrect."),
				() -> assertEquals(3, agreement.getChargeDays(), "Chargeable days incorrect."),
				() -> assertEquals(4.47, agreement.getPreDiscountCharge(), "Pre-discount amount incorrect."),
				() -> assertEquals(1.12, agreement.getDiscountAmount(), "Discount amount incorrect."),
				() -> assertEquals(3.35, agreement.getFinalCharge(), "Final charge amount incorrect.")
		);
	}
	
	/**
	 * Test scenario 4: Jackhammer rented for time period including weekend followed by Monday holiday.
	 * Discount: 0%
	 */
	@Test
	void testGenerateRentalTransaction4() {
		CheckoutTransaction trans = new CheckoutTransaction(ToolCodes.JAKD, 6, LocalDate.of(2015, 9, 3), 0);
		RentalAgreement agreement = trans.generateRentalAgreement();
		
		assertAll("Rental Agreement",
				() -> assertEquals(LocalDate.of(2015, 9, 9), agreement.getDueDate(), "Due date incorrect."),
				() -> assertEquals(3, agreement.getChargeDays(), "Chargeable days incorrect."),
				() -> assertEquals(8.97, agreement.getPreDiscountCharge(), "Pre-discount amount incorrect."),
				() -> assertEquals(0.00, agreement.getDiscountAmount(), "Discount amount incorrect."),
				() -> assertEquals(8.97, agreement.getFinalCharge(), "Final charge amount incorrect.")
		);
	}
	
	/**
	 * Test scenario 5: Jackhammer rented for time period including holiday weekend through following Saturday.
	 * Discount: 0%
	 */
	@Test
	void testGenerateRentalTransaction5() {
		CheckoutTransaction trans = new CheckoutTransaction(ToolCodes.JAKR, 9, LocalDate.of(2015, 7, 2), 0);
		RentalAgreement agreement = trans.generateRentalAgreement();
		
		assertAll("Rental Agreement",
				() -> assertEquals(LocalDate.of(2015, 7, 11), agreement.getDueDate(), "Due date incorrect."),
				() -> assertEquals(5, agreement.getChargeDays(), "Chargeable days incorrect."),
				() -> assertEquals(14.95, agreement.getPreDiscountCharge(), "Pre-discount amount incorrect."),
				() -> assertEquals(0.00, agreement.getDiscountAmount(), "Discount amount incorrect."),
				() -> assertEquals(14.95, agreement.getFinalCharge(), "Final charge amount incorrect.")
		);
	}
	
	/**
	 * Test scenario 6: Jackhammer rented for time period including holiday weekend.
	 * Discount: 50%
	 */
	@Test
	void testGenerateRentalTransaction6() {
		CheckoutTransaction trans = new CheckoutTransaction(ToolCodes.JAKR, 4, LocalDate.of(2020, 7, 2), 50);
		RentalAgreement agreement = trans.generateRentalAgreement();
		
		assertAll("Rental Agreement",
				() -> assertEquals(LocalDate.of(2020, 7, 6), agreement.getDueDate(), "Due date incorrect."),
				() -> assertEquals(1, agreement.getChargeDays(), "Chargeable days incorrect."),
				() -> assertEquals(2.99, agreement.getPreDiscountCharge(), "Pre-discount amount incorrect."),
				() -> assertEquals(1.50, agreement.getDiscountAmount(), "Discount amount incorrect."),
				() -> assertEquals(1.49, agreement.getFinalCharge(), "Final charge amount incorrect.")
		);
	}
}
