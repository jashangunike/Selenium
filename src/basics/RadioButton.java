package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Dinesh Reddy Radio Button Class :- 1. Check the both male and female
 *         radio butons are, isDisplaye() isEnabled() isSelected() - Status
 * 
 *         Another test is :- f male radio button is displayed then select male
 *         radio button after selection of male radio button - check the status
 *         - if the male radio button is selected or not, incase male radio
 *         button is not selected then select the female radio button and check
 *         the status.
 */
public class RadioButton {

	WebDriver d;

	@Test
	public void radioButton() {

		// Male and Female Radio button WebElements
		By maleRB = By.id("u_0_a");
		By femaleRB = By.id("u_0_9");

		// Radio buttons return result - boolean value (boolean values are - true or
		// false)

		// to know radio buttons are displayed or not
		boolean male_rb;
		boolean female_rb;

		male_rb = d.findElement(maleRB).isDisplayed();
		System.out.println("Male radio button diplayed status :" + male_rb);
		female_rb = d.findElement(femaleRB).isDisplayed();
		System.out.println("Female radio button displayed status :" + female_rb);

		// is Enabled
		boolean male_rb_enable_status = d.findElement(maleRB).isEnabled();
		System.out.println("Male radio button Enable status :" + male_rb_enable_status);
		boolean female_rb_enable_status = d.findElement(femaleRB).isEnabled();
		System.out.println("Female radio button Enable status :" + female_rb_enable_status);

		// is Selected
		boolean male_rb_selected_status = d.findElement(maleRB).isSelected();
		System.out.println("Male radio button Selected status :" + male_rb_selected_status);
		boolean female_rb_selected_status = d.findElement(femaleRB).isSelected();
		System.out.println("Female radio button Selected status :" + female_rb_selected_status);

		/*
		 * Test is : - if male radio button is displayed then select male radio button
		 * after selection of male radio button - check the status - if the male radio
		 * button is selected or not, incase male radio button is not selected then
		 * select the female radio button and check the status
		 */

		if (male_rb == true) {
			d.findElement(maleRB).click();
			// System.out.println("Male radio button clicked and status is
			// :"+d.findElement(maleRB).isSelected());
			boolean after_mrb_sele = d.findElement(maleRB).isSelected();
			System.out.println("Male radio button is clicked and status is :" + after_mrb_sele);

			if (after_mrb_sele == false) {
				d.findElement(femaleRB).click();
				boolean after_mrb_not_sel_frb = d.findElement(femaleRB).isSelected();
				System.out.println("Male radio  button is not clicked");
				System.out.println("Female radio button is clicked and status is :" + after_mrb_not_sel_frb);
			}
		} else {
			System.out.println("Male and female radio buttons are not clicked ");
		}

		// click the male radio button

		/*
		 * if (male_rb == true) { d.findElement(maleRB).click();
		 * System.out.println("Male radio button is clicked - status is :" +
		 * d.findElement(maleRB).isSelected()); } else {
		 * System.out.println("Male radio button is not clicked - status is :" +
		 * d.findElement(maleRB).isSelected()); }
		 */

	}

	@BeforeClass
	public void get_url() {
		d.get("https://www.facebook.com/");

	}

	@BeforeTest
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void close_browser() {
		d.close();
	}

}
