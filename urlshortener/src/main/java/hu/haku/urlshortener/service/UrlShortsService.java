package hu.haku.urlshortener.service;

import hu.haku.urlshortener.model.controller.UrlShorts;
import hu.haku.urlshortener.persistence.model.MDBUrlShorts;
import hu.haku.urlshortener.persistence.repositories.UrlShortRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class UrlShortsService {

    private final UrlShortRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public UrlShorts addShortening(UrlShorts urlShortening){
        return mapper.map(repository.insert(mapper.map(urlShortening, MDBUrlShorts.class)), UrlShorts.class);
    }
}
