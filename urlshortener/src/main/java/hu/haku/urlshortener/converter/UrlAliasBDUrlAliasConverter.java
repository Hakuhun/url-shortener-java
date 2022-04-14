package hu.haku.urlshortener.converter;

import hu.haku.urlshortener.model.business.BDReport;
import hu.haku.urlshortener.model.business.BDRequester;
import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.model.controller.UrlAlias;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UrlAliasBDUrlAliasConverter implements Converter<UrlAlias, BDUrlAlias> {
    private final ModelMapper mapper;

    @Override
    public BDUrlAlias convert(UrlAlias source) {
        if (null == source) {
            return null;
        }
        BDUrlAlias alias = mapper.map(source, BDUrlAlias.class);
        if (source.getReport() != null) {
            BDReport report = BDReport.builder()
                    .email(StringUtils.isNoneBlank(source.getReport().getEmail()) ? source.getReport().getEmail() : null)
                    .reason(source.getReport().getReason())
                    .reportTIme(Instant.now())
                    .build();
            alias.setReport(Collections.singletonList(report));
        }
        return alias;
    }

    public BDUrlAlias convert(UrlAlias source, String ipAddress) {
        BDUrlAlias converted = convert(source);

        if (null == converted.getRequester()) {
            converted.setRequester(BDRequester.builder().ipAddress(ipAddress).build());
        }
        converted.getRequester().setIpAddress(ipAddress);
        return converted;
    }


}

