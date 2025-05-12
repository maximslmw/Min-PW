package services;

import java.util.HashMap;
import java.util.Map;

import entities.Account;
import entities.Email;
import valueobjects.ID;
import java.util.UUID;


/**
 * An AccountManager is a single instance, which responsible for creating, editing or deleting  accounts, 
 * notifying the database service to write or read from the database. 
 */
public class AccountManager {
	
	private static AccountManager _instance = null;
	
	private final Map<Account, ID> ACCOUNT_TO_ID = new HashMap<Account, ID>();
	
	/**
	 * private constructor for AccountManager to ensure that only one instance will be created.
	 */
	private AccountManager() {
		
	}
	
	public static AccountManager get_instance() {
		
		if (_instance == null) {
			_instance = new AccountManager();
		}
		return _instance;
	}
	
	public void add_account(String name, String email, String plattform) {
		assert email != null : "Null object not allowed";
		assert name != null : "Null object not allowed";
		assert plattform != null : "Null object not allowed";
		
		ID id = new ID(create_id());
		
		Email userEmail = new Email(email);
		Account account = new Account(name, userEmail, plattform);
		
		ACCOUNT_TO_ID.put(account, id);
	}
	
	private static String create_id() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

		return uuidAsString;
	}
	
	public ID get_id(Account account) {
		return ACCOUNT_TO_ID.get(account);
	}
	
	public static void remove_account(Account account) {
		
	}
}
