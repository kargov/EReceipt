package net.xdwonderer.mobile.server.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.xdwonderer.business.domain.NameInterface;
import net.xdwonderer.business.domain.PriceInterface;
import net.xdwonderer.business.domain.ReceiptEntryInterface;
import net.xdwonderer.business.domain.ReceiptInterface;
import net.xdwonderer.business.ocr.OcrTransformationResultInterface;

public class MobileJsonModule extends SimpleModule {
        private static final long serialVersionUID = 1L;
        private static final Version VERSION = VersionUtil.parseVersion("1.0.0", "net.xdwonderer","");

        public MobileJsonModule() {
        super(VERSION);

		/*
         * MIX INS
		 */
        setMixInAnnotation(ReceiptInterface.class, ReceiptMixIns.ReceiptMixIn.class);
        setMixInAnnotation(ReceiptEntryInterface.class, ReceiptMixIns.ReceiptEntryMixIn.class);
        setMixInAnnotation(NameInterface.class, ReceiptMixIns.NameMixIn.class);
        setMixInAnnotation(PriceInterface.class, ReceiptMixIns.PriceMixIn.class);

        setMixInAnnotation(OcrTransformationResultInterface.class, OcrMixIns.OcrTransformationResultMixIn.class);
    }
}