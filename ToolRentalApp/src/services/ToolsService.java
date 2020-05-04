/**
 * 
 */
package services;

import java.util.HashMap;
import java.util.Map;

import business.constants.ToolBrands;
import business.constants.ToolCodes;
import business.constants.ToolTypes;
import domain.Tool;

/**
 * 
 * This class provides methods to retrieve Tool objects for use by the application business logic.
 * 
 * @author Robert Stokan
 * 
 */
public class ToolsService {
	
	/**
	 * HashMap to store the Tool objects currently available for easy retrieval. This can be replaced in the
	 * future by a database implementation or factory to load the implementation.
	 */
	@SuppressWarnings("serial")
	private static final Map<ToolCodes, Tool> avaiableTools = new HashMap<ToolCodes, Tool>() {{
		put(ToolCodes.LADW, new Tool(ToolTypes.LADDER, ToolBrands.BRAND_WERNER, ToolCodes.LADW));
		put(ToolCodes.CHNS, new Tool(ToolTypes.CHAINSAW, ToolBrands.BRAND_STIHL, ToolCodes.CHNS));
		put(ToolCodes.JAKR, new Tool(ToolTypes.JACKHAMMER, ToolBrands.BRAND_RIDGID, ToolCodes.JAKR));
		put(ToolCodes.JAKD, new Tool(ToolTypes.JACKHAMMER, ToolBrands.BRAND_DEWALT, ToolCodes.JAKD));
	}};	
	
	/**
	 * This method retrieves the requested Tool object from the HashMap based upon the unique tool code String.
	 * 
	 * @param toolCode - the unique tool code identifier for each Tool available.
	 * @return Tool - the selected Tool object.
	 */
	public static Tool getTool(ToolCodes toolCode) {
		// Checking for invalid input.
		if (!avaiableTools.containsKey(toolCode)) {
			throw new IllegalArgumentException("Tool code '" + toolCode + "' not found.");
		}
		return avaiableTools.get(toolCode);
	}
}
