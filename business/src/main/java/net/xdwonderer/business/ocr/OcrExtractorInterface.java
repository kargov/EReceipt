package net.xdwonderer.business.ocr;

import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public interface OcrExtractorInterface {
    String doOcr(File file) throws TesseractException;
}
