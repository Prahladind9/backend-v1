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