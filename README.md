# jpahibernatepro

====================================================================================================
Step1:
    1) 	Every Entity Bean must have a default constructor. JPA basically execpt default constructor.
    2)  Primary Key is defined by @Id and @Generated annotations.

=======
1) Good Basic Video to Start:
	https://www.youtube.com/watch?v=MaI0_XdpdP8
	
	Hibernate Interview questions : 
		https://www.youtube.com/watch?v=nb4kKVDc4cE   --> To be viewed

localhost:8080/h2-console/
2) Set "application.properties" to customize H2 in-memory DB.

	spring.h2.console.enabled=true
	
	spring.datasource.url=jdbc:h2:mem:testdb 
	
	spring.datasource.username=sa
	
	spring.datasource.password=
	
	spring.datasource.driver-class-name=org.h2.Driver
	spring.jpa.show-sql=true
	
	
3)  Difference between 'git add .' vs 'git add -A'
    https://gist.github.com/dsernst/ee240ae8cac2c98e7d5d
    
 Some Free Stuff to be Read :
 https://in28minutes1.teachable.com/p/in28minutes-course-guide/?_ga=2.63889199.1896846572.1537476838-1600159746.1537476838
 
 IntelliJ and Java 9 errors and FAQ to read:
 https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/quick-start.md
 
 http://www.springboottutorial.com/
=================================
    
    Step1:
    1) Entity class must have a default constructor. JPA except a default constructor.
    2) Primary key is defined by @Id annotation and is stratergy is defined by @GeneratedValue
    3) @Transactional : 1) Annotation can be applied at Class level or Method Level
                        2) If applied at class level, it indicate the each method will be implement a transaction management
                        else if applied at method level, indicate that that method will implement transaction.
    4) Persistence Context:
        When any object marked with  @PersistenceContext, then that object will be saved into DB and all changes made to that object.
        
    Step2:
    1) Add Service UserDAOService
    
    Step3:
    1) Add Service Call while loading - UserDaoServiceCommandRunner

=============
management.endpoints.web.exposure.include=*


In this Branch:
    Added Test cases to Test DB CRUD Operations.
    
    And application.properties to show SQL queries and statistics
    
    #Turn on Statistics
    spring.jpa.properties.hibernate.generate_statistics=true;
    
    #To show all queries
    spring.jpa.show-sql=true
    
    #Format the SQL queries -------> DO not use this in production
    spring.jpa.properties.hibernate.format_sql=true
    
    logging.level.org.hibernate.type=trace
    
    +
    Methods of EntityManagers Demonstrated 
    EntityManager.
        1) flush()
        2) detach()
        3) clear()
        4) refresh()
        
==============================================================================
Transaction Management : 
ACID properties:
1) A -> Automic
2) C -> Consistancy
3) I -> Isolation
4) D -> Durability

Concepts :
1) Dirty Read     ->  When Transaction-2 Reads value which was modified by Trnasction-1 but not yet committed by transaction-1.
2) Non Repeatable Reads --> When a transaction tries to retive the same data twice and it gets two different values during the same transaction
3) Phanthom Reads  --> when I get diff no of rows as a result of same query at two different points of the same transaction.
 
====================
4 Important Isolation Levels:

IsolationLevel      Dirty Read      Non Repeatable Read         Phanthom Read
Read Uncommitted(1)    possible            possible                possible
Read Committed(2)      solved              possible                possible
Repeatable Read(4)     solved              solved                  possible
Serializable(8)        solved              solved                  solved

-----------------------------------------
Mostly used : Read Committed . It gives High perfromance and considarably solve major problems

Serializable ---> Lowest performace. But good Data consistancy and Integrity 

=============================
Diff Between Java JPA and SPING JPA
1) 
javax-> jpa : is capable to manage only transaction over a single DB
Spring->JPA : is capable to manage transaction across multiple DBs , MQ, JMS etc

2) Spring-> JPA @Transactional annotation have below 4 isolation level
    a) DEFAULT
    b) READ_COMMITTED
    c) READ_UNCOMMITTED
    d) REPEATABLE_READ
    e) SERIALIZABLE
    
    E.g
    @Tranasactional(isolation=DEFAULT)
    
    if you want to apply specifica isolation level to all project , then set property:
    
    spring.jpa.properties.hibernate.connection.isolation=2;
