package seleniumfw.selenium;
/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public interface JsExecutor {
	public void setValueById(String id, String value);
	public void clickById(String id);
	public void forceClick(Element element);
	void print();
}
