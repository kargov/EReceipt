package net.xdwonderer.mobile.server.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.xdwonderer.business.domain.NameInterface;
import net.xdwonderer.business.domain.PriceInterface;
import net.xdwonderer.business.domain.ReceiptEntryInterface;
import net.xdwonderer.business.domain.ReceiptInterface;

import java.util.Set;

public class ReceiptMixIns {

    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
    public abstract class ReceiptMixIn implements ReceiptInterface {

        @Override
        @JsonProperty
        public abstract Set<ReceiptEntryInterface> getEntries();

    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
    public abstract class ReceiptEntryMixIn implements ReceiptEntryInterface {
        @Override
        @JsonProperty
        public abstract NameInterface getName();

        @Override
        @JsonProperty
        public abstract PriceInterface getPrice();
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
    public abstract class PriceMixIn implements PriceInterface {

        @Override
        @JsonProperty
        public abstract String getPrice();

    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
    public abstract class NameMixIn implements NameInterface {

        @Override
        @JsonProperty
        public abstract String getName();
    }


}
