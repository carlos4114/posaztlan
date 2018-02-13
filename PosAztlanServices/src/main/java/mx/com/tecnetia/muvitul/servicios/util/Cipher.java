package mx.com.tecnetia.muvitul.servicios.util;

import java.security.MessageDigest;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

public class Cipher {

	public static String SHA1Encrypter(String input) throws Exception {
		
		 if (input == null) 
	            throw new BusinessGlobalException("Error al encriptar cadena. El texto no puede ser nulo.");

		String output = "";

		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.reset();

		byte[] buffer = input.getBytes();
		md.update(buffer);

		byte[] digest = md.digest();

		for (int i = 0; i < digest.length; i++) {
			output +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
		}

		return output;

	}
}
