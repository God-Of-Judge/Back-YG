package com.smart.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(ProjectApplication.class, args);
		URL url = new URL("https://kapi.kakao.com/v2/push/register");
		String postData = "uuid=1234&device_id=0f365b39-c33d-39be-bdfc-74aaf5534470&push_type=fcm"
				+"&push_token=BGqr4j324rXpiysvWVCnzMg7oqVMaaLho_g7W9Xa6ztCTVNiCbhfae5CYfVXOVsKfDbXgHEUNaiS_ENnbnTYT4_ENnbnTYT4";

		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Authorization", "KakaoAK ${cd53e66fb872a3e7d82da33adf65bbae}");

		try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
			dos.writeBytes(postData);
		}

		try (BufferedReader bf = new BufferedReader(new InputStreamReader(
				conn.getInputStream())))
		{
			String line;
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

}
