package net.xdwonderer.business.parsers;

import net.xdwonderer.business.domain.ReceiptEntryInterface;
import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;

public class TestReceiptEntryExtractor {

    @Test
    public void testParser() {
        //Given
        String rawData = "\n\nHoll\u00e6nderdybet 3\n2300 K\u00f8benhavn S\n\nR\u00d8D PEBER 12,00\nMUZZARELLA 5,50\nNEKTARIN 1KG 10,00\nEGELYKKE LETM\u00c6LK 6,50\nGULER\u00d8DDER 9,00\nROMAINE MINI 12,00\nHJORTESPEGP\u00d8 10,95\nCHUNKY BAR 6,95\nTOTAL 72,90\n\nBETALINGSKORT 72,90\n\nMOMS UDG\u00d8R 14,58\n\nDu blev betjent af;\nIsabell 656 19\nButik 7709 M0MSNR 35$\u00c9\u00c5$\u00a76\n\nKIG FORBI www`\noe www.Joa_N\u00c9\u00a7lg\u00fcb2K\n\n8~22 ALLE uGENS 7 h,\u00f1_\n\n";
        String nameRegEx = "^[\\x20-\\xFF]+(?=(\\s\\d+,\\d+))";
        String priceRegEx = "\\s\\d+,\\d\\d$";

        ReceiptEntryExtractor extractor = new ReceiptEntryExtractor();
        extractor.setNameRegEx(nameRegEx);
        extractor.setPriceRegEx(priceRegEx);

        //When
        Set<ReceiptEntryInterface> entries = extractor.extract(rawData);

        //Then
        assertThat(entries).isNotNull().isNotEmpty();
    }
}
