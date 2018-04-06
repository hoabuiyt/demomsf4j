# demomsf4j
new example

06/04/2018
 + issue: 
 
 [2018-04-06 08:25:37,470]  WARN {org.wso2.msf4j.internal.MSF4JMessageProcessor} - Unmapped exception java.lang.NoClassDefFoundError: com/mongodb/MongoClient
        at org.wso2.msf4j.sample.MovieService.getAllStocks(MovieService.java:55)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.wso2.msf4j.internal.router.HttpMethodInfo.invoke(HttpMethodInfo.java:132)
        at org.wso2.msf4j.internal.MSF4JMessageProcessor.dispatchMethod(MSF4JMessageProcessor.java:159)
        at org.wso2.msf4j.internal.MSF4JMessageProcessor.lambda$receive$26(MSF4JMessageProcessor.java:86)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.ClassNotFoundException: com.mongodb.MongoClient
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        ... 11 more
