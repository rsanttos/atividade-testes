package seleniumfw.selenium;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public interface Element {
	public void click();
	public void forceClick();
	public void submit();
	public void loadElementSelenium();
	public void loadElementSeleniumById();
	public void loadElementSeleniumByName();
	public void loadElementSeleniumByXPath();
	public void loadElementSeleniumByClassName();
	public WebElement getElementSelenium();
	public void selectTextoVisivel(String texto);
	public Page getPage();
	public String getId();
	public String getText();
	public String getTag();
	public String getClassName();
	public void setClassName(String className);
	public void setPage(Page page);
	public void setId(String id);
	public void setValue(String value);
	public void setValueByJs(String value);
	public List<Element> findChildElementsByTagName(String tagName);
}
