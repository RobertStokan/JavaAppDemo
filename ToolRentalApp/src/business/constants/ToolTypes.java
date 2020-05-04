/**
 * 
 */
package business.constants;

/**
 * Enumerated class to define each tool type and their associated attributes.
 *
 * @author Robert Stokan
 * 
 */
public enum ToolTypes {
	LADDER(ToolPrices.DAILY_CHARGE_LADDER, "Ladder", true, false),
	CHAINSAW(ToolPrices.DAILY_CHARGE_CHAINSAW, "Chainsaw", false, true),
	JACKHAMMER(ToolPrices.DAILY_CHARGE_JACKHAMMER, "Jackhammer", false, false);
	
	private final double charge;              	// the daily rental rate for this tool type.
	private final String name;			      	// The name for this tool type.
	private final boolean chargeWeekend;		// Whether the rental rate is charged on weekends.
	private final boolean chargeHolidy;			// Whether the rental rate is charged on holidays.

	
	/**
	 * @param charge - the daily rental rate.
	 * @param name - name of tool type.
	 * @param chargeWeekend - whether to charge rental rate on weekends.
	 * @param chargeHolidy - whether to charge rental rate on holidays.
	 */
	ToolTypes(double charge, String name, boolean chargeWeekend, boolean chargeHolidy) {
        this.charge = charge;
        this.name = name;
        this.chargeWeekend = chargeWeekend;
        this.chargeHolidy = chargeHolidy;
    }
    
    /**
     * @return
     */
    public double getDailyCharge() {
        return this.charge;
    }

	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the weekendCharge
	 */
	public boolean isWeekendCharge() {
		return this.chargeWeekend;
	}

	/**
	 * @return the holidayCharge
	 */
	public boolean isHolidayCharge() {
		return this.chargeHolidy;
	}
}
