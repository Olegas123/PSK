package com.example.psk_lab.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Interceptor
@LoggedInvocation
public class PerformanceInterceptor implements Serializable {
    private static final ConcurrentHashMap<String, AtomicLong> counts = new ConcurrentHashMap<>();
    @AroundInvoke
    public Object methodExecutionTimeCalculator(InvocationContext context) throws Exception {
        long startTime = System.nanoTime();
        Object result = context.proceed();
        long duration = (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
        String methodName = context.getMethod().getName();
        AtomicLong counter = counts.computeIfAbsent(methodName, k -> new AtomicLong(0));
        long count = counter.incrementAndGet();
        System.out.printf("Method %s execution time: %d ms. Called %d times.%n", methodName, duration, count);
        return result;
    }
}
