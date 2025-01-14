package org.example.productservice.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Encrypter {

	private static final String ALGO = "AES";
	// 암호화 키
	private final SecretKey secretKey;

	// 생성자에서 암호화 키를 설정파일로부터 초기화합니다.
	public Encrypter(@Value("${encrypted.secret-key}") String encodedKey) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		this.secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGO);
	}

	// 데이터를 암호화하는 메서드입니다.
	public Optional<String> encrypt(String data) {
		try {
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedData = cipher.doFinal(data.getBytes());
			return Optional.of(Base64.getEncoder().encodeToString(encryptedData));
		} catch (Exception e) {
			log.error("Encryption failed: {}", e.getMessage());
			return Optional.empty();
		}
	}

	// 암호화된 데이터를 복호화하는 메서드입니다.
	public Optional<String> decrypt(String encryptedData) {
		if (encryptedData == null || encryptedData.isEmpty()) {
			log.warn("Empty or null data provided for decryption");
			return Optional.empty();
		}

		try {
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decoded = Base64.getDecoder().decode(encryptedData);
			byte[] decryptedData = cipher.doFinal(decoded);
			return Optional.of(new String(decryptedData, StandardCharsets.UTF_8));
		} catch (Exception e) {
			log.error("Decryption failed: {}", e.getMessage());
			return Optional.empty();
		}
	}


	// 암호화 키를 생성하는 메서드입니다. 백업용 겸 설정파일 내용 업데이트 위한 값 생성 용이에요
	public String generateKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
		keyGen.init(256); // AES-256 암호화 호출할 거에요
		SecretKey generatedKey = keyGen.generateKey();
		String encodedKey = Base64.getEncoder().encodeToString(generatedKey.getEncoded());
		log.debug("Generated Base64 encoded key: {}", encodedKey);
		return encodedKey;
	}
}