package net.xdwonderer.business.parsers;

import net.xdwonderer.business.domain.Receipt;
import net.xdwonderer.business.domain.ReceiptEntry;
import net.xdwonderer.business.domain.ReceiptEntryInterface;
import net.xdwonderer.business.domain.ReceiptInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ReceiptRawDataParser implements ReceiptRawDataParserInterface {

    @Autowired
    private ReceiptEntryExtractorInterface entryExtractor;

    @Override
    public ReceiptInterface parse(String rawData) {
        Receipt receipt = new Receipt();
        handleReceiptEntries(rawData, receipt);
       return receipt;
    }

    private void handleReceiptEntries(String rawData, Receipt receipt) {
        Set<ReceiptEntryInterface> entries = entryExtractor.extract(rawData);
        receipt.setEntries(entries);
    }
}
