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

2) Set "application.properties" to customize H2 in-memory DB.

	spring.h2.console.enabled=true
	
	spring.datasource.url=jdbc:h2:mem:testdb 
	
	spring.datasource.username=sa
	
	spring.datasource.password=
	
	spring.datasource.driver-class-name=org.h2.Driver
	
3)  Difference between 'git add .' vs 'git add -A'
    https://gist.github.com/dsernst/ee240ae8cac2c98e7d5d
    
 Some Free Studd to be Read :
 https://in28minutes1.teachable.com/p/in28minutes-course-guide/?_ga=2.63889199.1896846572.1537476838-1600159746.1537476838
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

