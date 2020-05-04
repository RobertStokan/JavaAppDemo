/**
 * 
 */
package domain;

import business.constants.ToolCodes;
import business.constants.ToolTypes;

/**
 * This is an entity class which holds the details for an individual Tool object.
 * 
 * @author Robert Stokan
 *
 */
public class Tool {
	/* Instance variables. */
	private final ToolTypes toolType;
	private final String brand;
	private final ToolCodes toolCode;

	/**
	 * Constructor.
	 */
	public Tool(ToolTypes toolType, String brand, ToolCodes toolCode) {
		this.toolType = toolType;
		this.brand = brand;
		this.toolCode = toolCode;
	}

	/***** Getter methods to return individual Tool attributes. *****/
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

	/**
	 * @return the toolCode
	 */
	public ToolCodes getToolCode() {
		return toolCode;
	}
}
