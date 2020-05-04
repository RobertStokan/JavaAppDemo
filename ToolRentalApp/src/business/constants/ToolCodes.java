package business.constants;

/**
 * Enumerated type to hold the available tool codes.
 * 
 * @author Robert Stokan
 * 
 */
public enum ToolCodes {
	LADW(ToolTypes.LADDER, ToolBrands.BRAND_WERNER),
	CHNS(ToolTypes.CHAINSAW, ToolBrands.BRAND_STIHL),
	JAKR(ToolTypes.JACKHAMMER, ToolBrands.BRAND_RIDGID),
	JAKD(ToolTypes.JACKHAMMER, ToolBrands.BRAND_DEWALT);
	
	private final String brand;
	private final ToolTypes toolType;
	
	ToolCodes(ToolTypes toolType, String brand) {
		this.toolType = toolType;
		this.brand = brand;
	}

	/**
	 * @return the toolType
	 */
	public ToolTypes getToolType() {
		return toolType;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
}
