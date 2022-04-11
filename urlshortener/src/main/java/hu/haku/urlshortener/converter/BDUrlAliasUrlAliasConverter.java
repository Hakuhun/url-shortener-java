package hu.haku.urlshortener.converter;

import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.model.controller.UrlAlias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BDUrlAliasUrlAliasConverter  implements Converter<BDUrlAlias, UrlAlias> {
    private final ModelMapper mapper;

    @Override
    public UrlAlias convert(BDUrlAlias source) {
        if(null == source){
            return null;
        }
        return mapper.map(source, UrlAlias.class);
    }
}
