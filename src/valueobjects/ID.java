package valueobjects;

import java.util.regex.Pattern;

//TODO: Change ID such that an ID is number between 1-9999. AccountManager should keep track of all IDs available
/**
 * With an ID, every created account is clearly identifiable
 * Every ID is of the shape of an UUID
 */
public final class ID {
	
	private final String _id;
	//TODO: Test for this Regex
	private static final String PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
	
	/**
	 * Instantiates the ID object with the given ID
	 * 
	 * @param id A valid ID
	 * @require isValid(id)
	 */
	public ID (String id) {
		assert isValid(id) : "given ID is not from the correct format";
		_id = id;
	}
	
	/**
	 * Checks if the given ID is of the correct format.
	 * 
	 * @param id
	 * @return true, if the given ID matches the format. false, else
	 */
	public static boolean isValid(String id) {
		return Pattern.compile(PATTERN).matcher(id).matches();
	}

	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof ID) {
			ID compare_id = (ID) obj;
			result = (this.get_id() == compare_id.get_id());
		}
		return result;
	}
	
	/**
	 * Getter for the ID
	 * @return the ID
	 */
	public String get_id() {
		return _id;
	}
}
