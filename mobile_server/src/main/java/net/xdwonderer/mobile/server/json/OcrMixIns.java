package net.xdwonderer.mobile.server.json;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.xdwonderer.business.ocr.OcrTransformationResultInterface;

public class OcrMixIns {

    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
    public abstract class OcrTransformationResultMixIn implements OcrTransformationResultInterface {

        @Override
        @JsonProperty
        public abstract String getContent();

    }
}
