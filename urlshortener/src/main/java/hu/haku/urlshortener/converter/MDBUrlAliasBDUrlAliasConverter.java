package hu.haku.urlshortener.converter;

import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.persistence.model.MDBUrlAlias;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MDBUrlAliasBDUrlAliasConverter implements Converter<BDUrlAlias, MDBUrlAlias> {
    private final ModelMapper mapper;

    @Override
    public MDBUrlAlias convert(BDUrlAlias source) {
        if(null == source){
            return null;
        }
        MDBUrlAlias alias = mapper.map(source, MDBUrlAlias.class);
        if(!StringUtils.isBlank(source.getId())){
            alias.set_id(new ObjectId(source.getId()));
        }
        alias.setStatus(source.getStatus().name());

        return alias;
    }
}
