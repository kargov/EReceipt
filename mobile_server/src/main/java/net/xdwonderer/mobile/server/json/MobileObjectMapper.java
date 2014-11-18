package net.xdwonderer.mobile.server.json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.util.TimeZone;

public class MobileObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public MobileObjectMapper() {
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        setVisibilityChecker(new VisibilityChecker.Std(JsonAutoDetect.Visibility.NONE));
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        setTimeZone(TimeZone.getDefault());

        registerModule(new MobileJsonModule());
        registerModule(new JodaModule());
    }
}
