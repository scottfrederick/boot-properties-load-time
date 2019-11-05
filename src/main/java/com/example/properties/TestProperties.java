package com.example.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties {
	private List<Container> containers;

	@Data
	private static class Container {
		private String string1;
		private String string2;
		private String string3;
		private String string4;
		private String string5;
		private String string6;
		private String string7;
		private String string8;
		private String string9;
		private String string10;

		private int integer1;
		private int integer2;
		private int integer3;
		private int integer4;
		private int integer5;
		private int integer6;
		private int integer7;
		private int integer8;
		private int integer9;
		private int integer10;

		private List<String> array1;
		private List<String> array2;
		private List<String> array3;
		private List<String> array4;
		private List<String> array5;
		private List<String> array6;
		private List<String> array7;
		private List<String> array8;
		private List<String> array9;
		private List<String> array10;
	}
}
