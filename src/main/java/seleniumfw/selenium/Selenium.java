package seleniumfw.selenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itextpdf.text.DocumentException;
/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public interface Selenium {
	WebDriver getDriver();
	void goToWindow(int index);
	List<WebElement> findElementsByTagName(String tagName);
	void setDriver(WebDriver driver);
	WebDriver intializeFirefoxDriver();
	WebDriver intializeChromeDriver();
	WebDriver initializePhantomJsDriver();
	void closeDriver();
	void back();
	void printPageAsPdf() throws IOException, DocumentException;
	void maximize();
}
