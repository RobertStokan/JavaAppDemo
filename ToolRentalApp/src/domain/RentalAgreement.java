/**
 * 
 */
package domain;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import business.constants.ToolCodes;
import business.constants.ToolTypes;

/**
 * This is an entity class which holds the details of tool rental transactions.
 * 
 * @author Robert Stokan
 *
 */
public class RentalAgreement {
	
	private ToolCodes toolCode;
	private ToolTypes toolType;
	private String toolBrand;
	private int rentalDays;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private double dailyRentalCharge;
	private int chargeDays;
	private double preDiscountCharge;
	private int discountPercent;
	private double discountAmount;
	private double finalCharge;

	/**
	 * Default constructor
	 */
	public RentalAgreement() {
	}

	/**
	 * @return the toolCode
	 */
	public ToolCodes getToolCode() {
		return toolCode;
	}

	/**
	 * @param toolCode the toolCode to set
	 */
	public void setToolCode(ToolCodes toolCode) {
		this.toolCode = toolCode;
	}

	/**
	 * @return the toolType
	 */
	public ToolTypes getToolType() {
		return toolType;
	}
	
	/**
	 * @param toolType the toolType to set
	 */
	public void setToolType(ToolTypes toolType) {
		this.toolType = toolType;
	}
	
	/**
	 * @return the toolBrand
	 */
	public String getToolBrand() {
		return toolBrand;
	}

	/**
	 * @param toolBrand the toolBrand to set
	 */
	public void setToolBrand(String toolBrand) {
		this.toolBrand = toolBrand;
	}

	/**
	 * @return the rentalDays
	 */
	public int getRentalDays() {
		return rentalDays;
	}

	/**
	 * @param rentalDays the rentalDays to set
	 */
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	/**
	 * @return the checkOutDate
	 */
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the dueDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the dailyRentalCharge
	 */
	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	/**
	 * @param dailyRentalCharge the dailyRentalCharge to set
	 */
	public void setDailyRentalCharge(double dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}

	/**
	 * @return the chargeDays
	 */
	public int getChargeDays() {
		return chargeDays;
	}

	/**
	 * @param chargeDays the chargeDays to set
	 */
	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}

	/**
	 * @return the preDiscountCharge
	 */
	public double getPreDiscountCharge() {
		return preDiscountCharge;
	}

	/**
	 * @param preDiscountCharge the preDiscountCharge to set
	 */
	public void setPreDiscountCharge(double preDiscountCharge) {
		this.preDiscountCharge = preDiscountCharge;
	}

	/**
	 * @return the discountPercent
	 */
	public int getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * @param discountPercent the discountPercent to set
	 */
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	/**
	 * @return the finalCharge
	 */
	public double getFinalCharge() {
		return finalCharge;
	}

	/**
	 * @param finalCharge the finalCharge to set
	 */
	public void setFinalCharge(double finalCharge) {
		this.finalCharge = finalCharge;
	}
	
	/**
	 * Overridden toString() method for formatting the rental agreement data to display in the checkout transaction.
	 */
	@Override
	public String toString() {
		// Formatters for printing the agreement details to the console.
		NumberFormat us = NumberFormat.getCurrencyInstance();
		NumberFormat per = NumberFormat.getPercentInstance();
		DateTimeFormatter t = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		// Rental agreement details formatted for display.
		return "Rental Agreement: \nTool code: " + toolCode + "\nTool type: " + toolType.getName() + "\nTool brand: " + toolBrand
				+ "\nRental days: " + rentalDays + "\nCheckout date: " + t.format(checkOutDate) + "\nDue date: " + t.format(dueDate)
				+ "\nDaily rental charge: " + us.format(dailyRentalCharge) + "\nCharge days: " + chargeDays + "\nPre-Discount charge: "
				+ us.format(preDiscountCharge) + "\nDiscount percent: " + per.format(discountPercent / 100.00) + "\nDiscount amount: " 
				+ us.format(discountAmount) + "\nFinal charge: " + us.format(finalCharge) + "\n";
	}
}
