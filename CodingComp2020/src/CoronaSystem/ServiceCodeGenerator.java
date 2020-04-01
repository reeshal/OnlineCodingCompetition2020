package CoronaSystem;

import java.security.SecureRandom;

public class ServiceCodeGenerator {
	
	public static String generateServiceCode(){
		int len=6;
		
		// ASCII range - alphanumeric (0-9, s A-Z)
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		// each iteration of loop choose a character randomly from the given ASCII range
		// and append it to StringBuilder instance
		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}
		return sb.toString();
	}
}
