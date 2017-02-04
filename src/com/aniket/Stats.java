package com.aniket;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Maintains stats of successful and throttled requests
 */
class Stats {
    private AtomicInteger successFulRequests = new AtomicInteger(0);
    private AtomicInteger throttledRequests = new AtomicInteger(0);
    private AtomicInteger exceptions = new AtomicInteger(0);

    public void incrementSuccessFulRequestCount() {
        successFulRequests.incrementAndGet();
    }

    public void incrementThrottledRequestCount() {
        throttledRequests.incrementAndGet();
    }

    public void incrementExceptionsCount() {
        exceptions.incrementAndGet();
    }

    public int getSuccessFulRequestsCount() {
        return successFulRequests.get();
    }

    public int getThrottledRequestsCount() {
        return throttledRequests.get();
    }

    public int getExceptionsCount() {
        return exceptions.get();
    }
}
