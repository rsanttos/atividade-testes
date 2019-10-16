package seleniumfw.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public class ElementImpl implements Element {

	private Page page;
	private WebElement eSelenium;
	private String id;
	private String xPath;
	private String name;
	private String className;
	
	public ElementImpl() {
		super();
	}

	public ElementImpl(Page page, WebElement elementSelenium) {
		this.eSelenium = elementSelenium;
		this.page = page;
	}
	
	public ElementImpl(Page page) {
		this.page = page;
	}
	
	public ElementImpl(Page page, String id) {
		this.page = page;
		this.id = id;
	}
	
	public ElementImpl(Page page, String id, String xPath) {
		this.page = page;
		this.id = id;
		this.xPath = xPath;
	}
	
	public ElementImpl(Page page, String id, String xPath, String name) {
		this.page = page;
		this.id = id;
		this.xPath = xPath;
		this.name = name;
	}

	@Override
	public void click() {
		getElementSelenium().click();
	}

	@Override
	public void setValue(String value) {
		getElementSelenium().sendKeys(value);
	}

	@Override
	public Page getPage() {
		return this.page;
	}

	@Override
	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getText() {
		return getElementSelenium().getText();
	}

	@Override
	public String getTag() {
		return getElementSelenium().getTagName();
	}

	@Override
	public void setId(String id) {
		this.id = id;		
	}

	@Override
	public void setValueByJs(String value) {
		this.page.getJsExecutor().setValueById(id, value);
	}

	@Override
	public void loadElementSeleniumById() {
		this.eSelenium = this.page.getSelenium().getDriver().findElement(By.id(id));
	}
	
	@Override
	public void loadElementSeleniumByName() {
		System.out.println(this.page.getSelenium().getDriver().getCurrentUrl());
		this.eSelenium = this.page.getSelenium().getDriver().findElement(By.name(name));
	}
	
	public WebElement getElementSelenium() {
		if(this.eSelenium != null) {
			return this.eSelenium;
		} else {
			loadElementSelenium();
			return this.eSelenium;
		}
	}

	@Override
	public void selectTextoVisivel(String texto) {
		new Select(getElementSelenium()).selectByVisibleText(texto);
	}

	@Override
	public void loadElementSelenium() {
		if(this.id != null && !this.id.isEmpty()) {
			loadElementSeleniumById();
		} else if(this.xPath != null && !this.xPath.isEmpty()) {
			loadElementSeleniumByXPath();
		} else if(this.name != null && !this.name.isEmpty()) {
			loadElementSeleniumByName();
		} else if(this.className != null && !this.className.isEmpty()) {
			loadElementSeleniumByClassName();
		}
	}

	@Override
	public void loadElementSeleniumByXPath() {
		this.eSelenium = this.page.getSelenium().getDriver().findElement(By.xpath(xPath));
	}

	@Override
	public List<Element> findChildElementsByTagName(String tagName) {
		List<Element> elements = new ArrayList<Element>();
		this.getElementSelenium().findElements(By.tagName(tagName)).forEach(we -> {
			elements.add(new ElementImpl(this.page, we));
		});		
		return elements;
	}

	@Override
	public void forceClick() {
		this.page.getJsExecutor().forceClick(this);
	}

	@Override
	public void submit() {
		getElementSelenium().submit();
	}

	public WebElement geteSelenium() {
		return eSelenium;
	}

	public void seteSelenium(WebElement eSelenium) {
		this.eSelenium = eSelenium;
	}

	public String getxPath() {
		return xPath;
	}

	public void setxPath(String xPath) {
		this.xPath = xPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public void loadElementSeleniumByClassName() {
		this.eSelenium = this.page.getSelenium().getDriver().findElement(By.className(className));
	}

}
