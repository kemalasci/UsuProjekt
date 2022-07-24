package utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.InformationClass;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfClass extends InformationClass {
    protected WebDriver driver;
    private WebDriverWait wait;

    private void setUpDriver() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);

        if (Config.maximized) {
            driver.manage().window().maximize();
        }


    }


    public void verifyContentInPDf( String url, String text) throws InterruptedException {
        //specify the url of the pdf file
        setUpDriver();
        driver.get(url);

        try {
            String pdfContent = readPdfContent(url);
            Assert.assertTrue(pdfContent.contains(text));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
Thread.sleep(4000);
}

    public static  String readPdfContent(String url) throws IOException {

        URL pdfUrl = new URL(url);
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        int numberOfPages = getPageCount(doc);

        System.out.println("The total number of pages "+numberOfPages);

        String content = new PDFTextStripper().getText(doc);
        doc.close();

        return content;
    }

    public static int getPageCount(PDDocument doc) {
        //get the total number of pages in the pdf document
        int pageCount = doc.getNumberOfPages();
       String d= String.valueOf(doc.getDocumentInformation());
        return pageCount;

    }





}
