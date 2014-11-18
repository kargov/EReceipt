package net.xdwonderer.mobile.server.controller;


import net.sourceforge.tess4j.TesseractException;
import net.xdwonderer.business.ocr.OcrExtractorInterface;
import net.xdwonderer.business.ocr.OcrTransformationResult;
import net.xdwonderer.business.ocr.OcrTransformationResultInterface;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class OcrController {

    @Autowired
    private OcrExtractorInterface ocrExtractor;

    @Value("#{serverProperties['temp.image.location']}")
    private String tempImageLocation;

    @RequestMapping(value = "/doOcr", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public OcrTransformationResultInterface doOcr(@RequestParam("file") MultipartFile file) {
        OcrTransformationResult result = new OcrTransformationResult();
        if (!file.isEmpty()) {
            try {
                File imageFile = getImageFile(file);
                String data = extractData(imageFile);
                result =  new OcrTransformationResult(data);
            } catch (Exception e) {
                result =  new OcrTransformationResult("You failed to upload " + file.getName() + " => " + e.getMessage());
            }
        }
        return result;
    }

    private String extractData(File imageFile) throws TesseractException {
        return ocrExtractor.doOcr(imageFile);
    }

    private File getImageFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String systemFileSeparator= System.getProperty("file.separator");
        File imageFile = new File(tempImageLocation+systemFileSeparator+file.getOriginalFilename());
        FileUtils.writeByteArrayToFile(imageFile, bytes);
        return imageFile;
    }
}