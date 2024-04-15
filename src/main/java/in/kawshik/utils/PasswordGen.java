package in.kawshik.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGen {
	
	 public static String getRandomString() {
	        return getRandomString(8); // Default length is 8
	    }
	
	 public static String getRandomString(int length) {

		    SecureRandom random = new SecureRandom();
		    byte[] bytes = new byte[length];
		    random.nextBytes(bytes);
		    return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes).substring(0, length);

}
		
}
