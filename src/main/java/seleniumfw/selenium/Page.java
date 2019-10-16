package seleniumfw.selenium;

import java.util.List;
/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public interface Page {
	public void open();
	public void open(String url);
	public void close();
	public Selenium getSelenium();
	public JsExecutor getJsExecutor();
	public List<Element> findElementsByTagName(String tagName);
}
