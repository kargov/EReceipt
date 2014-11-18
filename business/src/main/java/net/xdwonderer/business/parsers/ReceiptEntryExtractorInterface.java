package net.xdwonderer.business.parsers;

import net.xdwonderer.business.domain.ReceiptEntryInterface;

import java.util.Set;

public interface ReceiptEntryExtractorInterface {

    public Set<ReceiptEntryInterface> extract(String rawData);
}
