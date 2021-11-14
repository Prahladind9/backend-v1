1) What is dependency injection and what are the advantages?
2) What is a pattern? What is anti-pattern? Is dependency injection a pattern?
3) What is an interface and what are the advantages of making use of them in Java?
   Why are they recommended for Spring beans?
4) What is meant by "application context"?
5) What is the concept of "container" and what is its lifecycle?
6) How are you going to create a new instance of an ApplicationContext?
7) Can you describe the lifecycle of Spring Bean in an ApplicationContext?
8) How are you going to create an ApplicationContext in an integration test?
9) What is the preferred way to close an application context? Does Spring Boot do this for you?
10) Can you describe: Dependency injection
    1) using Java configuration?
    2) using annotations (@Component, @Autowired)
    3) Component scanning, Stereotypes and Meta-Annotations?
    4) Scopes for Spring beans?
    5) What is the default scope?
11) Are beans lazily or eagerly instantiated by default? How do you alter this behavior?
12) What is property source? How would you use @PropertySource?
13) What is BeanFactoryPostProcessor and what is it used for?
    1) When is it invoked?
    2) Why would you define a static @Bean method?
    3) What is a PropertySourcesPlaceholderConfigurer used for?
14) What is BeanPostProcessor and how is it different to a BeanFactoryPostProcessor?
    1) What do they do? When are they called?
    2) What is an initialization method and how is it declared on a Spring bean?
    3) What is a destroy method, how is it declared and when is it called?
    4) Consider how you enable JSR-250 annotations like @PostConstruct and @PreDestroy? When/how will they get called? 
    5) How else can you define an initialization or destruction method for a Spring bean?
15) What does component-scanning do?
16) What is the behavior of the annotation @Autowired with regards to field, constructor and method injection?
17) What do you have to do, if you would like to inject something into a private field? How does this impact testing?
18) How does the @Qualifier annotation compliment the use of @Autowired?
19) What is a proxy object and what are the two different types of proxies Spring can create?
    1) What are the limitations of these proxies (per type)?
    2) What is the power of a proxy object and where are the disadvantages?
20) What are the advantages of Java Config? What are the limitations?
21) What does @Bean annotation do?
22) What is the default bean id if you only use @Bean? How can you override this?
23) Why are you not allowed to annotate a final class with @Configuration?
    1) How do @Configuration class support singleton beans?
    2) Why can't @Bean methods be final either?
24) How do you configure profiles? What are the possible use cases where they might be useful?
25) Can you use @Bean together with @Profile?
26) Can you use @Component together with @Profile?
27) How many profiles can you have?
28) How do you inject scalar/literal values into Spring beans?
29) What is @Value used for?