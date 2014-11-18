package net.xdwonderer.mobile.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Overrides standard jackson message converter and stores current message in request scoped bean.
 */
public class JacksonMessageRememberingConverter extends MappingJackson2HttpMessageConverter {
    @Autowired
    private CurrentRequestMessage currentRequest;

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Object result = super.read(type, contextClass, inputMessage);
        currentRequest.setCurrentMessage(result);
        return result;
    }
}
