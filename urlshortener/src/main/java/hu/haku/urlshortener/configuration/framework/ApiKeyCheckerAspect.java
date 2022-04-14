package hu.haku.urlshortener.configuration.framework;

import hu.haku.urlshortener.configuration.ApiKeyConfig;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class ApiKeyCheckerAspect {

    private final ApiKeyConfig config;
    private final HttpServletRequest request;

    @Around("@annotation(apiKeyChecker)")
    public Object authorize(ProceedingJoinPoint joinPoint, ApiKeyChecker apiKeyChecker) throws Throwable {

        String apiKey = request.getHeader(ApiKeyChecker.API_KEY_HEADER_NAME);

        if (StringUtils.isBlank(apiKey)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "For this operation, an api-key authorization must be performed before executing");
        }

        if (!config.isConsumerAllowedToUse(apiKey, apiKeyChecker.endpointName())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "An api-key or an api-key with the right privileges are required for this operation.");
        }

        //This is where ACTUAL METHOD will get invoke
        Object result = joinPoint.proceed();
        return result;
    }

}
