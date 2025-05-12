package entities;

import valueobjects.ID;

/**
 * An account is created by the user to store name, email and the plattform for one instance.
 * The password is not stored in the account itself, but rather the account's id maps to the password
 */
public class Account {
	
	private String _name;
	private Email _email;
	private String _plattform;
	
	/**
	 * Constructor for the account object.
	 * @param name The name of the account
	 * @param email The email of the account
	 * @param plattform The platform that this account is created for. Doesn't have to be specified by .com, .de etc.
	 */
	public Account(String name, Email email, String plattform) {
		assert name != null : "Empty String not allowed";
		assert email != null : "Empty email not allowed";
		assert plattform != null : "Empty plattform not allowed";
		
		_name = name;
		_email = email;
		_plattform = plattform;
	}
	
	/**
	 * Getters and setters for the fields.
	 */
	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Email get_email() {
		return _email;
	}

	public void set_email(Email _email) {
		this._email = _email;
	}

	public String get_plattform() {
		return _plattform;
	}

	public void set_plattform(String _plattform) {
		this._plattform = _plattform;
	}
	
	
}
