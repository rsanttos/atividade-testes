package seleniumfw.selenium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import seleniumfw.utils.ArquivoUtils;

/**
 * 
 * @author Ramon Santos Malaquias (https://rsanttos.github.io/)
 * @email ramonstmalaquias@gmail.com
 *
 */
public class SeleniumImpl implements Selenium {

	private static final String fileDownloadPath = "/home/ramon/dev/sgp/workspace/proplan.robot/arquivos/temp_download/";
	private static final String tempPath = "arquivos/temp_download";
	private static final String pathFirefoxDriver = "/home/ramon/dev/drivers/geckodriver-v0.25.0-linux64/geckodriver";
	private static final String pathChromeDriver = "/home/sigsaude/dev/drivers/chromedriver_linux64/chromedriver";
	// private static final String pathChromeDriver =
	// "/home/sig_saude/dev/drivers/chromedriver";
	// private static final String pathFirefoxDriver =
	// "/home/ramonsantos/dev/drivers/geckodriver";

	private WebDriver driver;

	public SeleniumImpl() {
	}

	public WebDriver intializeFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", pathFirefoxDriver);
		DesiredCapabilities handlSSLErr = DesiredCapabilities.firefox();
		handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return new FirefoxDriver(handlSSLErr);
	}

	public WebDriver initializePhantomJsDriver() {
		return null;
	}

	public void closeDriver() {
	}

	@Override
	public WebDriver getDriver() {
		if (this.driver == null) {
			this.driver = intializeChromeDriver();
			this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		return this.driver;
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public List<WebElement> findElementsByTagName(String tagName) {
		return this.driver.findElements(By.tagName(tagName));
	}

	@Override
	public void goToWindow(int index) {
		List<String> aux = new ArrayList<String>(this.driver.getWindowHandles());

		String windowName = aux.get(index);

		this.driver.switchTo().window(windowName);
	}

	@Override
	public WebDriver intializeChromeDriver() {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);

		Map<String, Object> prefsMap = new HashMap<String, Object>();
		//prefsMap.put("profile.default_content_settings.popups", 0);
		prefsMap.put("download.default_directory", fileDownloadPath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefsMap);
		options.addArguments("disable-infobars");
		options.addArguments("--print-to-pdf");

		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	@Override
	public void printPageAsPdf() throws IOException, DocumentException {
		tirarPrint(driver);
	}

	/**
	 * Método para tirar print das páginas
	 * 
	 * @param driver
	 * @param processo
	 * @throws IOException
	 */
	private void tirarPrint(WebDriver driver) throws IOException {
		// File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat formt = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss"); // formato da data
		Date date = new Date();

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		String pngFile = String.format("%s/arquivo-%s.png", tempPath, formt.format(date));
		String pdfFile = String.format("%s/arquivo-%s.pdf", tempPath, formt.format(date));
		File scrFile = new File(pngFile);
		ImageIO.write(screenshot.getImage(), "PNG", scrFile);

		// Pinta o fundo transparente de branco
		BufferedImage orig = ImageIO.read(scrFile);
		BufferedImage print = removerTransparencia(orig, scrFile);

		// Salva o print no caminho
		String caminhoProccessFolder = String.format(tempPath);
		ArquivoUtils.createFolder(caminhoProccessFolder);
		String caminhoArquivoPng = pngFile;
		String caminhoArquivoPdf = pdfFile;
		File outputfilePng = new File(caminhoArquivoPng);
		ImageIO.write(print, "png", outputfilePng);
		try {
			ArquivoUtils.generatePDFFromImage(caminhoArquivoPng, caminhoArquivoPdf);
			ArquivoUtils.deleteFile(caminhoArquivoPng);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Pinta o fundo transparente da imagem de branco
	 * 
	 * @param image
	 * @param scrFile
	 * @return
	 * @throws IOException
	 */
	private BufferedImage removerTransparencia(BufferedImage image, File scrFile) throws IOException {
		BufferedImage print = ImageIO.read(scrFile);

		Graphics2D g2d = print.createGraphics();
		g2d.setColor(Color.WHITE); // Cor escolhida
		g2d.fillRect(0, 0, print.getWidth(), print.getHeight());
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return print;
	}

	private void generatePDFFromHTML(String filename) throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("arquivos/html.pdf"));
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
		document.close();
	}

	@Override
	public void back() {
		this.driver.navigate().back();
	}

	@Override
	public void maximize() {
		this.driver.manage().window().maximize();
	}
}
