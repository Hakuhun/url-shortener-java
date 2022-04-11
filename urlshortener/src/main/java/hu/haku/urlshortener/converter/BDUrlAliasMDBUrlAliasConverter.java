package hu.haku.urlshortener.converter;

import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.persistence.model.MDBUrlAlias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BDUrlAliasMDBUrlAliasConverter implements Converter<MDBUrlAlias, BDUrlAlias> {
    private final ModelMapper mapper;

    @Override
    public BDUrlAlias convert(MDBUrlAlias source) {
        if (source == null) {
            return null;
        }
        BDUrlAlias alias = mapper.map(source, BDUrlAlias.class);
        if (source.get_id() != null) {
            alias.setId(source.get_id().toHexString());
        }

        return alias;
    }
}
