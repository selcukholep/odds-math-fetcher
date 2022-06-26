package com.example.oddsmathfetcher.controller;

import com.example.oddsmathfetcher.domain.request.FetchFilterRequest;
import com.example.oddsmathfetcher.domain.service.MatchFetcherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FetcherController {

    final MatchFetcherService service;

    public FetcherController(MatchFetcherService service) {
        this.service = service;
    }

    @GetMapping("/{date}")
    public ResponseEntity<String> fetchForDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date,
            FetchFilterRequest fetchFilterRequest) {
        service.fetchAndPublishMatches(date, fetchFilterRequest);

        return ResponseEntity.ok("OK");
    }
}
