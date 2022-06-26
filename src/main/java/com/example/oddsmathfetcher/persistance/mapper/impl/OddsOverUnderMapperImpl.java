package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.persistance.entity.odds.OddsOverUnder;
import com.example.oddsmathfetcher.persistance.factory.OddsOverUnderMapperFactory;
import com.example.oddsmathfetcher.domain.dto.OddsDto;
import com.example.oddsmathfetcher.domain.dto.OddsOverUnderDto;
import com.example.oddsmathfetcher.persistance.entity.odds.overunder.OddsOverUnder25Full;
import com.example.oddsmathfetcher.persistance.entity.base.Odds;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMatchMapper;
import com.example.oddsmathfetcher.persistance.mapper.OddsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component(value = "c-odds-over-under")
public class OddsOverUnderMapperImpl extends OddsMapper {

    private BookmakerMatchMapper bookmakerMatchMapper;
    private OddsOverUnderMapperFactory factory;

    @Autowired
    private void setBookmakerMatchMapper(BookmakerMatchMapper bookmakerMatchMapper) {
        this.bookmakerMatchMapper = bookmakerMatchMapper;
    }

    @Autowired
    public void setFactory(OddsOverUnderMapperFactory factory) {
        this.factory = factory;
    }

    @Override
    public Odds toEntity(OddsDto dto) {
        if (dto == null) {
            return null;
        }

        if (!(dto instanceof OddsOverUnderDto)) {
            throw new RuntimeException("Instance must be an OddsOverUnderDto type.");
        }

        OddsOverUnder oddsOverUnder = factory.getInstance(dto.getBookmakerMatchDto().getOddsType());

        oddsOverUnder.setId(dto.getId());
        oddsOverUnder.setUpdatedDate(dto.getUpdatedDate());
        oddsOverUnder.setUnder(((OddsOverUnderDto) dto).getUnder());
        oddsOverUnder.setOver(((OddsOverUnderDto) dto).getOver());
        oddsOverUnder.setBookmakerMatch(bookmakerMatchMapper.toEntity(dto.getBookmakerMatchDto()));
        return oddsOverUnder;
    }

    @Override
    public OddsDto toDto(Odds entity) {
        if (entity == null) {
            return null;
        }

        if (!(entity instanceof OddsOverUnder25Full)) {
            throw new RuntimeException("Instance must be an OddsOverUnder type.");
        }

        OddsOverUnderDto oddsOverUnderDto = new OddsOverUnderDto();

        oddsOverUnderDto.setCreatedDate(entity.getCreatedDate());
        oddsOverUnderDto.setId(entity.getId());
        oddsOverUnderDto.setUpdatedDate(entity.getUpdatedDate());
        oddsOverUnderDto.setUnder(((OddsOverUnder25Full) entity).getUnder());
        oddsOverUnderDto.setOver(((OddsOverUnder25Full) entity).getOver());
        oddsOverUnderDto.setBookmakerMatchDto(bookmakerMatchMapper.toDto(entity.getBookmakerMatch()));
        return oddsOverUnderDto;
    }

    @Override
    public void mapValues(OddsDto destination, Map<String, Object> map) {

        ((OddsOverUnderDto) destination).setUnder(Double.parseDouble(map.get("U").toString()));
        ((OddsOverUnderDto) destination).setOver(Double.parseDouble(map.get("O").toString()));
    }

    @Override
    public OddsDto instance() {
        return new OddsOverUnderDto();
    }
}
