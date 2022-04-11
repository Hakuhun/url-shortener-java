package hu.haku.urlshortener.converter;

import hu.haku.urlshortener.model.business.BDRequester;
import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.model.controller.UrlAlias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlAliasBDUrlAliasConverter implements Converter<UrlAlias, BDUrlAlias> {
    private final ModelMapper mapper;

    @Override
    public BDUrlAlias convert(UrlAlias source) {
        if(null == source){
            return null;
        }
        return mapper.map(source, BDUrlAlias.class);
    }

    public BDUrlAlias convert(UrlAlias source, String ipAddress){
        BDUrlAlias converted = convert(source);
        if(null == converted.getRequester()){
            converted.setRequester(BDRequester.builder().ipAddress(ipAddress).build());
        }
        converted.getRequester().setIpAddress(ipAddress);
        return converted;
    }


}

