package seleniumfw.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public class JsExecutorImpl implements JsExecutor {
	
	private JavascriptExecutor jse;
	
	public JsExecutorImpl(WebDriver driver) {
		this.jse = (JavascriptExecutor) driver;
	}

	@Override
	public void setValueById(String id, String value) {
		String script = String.format("document.getElementById('%s').value='%s';" , id, value);
		jse.executeScript(script);
	}

	@Override
	public void clickById(String id) {
		String script = String.format("document.getElementById('%s').click;" , id);
		jse.executeScript(script);
	}

	@Override
	public void forceClick(Element element) {
		jse.executeScript("arguments[0].click();", element.getElementSelenium());
	}

	@Override
	public void print() {
		jse.executeScript("javascript:window.print();");
	}

}
