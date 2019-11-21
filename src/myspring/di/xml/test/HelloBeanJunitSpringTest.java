package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	
	@Autowired
	ApplicationContext context;

	@Test @Ignore
	public void test2() {
		// 2. Hello Bean ��������
		Hello hello = (Hello) context.getBean("hello");
		
		Hello hello2 = (Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
	}

	@Test
	public void test1() {
		// 2. Hello Bean ��������
		Hello hello = (Hello)context.getBean("hello2");
		System.out.println(hello.sayHello());
		// 3. Hello �� sayHello() ȣ��.
		assertEquals("HelloSpring", hello.sayHello());
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for (String value : list) {
			System.out.println(value);
		}
		
		// 3. StringPrinter Bean ��������
//		Printer printer = context.getBean("printer", Printer.class);
//		assertEquals("Hello Spring", printer.toString());

//		Hello hello2 = context.getBean("hello", Hello.class);
//		System.out.println(hello == hello2);

	}

}
