package net.xdwonderer.business.ocr;

public class OcrTransformationResult implements OcrTransformationResultInterface {
    private final String content;

    public OcrTransformationResult() {
        this.content = "No Data";
    }

    public OcrTransformationResult(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
