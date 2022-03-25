package aspects;


import main.LogsManager;

public aspect GlobalLogger {

    //Constructors
    pointcut mainConstructors() : call(public main.*.new(..));

    after() returning : mainConstructors() {
        LogsManager.infoSuccess("New " + thisJoinPoint.getSignature().getDeclaringTypeName() + " created.");
    }

    //Orders
    pointcut newOrder() : call(* main.OrderManager.pushOrder(..));

    after() returning : newOrder() {
        LogsManager.infoSuccess("New order added: " + thisJoinPoint.getArgs()[0] + " || " + thisJoinPoint.getSignature().getDeclaringTypeName());
    }

    //Setters
    pointcut setGlobal() : call(* main.*.set*(..));

    before() : setGlobal() {
        LogsManager.info("Setter { " + thisJoinPoint.getSignature().getName() + " } called from class { " + thisJoinPoint.getSignature().getDeclaringTypeName() + " } with value of { " + thisJoinPoint.getArgs()[0] + " }");
    }
}
