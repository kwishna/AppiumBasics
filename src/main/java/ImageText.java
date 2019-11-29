
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageText {

	public static void main(String[] args) {
		
		File textImage  = new File("C:\\Users\\Krishna Singh\\Desktop\\img.png");
		
		ITesseract tess = new Tesseract();
		tess.setDatapath("F:\\Personal\\Locker\\evernote backup\\Study_Documents\\Topics\\Appium\\ImageToTextData");
		tess.setLanguage("eng");
		
		String textFromImage = null;
		
		try {
				textFromImage = tess.doOCR(textImage);
				
			}catch(TesseractException e) {  
				System.err.println(e.getMessage());  
		}  
		
		System.out.println(textFromImage);

		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("E_dd_MMM_yyyy_HH_mm_ss_G")));
		
		File f = new File("E:\\All Jar Files");
		
	}
	

}
