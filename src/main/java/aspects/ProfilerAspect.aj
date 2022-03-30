package aspects;

import main.LogsManager;

public aspect ProfilerAspect {
    long startTime;

    pointcut beforeCall() : call(* main.OrderManager.*(..));

    before() : beforeCall() {
        startTime = System.currentTimeMillis();
    }

    pointcut afterCall() : call(* main.OrderManager.*(..));

    after() : afterCall() {
        final long duration = System.currentTimeMillis() - startTime;
        if(duration > 1000) {
            LogsManager.warning("OrderManager." + thisJoinPoint.getSignature() + " took " + duration + "ms");
        }
    }
}
