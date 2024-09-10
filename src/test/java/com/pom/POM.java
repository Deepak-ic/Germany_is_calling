package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM {
	public POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// user text box
	@FindBy(id = "username")
	private WebElement usrTxtBox;

	// password text box
	@FindBy(id = "password")
	private WebElement passTxtBox;

	// login button
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	// Discord Sign-in button
	@FindBy(xpath = "//*[text()='Sign in with Discord']")
	private WebElement discordBtn;

	// Forget password link
	@FindBy(xpath = "//*[text()='Forgot Password?']")
	private WebElement fgtPass;

	// New Sign in Link
	@FindBy(xpath = "//*[contains(text(), 'New to Germany Is Calling?')]")
	private WebElement sign;

	// Account menu
	@FindBy(xpath = "//*[text()='Deepak Sundaravelu']")
	private WebElement acc;

	// logout button
	@FindBy(linkText = "/common/logout/")
	private WebElement logoutBtn;

	// email alert
	@FindBy(xpath = "//*[text()='Email: This field is required.']")
	private WebElement emailAlert;

	// password alert
	@FindBy(xpath = "//*[text()='Password: This field is required.']")
	private WebElement passAlert;
	
	//username and password incorrect
	@FindBy(xpath = "//*[contains(text(), 'Please enter a correct username and password')]")
	private WebElement inCrtPassUsr;

	
	// Getters for the elements
	public WebElement getInCrtPassUsr() {
		return inCrtPassUsr;
	}

	public WebElement getUsrTxtBox() {
		return usrTxtBox;
	}

	public WebElement getPassTxtBox() {
		return passTxtBox;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getDiscordBtn() {
		return discordBtn;
	}

	public WebElement getFgtPass() {
		return fgtPass;
	}

	public WebElement getSign() {
		return sign;
	}

	public WebElement getAcc() {
		return acc;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getEmailAlert() {
		return emailAlert;
	}

	public WebElement getPassAlert() {
		return passAlert;
	}
}
