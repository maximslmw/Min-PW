package valueobjects;



/**
 * With an ID, every created account is clearly identifiable
 * Every ID is 6 characters long, consisting only of numbers in base 10
 */

public final class ID {
	
	private final int _id;
	
	/**
	 * Instantiates the ID object with the given ID
	 * 
	 * @param id A valid ID
	 * @require isValid(id)
	 */
	public ID (int id) {
		assert isValid(id) : "given ID is not from the correct format";
		_id = id;
	}
	
	/**
	 * Checks if the given ID is of the correct format.
	 * 
	 * @param id
	 * @return true, if the given ID matches the format. false, else
	 */
	public static boolean isValid(int id) {
		return String.valueOf(id).matches("[0-9]{6}");
	}

	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof ID) {
			ID compare_id = (ID) obj;
			result = (this.getID() == compare_id.getID());
		}
		return result;
	}
	
	/**
	 * Getter for the ID
	 * @return the ID
	 */
	public int getID() {
		return _id;
	}
}
