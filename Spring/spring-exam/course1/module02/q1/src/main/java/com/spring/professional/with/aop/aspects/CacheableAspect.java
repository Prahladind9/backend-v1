package com.spring.professional.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Component
public class CacheableAspect {
    private Logger logger = Logger.getLogger("cache.logger");

    private Map<CacheKey, Object> cache = new HashMap<>();

    @Around("@annotation(com.spring.professional.with.aop.annotations.Cacheable)")
    public Object checkCache(ProceedingJoinPoint point) throws Throwable {
        CacheKey cacheKey = new CacheKey(point);

        if(cache.containsKey(cacheKey)){
            logger.info("Fetching value from cache for " + point.getSignature().toShortString());
            return cache.get(cacheKey);
        }else {
            Object result = point.proceed();
            cache.put(cacheKey, result);
            return result;
        }
    }

    private static class CacheKey{
        private final Object target;
        private final String signature;
        private final Object[] args;

        public CacheKey(ProceedingJoinPoint point) {
            this.target = point.getTarget();
            this.signature = point.getSignature().toLongString();
            this.args = point.getArgs();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return Objects.equals(target, cacheKey.target) && Objects.equals(signature, cacheKey.signature) && Arrays.equals(args, cacheKey.args);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(target, signature);
            result = 31 * result + Arrays.hashCode(args);
            return result;
        }
    }
}
