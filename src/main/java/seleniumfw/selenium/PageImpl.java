package seleniumfw.selenium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public class PageImpl implements Page {

	protected String url;
	private Selenium selenium;
	private JsExecutor js;

	public PageImpl() {
	}	
	
	public PageImpl(Selenium selenium) {
		this.selenium = selenium;
		this.js = new JsExecutorImpl(this.selenium.getDriver());
	}
	
	public PageImpl(String url, Selenium selenium) {
		this.url = url;
		this.selenium = selenium;
		this.js = new JsExecutorImpl(this.selenium.getDriver());
	}
	
	@Override
	public void open() {
		this.selenium.getDriver().get(url);
	}
	
	@Override
	public void open(String url) {
		this.selenium.getDriver().get(url);
	}
	
	@Override
	public void close() {
		this.selenium.closeDriver();
	}

	@Override
	public Selenium getSelenium() {
		return this.selenium;
	}

	@Override
	public JsExecutor getJsExecutor() {
		return this.js;
	}

	@Override
	public List<Element> findElementsByTagName(String tagName) {
		List<Element> elements = new ArrayList<Element>();
		this.selenium.findElementsByTagName(tagName).forEach(we -> {
			elements.add(new ElementImpl(this, we));
		});
		return elements;
	}
}
