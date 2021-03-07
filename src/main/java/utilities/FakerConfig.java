package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	 private Locale locale = new Locale("en");
	 private Faker faker = new Faker(locale);
	 
	 public static FakerConfig getFakerData() {
		 return new FakerConfig();
	 }
	 
	 public String getEmailAddress() {
		 return faker.internet().emailAddress();
	 }
	 public String getMidlletName() {
		 return faker.name().nameWithMiddle();
	 }
	 public String getFirstName() {
		 return faker.name().firstName();
	 }
	 public String getLastName() {
		 return faker.name().lastName();
	 }
	 public String getSSN() {
		 return faker.idNumber().invalid();
	 }
}
