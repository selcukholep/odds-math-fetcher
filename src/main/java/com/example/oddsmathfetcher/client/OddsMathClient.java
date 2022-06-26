package com.example.oddsmathfetcher.client;

import com.example.oddsmathfetcher.client.raw.RawEventsByDay;
import com.example.oddsmathfetcher.client.raw.RawMatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "odds-math", url = "https://oddsmath.com", configuration = FeignConfiguration.class)
public interface OddsMathClient {

    @GetMapping("/api/v1/events-by-day.json?language=en&country_code=TR&timezone=Europe/Istanbul")
    RawEventsByDay getEventsByDay(
            @RequestParam("day") String day
    );

    @GetMapping("/api/v1/live-odds.json?language=en&country_code=TR&include_exchanges=1")
    RawMatch getEvent(
            @RequestParam("event_id") int id,
            @RequestParam("cat_id") int category
    );
    @GetMapping("/api/v1/live-odds.json?language=en&country_code=TR&include_exchanges=1")
    String getEventString(
            @RequestParam("event_id") int id,
            @RequestParam("cat_id") int category
    );
}
