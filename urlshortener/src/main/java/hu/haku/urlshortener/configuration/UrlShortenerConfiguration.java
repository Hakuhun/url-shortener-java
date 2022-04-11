package hu.haku.urlshortener.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlShortenerConfiguration {

    @Bean
    public ModelMapper createUrlShortenerModelMapper(){
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }

}
