package valueobjects;

import java.util.regex.Pattern;

public final class Email {
	
	private final String _email;
	public static final String PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	
	public Email(String email) {
		assert isValid(email) : "Given email is not from the correct format";
		_email = email;
	}
	
	
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
	
	public String get_email() {
		return _email;
	}
}
