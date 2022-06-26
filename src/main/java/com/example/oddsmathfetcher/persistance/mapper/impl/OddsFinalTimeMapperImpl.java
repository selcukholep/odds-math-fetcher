package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.persistance.entity.odds.OddsFinalTime;
import com.example.oddsmathfetcher.persistance.factory.OddsFinalTimeMapperFactory;
import com.example.oddsmathfetcher.domain.dto.OddsDto;
import com.example.oddsmathfetcher.domain.dto.OddsFinalTimeDto;
import com.example.oddsmathfetcher.persistance.entity.odds.finaltime.OddsFinalTimeFull;
import com.example.oddsmathfetcher.persistance.entity.base.Odds;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMatchMapper;
import com.example.oddsmathfetcher.persistance.mapper.OddsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component(value = "c-odds-final-time")
public class OddsFinalTimeMapperImpl extends OddsMapper {

    private BookmakerMatchMapper bookmakerMatchMapper;
    private OddsFinalTimeMapperFactory factory;

    @Autowired
    private void setBookmakerMatchMapper(BookmakerMatchMapper bookmakerMatchMapper) {
        this.bookmakerMatchMapper = bookmakerMatchMapper;
    }

    @Autowired
    public void setOddsFinalTimeMapperFactory(OddsFinalTimeMapperFactory factory) {
        this.factory = factory;
    }

    @Override
    public Odds toEntity(OddsDto dto) {
        if (dto == null) {
            return null;
        }

        if (!(dto instanceof OddsFinalTimeDto)) {
            throw new RuntimeException("Instance must be an OddsFinalTimeDto type.");
        }

        OddsFinalTime oddsFinalTime = factory.getInstance(dto.getBookmakerMatchDto().getOddsType());

        oddsFinalTime.setId(dto.getId());
        oddsFinalTime.setUpdatedDate(dto.getUpdatedDate());
        oddsFinalTime.setAway(((OddsFinalTimeDto) dto).getAway());
        oddsFinalTime.setDraw(((OddsFinalTimeDto) dto).getDraw());
        oddsFinalTime.setHome(((OddsFinalTimeDto) dto).getHome());
        oddsFinalTime.setBookmakerMatch(bookmakerMatchMapper.toEntity(dto.getBookmakerMatchDto()));

        return oddsFinalTime;
    }

    @Override
    public OddsDto toDto(Odds entity) {
        if (entity == null) {
            return null;
        }

        if (!(entity instanceof OddsFinalTimeFull)) {
            throw new RuntimeException("Instance must be an OddsFinalTime type.");
        }

        OddsFinalTimeDto oddsFinalTimeDto = new OddsFinalTimeDto();

        oddsFinalTimeDto.setCreatedDate(entity.getCreatedDate());
        oddsFinalTimeDto.setId(entity.getId());
        oddsFinalTimeDto.setUpdatedDate(entity.getUpdatedDate());
        oddsFinalTimeDto.setAway(((OddsFinalTimeFull) entity).getAway());
        oddsFinalTimeDto.setDraw(((OddsFinalTimeFull) entity).getDraw());
        oddsFinalTimeDto.setHome(((OddsFinalTimeFull) entity).getHome());
        oddsFinalTimeDto.setBookmakerMatchDto(bookmakerMatchMapper.toDto(entity.getBookmakerMatch()));
        return oddsFinalTimeDto;
    }

    @Override
    public void mapValues(OddsDto destination, Map<String, Object> map) {

        if (!(destination instanceof OddsFinalTimeDto)) {
            throw new RuntimeException("Instance must be an OddsFinalTimeDto type.");
        }

        ((OddsFinalTimeDto) destination).setHome(Double.parseDouble(map.get("1").toString()));
        ((OddsFinalTimeDto) destination).setDraw(Double.parseDouble(map.get("X").toString()));
        ((OddsFinalTimeDto) destination).setAway(Double.parseDouble(map.get("2").toString()));
    }

    @Override
    public OddsDto instance() {
        return new OddsFinalTimeDto();
    }


    interface DeepLinkConvertable {
        void toDeepLink();
    }

    interface WebURLConvertable {
        void toWebUrl();
    }

    class ProductDetailConverter implements DeepLinkConvertable, WebURLConvertable {

        @Override
        public void toDeepLink() {

        }

        @Override
        public void toWebUrl() {

        }
    }
}
