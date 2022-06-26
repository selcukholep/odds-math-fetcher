package com.example.oddsmathfetcher.persistance.mapper;

import com.example.oddsmathfetcher.domain.dto.OddsDto;
import com.example.oddsmathfetcher.persistance.entity.base.Odds;

import java.util.*;

public abstract class OddsMapper implements EntityMapper<OddsDto, Odds> {

    public abstract void mapValues(OddsDto destination, Map<String, Object> map);

    public abstract OddsDto instance();

    @Override
    public List<Odds> toEntity(List<OddsDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Odds> list = new ArrayList<>(dtoList.size());
        for (OddsDto oddsDto : dtoList) {
            list.add(toEntity(oddsDto));
        }

        return list;
    }

    @Override
    public List<OddsDto> toDto(List<Odds> entityList) {
        if (entityList == null) {
            return null;
        }

        List<OddsDto> list = new ArrayList<>(entityList.size());
        for (Odds odds : entityList) {
            list.add(toDto(odds));
        }

        return list;
    }

    @Override
    public Set<OddsDto> toDto(Set<Odds> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<OddsDto> set = new HashSet<>();
        for (Odds odds : entityList) {
            set.add(toDto(odds));
        }

        return set;
    }
}
