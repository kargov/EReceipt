package net.xdwonderer.business.parsers;

import net.xdwonderer.business.domain.Name;
import net.xdwonderer.business.domain.Price;
import net.xdwonderer.business.domain.ReceiptEntry;
import net.xdwonderer.business.domain.ReceiptEntryInterface;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptEntryExtractor implements ReceiptEntryExtractorInterface {

    @Value("#{businessProperties['receipt.entry.name.regex']}")
    private String nameRegEx;

    @Value("#{businessProperties['receipt.entry.price.regex']}")
    private String priceRegEx;

    @Override
    public Set<ReceiptEntryInterface> extract(String rawData) {
        String[] lines = splitBasedOnNewLine(rawData);
        Pattern receiptEntryPattern = getReceiptEntryPattern();
        return buildReceiptEntries(lines, receiptEntryPattern);
    }

    private Set<ReceiptEntryInterface> buildReceiptEntries(String[] lines, Pattern receiptEntryPattern) {
        Set<ReceiptEntryInterface> entries = new HashSet<>();
        for(String line : lines) {
            Matcher m = receiptEntryPattern.matcher(line);
            while(m.find()) {
                String receiptEntryString = m.group();
                Name name = getName(receiptEntryString);
                Price price = getPrice(receiptEntryString);
                entries.add(new ReceiptEntry(name,price));
            }
        }
        return entries;
    }

    private Price getPrice(String receiptEntryString) {
        Price price = new Price("0");
        Pattern pricePattern = getPricePattern();
        Matcher matcher = pricePattern.matcher(receiptEntryString);
        if(matcher.find()) {
            price =  new Price(matcher.group());
        }
        return price;
    }

    private Name getName(String receiptEntryString){
        Name name = new Name("");
        Pattern pricePattern = getNamePattern();
        Matcher matcher = pricePattern.matcher(receiptEntryString);
        if(matcher.find()) {
            name =  new Name(matcher.group().trim());
        }
        return name;
    }

    private Pattern getReceiptEntryPattern() {
        return Pattern.compile(nameRegEx+priceRegEx);
    }

    private Pattern getPricePattern() {
        return Pattern.compile(priceRegEx);
    }

    private Pattern getNamePattern() {
        return Pattern.compile(nameRegEx);
    }

    private String[] splitBasedOnNewLine(String rawData) {
        String lineSeparator = System.getProperty("line.separator");
        return rawData.split(lineSeparator);
    }

    protected void setPriceRegEx(String priceRegEx) {
        this.priceRegEx = priceRegEx;
    }

    protected void setNameRegEx(String nameRegEx) {
        this.nameRegEx = nameRegEx;
    }
}
