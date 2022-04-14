package hu.haku.urlshortener.converter;

import hu.haku.urlshortener.model.business.BDReport;
import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.model.controller.Report;
import hu.haku.urlshortener.model.controller.UrlAlias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class BDUrlAliasUrlAliasConverter  implements Converter<BDUrlAlias, UrlAlias> {
    private final ModelMapper mapper;

    @Override
    public UrlAlias convert(BDUrlAlias source) {
        if(null == source){
            return null;
        }
        UrlAlias alias = mapper.map(source, UrlAlias.class);
        if(!CollectionUtils.isEmpty(source.getReport())){
            BDReport report = source.getReport().stream().findFirst().orElse(null);
            alias.setReport(mapper.map(report, Report.class));
        }
        return alias;
    }
}
