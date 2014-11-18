package net.xdwonderer.business.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;

public class OcrExtractor implements OcrExtractorInterface {

    @Value("#{businessProperties['tesseract.language.directory']}")
    private String languageFiles;

    @Value("#{businessProperties['tesseract.supported.languages']}")
    private String supportedLanguages;

    @Override
    public String doOcr(File file) throws TesseractException {
        Tesseract tess = Tesseract.getInstance();

        setDataPath(tess);
        setLanguageSupport(tess);

        return  tess.doOCR(file);
    }

    private void setDataPath(Tesseract tess) {
        tess.setDatapath(languageFiles);
    }

    private void setLanguageSupport(Tesseract tess) {
        String[] languages = StringUtils.split(supportedLanguages,",");
        for (String language : languages) {
            tess.setLanguage(language);
        }
    }
}
