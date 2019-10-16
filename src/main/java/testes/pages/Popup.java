package testes.pages;

import seleniumfw.selenium.Element;
import seleniumfw.selenium.ElementImpl;
import seleniumfw.selenium.PageImpl;
import seleniumfw.selenium.Selenium;

public class Popup extends PageImpl {

	final String XPATH_BTN_OK = "//button[@class='swal-button swal-button--confirm'][contains(.,'OK')]";
	
	Element btnOk;
	
	public Popup(Selenium selenium) {
		super(selenium);
	}
	
	public void clickOk() {
		this.btnOk = new ElementImpl(this, null, XPATH_BTN_OK);
		this.btnOk.click();
	}
	
}
