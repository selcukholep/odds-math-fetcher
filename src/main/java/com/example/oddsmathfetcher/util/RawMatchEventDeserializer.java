package com.example.oddsmathfetcher.util;

import com.example.oddsmathfetcher.client.raw.RawMatchBookmaker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RawMatchEventDeserializer extends JsonDeserializer<Map<String, RawMatchBookmaker>> {

    @Override
    public Map<String, RawMatchBookmaker> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        if (text.startsWith("[")) {
            return Collections.emptyMap();
        }

        return deserializationContext.readValue(jsonParser,
                TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, RawMatchBookmaker.class));
    }
}