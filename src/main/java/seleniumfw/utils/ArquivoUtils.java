package seleniumfw.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class ArquivoUtils {
	public static void createFolder(String path) {
		File diretorio = new File(path);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}
	}

	public static void generatePDFFromImage(String inputFile, String outputFile)
			throws DocumentException, MalformedURLException, IOException {
		float left = 0;
		float right = 0;
		float top = 0;
		float bottom = 0;
		Document document = new Document(PageSize.A4, left, right, top, bottom);
		String output = outputFile;
		FileOutputStream fos = new FileOutputStream(output);
		PdfWriter writer = PdfWriter.getInstance(document, fos);
		writer.open();
		document.open();		
		
		List<String> pages = splitImageInA4(inputFile);
		document.setPageSize(PageSize.A4);
		document.setMargins(0, 0, 20, 10);
		
		for (String page : pages) {
			Image img = Image.getInstance(page);
			//img.setAbsolutePosition(0, 0);
			img.scaleToFit(PageSize.A4);
			document.add(img);
			document.newPage();
		}
		

		document.close();
		writer.close();
	}

	public static void deleteFile(String pathFile) throws DocumentException {
		File file = new File(pathFile);
		if (file.exists()) {
			file.delete();
		} else {
			throw new DocumentException("Não foi possível excluir arquivo -> " + pathFile);
		}
	}

	public static void listFiles(File folder, List<File> files) {
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				listFiles(file, files);
			} else {
				files.add(file);
			}
		}
	}

	public static void writeFile(String fileName, String str) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(str);
		writer.close();
	}
	
	private static List<String> splitImageInA4(String path) throws IOException {
		
		List<String> pieces = new ArrayList<String>();
		
		File scrFile = new File(path);

		// Pixels -> mm
		// 1042 -> 275.695833333
		// 20311 -> 5373.952083333

		// Pinta o fundo transparente de branco
		BufferedImage orig = ImageIO.read(scrFile);

		int tWidth = orig.getWidth();
		int tHeight = orig.getHeight();

		System.out.println("Image Dimension: " + tWidth + "x" + tHeight);
		
		int widthA4 = 1;
		//int heightA4 = 1122;
		int heightA4 = 1400;
		
		int eWidth = tWidth / widthA4;
		int eHeight = (tHeight / heightA4) + 1;
		
		int pages = tHeight/heightA4;

		System.out.println("eWidth: " + eWidth + "| eHeight: " + eHeight);

		int x = 0;
		int y = 0;	
		for(int i = 0 ; i <= pages ; i++) {	
			
			System.out.println(tHeight + " - " + y + " = " + (tHeight - y));
			int hTemp = heightA4;
			if((tHeight - y) < heightA4) {
				hTemp = tHeight - y;
			}
			
			BufferedImage subImg = orig.getSubimage(x, y, eWidth, hTemp);
			String pathPiece = String.format("arquivos/temp/arq%d.png", i);
			File outputfile = new File(pathPiece);
			ImageIO.write(subImg, "png", outputfile);
			pieces.add(pathPiece);
			y += heightA4;	
		}
		
		return pieces;
	}
}
