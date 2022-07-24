package stepdefs;

import io.cucumber.java.en.Given;
import utils.PdfClass;

import static pages.InformationClass.*;

public class PdfControlStepdefs extends PdfClass {
    @Given("pdf kontrol")
    public void pdfKontrol() throws InterruptedException {
        verifyContentInPDf(pdfUrl, pdfKontrolString);
        driver.quit();
    }
}
