package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.Course;
import com.milind.jpa.hibernate.jpabasics.services.CourseDAOService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaBasicsApplicationTests {

	@Autowired
	CourseDAOService service;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findBtIdCourseTest(){
		Course c = service.findById(2001l);
		Assert.assertEquals("Mastering XML",c.getName());
	}

	@Test
	@DirtiesContext
	public void deleteByIDCourseTest(){
		service.deleteCourse(2001l);
		Assert.assertNull(service.findById(2001l));
	}

	@Test
	@DirtiesContext
	public void insertCourseTest(){
		long l = service.saveCourse(new Course("Test Course"));
		Assert.assertNotEquals(0,l);
	}

}
