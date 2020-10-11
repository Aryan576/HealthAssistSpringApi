package com.service;

import org.springframework.stereotype.Service;

@Service
public class OtpService {
	final static int otpLength = 5;

	public String generateOtp() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(otpLength);

		for (int i = 0; i < otpLength; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();

	}

}
