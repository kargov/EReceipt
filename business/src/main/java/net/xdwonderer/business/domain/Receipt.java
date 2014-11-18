package net.xdwonderer.business.domain;

import java.util.Set;

public class Receipt implements ReceiptInterface {

    private Set<ReceiptEntryInterface> entries;

    public Set<ReceiptEntryInterface> getEntries() {
        return entries;
    }

    public void setEntries(Set<ReceiptEntryInterface> entries) {
        this.entries = entries;
    }
}
