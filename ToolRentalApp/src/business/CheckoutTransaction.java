/**
 * 
 */
package business;

import java.time.LocalDate;

import business.constants.ToolCodes;
import domain.RentalAgreement;
import domain.Tool;
import services.CalculationService;
import services.ToolsService;

/**
 * This class provides the business logic to govern the tool rental checkout process.
 * 
 * @author Robert Stokan
 *
 */
public class CheckoutTransaction {
	ToolCodes toolCode;
	int rentalDays;
	LocalDate checkoutDate;
	int discountPercent;

	/**
	 * Constructor
	 */
	public CheckoutTransaction(ToolCodes toolCode, int rentalDays, LocalDate checkoutDate, int discountPercent) {
		
		// Checking for invalid input.
		if (discountPercent > 100 || discountPercent < 0) {
			throw new IllegalArgumentException("Discount % must be between 0 and 100. Percent specified was: " + discountPercent + "%");
		}
		
		if (rentalDays < 1) {
			throw new IllegalArgumentException("Tool must be rented for at least 1 day. Number specified was: " + rentalDays);
		}
		
		this.toolCode = toolCode;
		this.rentalDays = rentalDays;
		this.checkoutDate = checkoutDate;
		this.discountPercent = discountPercent;
	}
	
	/**
	 * This method generates the rental agreement for this CheckoutTransaction.
	 * 
	 * @return rentalAgreement - the RentalAgreement object holding details for this tool rental.
	 */
	public RentalAgreement generateRentalAgreement () {
		// Instantiate new rental agreement object.
		RentalAgreement rentalAgreement = new RentalAgreement();
		
		// Setting fields specified in the checkout request.
		rentalAgreement.setToolCode(this.toolCode);
		rentalAgreement.setRentalDays(this.rentalDays);
		rentalAgreement.setCheckOutDate(this.checkoutDate);
		rentalAgreement.setDiscountPercent(this.discountPercent);
		
		// Setting due date based upon checkout and rental days.
		rentalAgreement.setDueDate(checkoutDate.plusDays(rentalDays));
		
		// Calling service to get tool-specific info
		Tool requestedTool = ToolsService.getTool(toolCode);
		rentalAgreement.setToolType(requestedTool.getToolType());
		rentalAgreement.setToolBrand(requestedTool.getBrand());
		
		// Get charge daily charge upon tool type.
		double dailyRentalRate = requestedTool.getToolType().getDailyCharge();
		rentalAgreement.setDailyRentalCharge(dailyRentalRate);
		
		// Calling calculation service to determine chargeable days.
		int chargeableDays = CalculationService.getChargeableDays(checkoutDate, rentalDays, requestedTool.getToolType());
		rentalAgreement.setChargeDays(chargeableDays);
		
		// Calculating pre-discount amount and rounding.
		double preDiscountAmount = Math.round((chargeableDays * dailyRentalRate) * 100) / 100.0d;
		rentalAgreement.setPreDiscountCharge(preDiscountAmount);
		
		// Calculating discount amount and rounding.
		double discountRate = discountPercent / 100.00;
		double discountAmount = Math.round((preDiscountAmount * discountRate) * 100) / 100.0d;
		rentalAgreement.setDiscountAmount(discountAmount);
		
		// Set final amount.
		double finalCharge = preDiscountAmount - discountAmount;
		rentalAgreement.setFinalCharge(Math.round(finalCharge * 100) / 100.0d);
		
		// Display rental agreement to the console:
		System.out.println(rentalAgreement);
		
		return rentalAgreement;
	}
}
