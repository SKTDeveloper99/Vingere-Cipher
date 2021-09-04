package main;

public class MainApp {
	public static void main(String[] args) {
		String message = "Love brings war";
		String key = "VIGENERECIPHER";
		String encrypted = Vingere.encrypt(message, key);
		String decrypted = Vingere.decrypt(encrypted, key);
		System.out.println("Encrypted message is: " + encrypted);
		System.out.println("Decrypted message is: " + decrypted);
	}
}

class Vingere {
	public static String encrypt(String message, String key) { // encrypt process
		String eMessage = ""; //empty first
		message = message.toUpperCase(); // translate everything to upper
		for (int i = 0, j = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				eMessage += ' '; // see white space ? keep going, print it out first
				i++;
			}
			char letter = message.charAt(i);
			eMessage += (char) (((letter - 65) + (key.charAt(j) - 65)) % 26 + 65); // formula to get encryption, plus 65 for the ASCII big letters
			j = ++j % key.length(); // to get the desired position for our cypher key
		}
		return eMessage;
	}

	public static String decrypt(String message, String key) { // encrypt process
		String dMessage = ""; //empty first
		message = message.toUpperCase();// translate everything to upper
		for (int i = 0, j = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				dMessage += ' ';  // see white space ? keep going, print it out first
				i++;
			}
			char letter = message.charAt(i);
			dMessage += (char) ((letter - key.charAt(j) + 26) % 26 + 65); // formula to get encryption, plus 65 for the ASCII big letters
			j = ++j % key.length(); // to get the desired position for our cypher key
		}
		return dMessage; //return message, in string form
	}
}
