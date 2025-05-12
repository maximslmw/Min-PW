package entities;

import java.util.regex.Pattern;

/**
 * An Email is used to identify the account owner. It exists outside of the account, which is why
 * it is it's own entity.
 */
public final class Email {
	
	private final String _email;
	
	// Regex to check the format of an entered Email
	// TODO: Test for this regex
	private static final String PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	
	/**
	 * Constructs a new Email object if the given email is of the correct format
	 * @param email
	 * @require isValid(email)
	 */
	public Email(String email) {
		assert email != null : "Null object not allowed";
		assert isValid(email) : "Given email is not from the correct format";
		_email = email;
	}
	
	/**
	 * Checks the pattern of the given email
	 * @param email The given email
	 * @return true, if the email is of the correct pattern. false, else
	 */
	public static boolean isValid(String email) {
		return Pattern.compile(PATTERN).matcher(email).matches();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Email) {
			Email compareEmail = (Email) obj;
			result = this.get_email().equals(compareEmail.get_email());
		}
		
		return result;
	}
	
	/**
	 * Getter for Email
	 * @return email
	 */
	public String get_email() {
		return _email;
	}
}
