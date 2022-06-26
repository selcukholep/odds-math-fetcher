package com.example.oddsmathfetcher.domain.service;

import com.example.oddsmathfetcher.domain.request.FetchFilterRequest;

public interface MatchFetcherService {

    void fetchAndPublishMatches(String day, FetchFilterRequest request);
}
