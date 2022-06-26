package com.example.oddsmathfetcher.persistance.converters;

import com.example.oddsmathfetcher.persistance.type.OddsType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OddsTypeConverter implements AttributeConverter<OddsType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OddsType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.value();
    }

    @Override
    public OddsType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return OddsType.of(dbData);
    }
}
