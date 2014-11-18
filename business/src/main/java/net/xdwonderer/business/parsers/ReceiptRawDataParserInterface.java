package net.xdwonderer.business.parsers;

import net.xdwonderer.business.domain.ReceiptInterface;

public interface ReceiptRawDataParserInterface {

    public ReceiptInterface parse(String rawData);

}
