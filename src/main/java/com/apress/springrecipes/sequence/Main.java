package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;
import com.apress.springrecipes.sequence.config.ShopConfiguration;
import com.apress.springrecipes.shop.Product;
import com.apress.springrecipes.shop.ShopingCart;

public class Main {

	public static void main(String[] args) {
		
		/*
		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

		SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
		// SequenceGenerator generator =
		// context.getBean("sequenceGenerator",SequenceGenerator.class);
		// SequenceGenerator generator = context.getBean(SequenceGenerator.class);

		DatePrefixGenerator datePrefixGenerator = (DatePrefixGenerator) generator.getPrefixGeneratorProperty();
		System.out.println(datePrefixGenerator.getPrefix());
		System.out.println(generator.getSequence());
		System.out.println(generator.getSequence());
		*/

		/*
		 * ApplicationContext context = new
		 * AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
		 * SequenceGenerator generator = (SequenceGenerator)
		 * context.getBean("sequenceGenerator");
		 * 
		 * System.out.println(generator.getSequence());
		 * System.out.println(generator.getSequence());
		 * 
		 * SequenceDao sequenceDao = context.getBean(SequenceDao.class);
		 * 
		 * System.out.println(sequenceDao.getNextValue("IT"));
		 * System.out.println(sequenceDao.getNextValue("IT"));
		 */

		/*
		 * ApplicationContext context = new
		 * AnnotationConfigApplicationContext(ShopConfiguration.class);
		 * 
		 * Product aaa = context.getBean("aaa",Product.class); Product cdrw =
		 * context.getBean("cdrw", Product.class);
		 * 
		 * System.out.println(aaa); System.out.println(cdrw);
		 */
		
		ApplicationContext applicationContext  =  new AnnotationConfigApplicationContext(ShopConfiguration.class);
		
		Product aaa = applicationContext.getBean("aaa",Product.class);
		Product cdrw = applicationContext.getBean("cdrw",Product.class);
		Product dvdrw = applicationContext.getBean("dvdrw",Product.class);
		
		ShopingCart shopingCart1  = applicationContext.getBean("shopingCart",ShopingCart.class);
		shopingCart1.addItem(aaa);
		shopingCart1.addItem(cdrw);
		
		System.out.println("Shopping cart 1 contains " +shopingCart1.getItems());
		
		ShopingCart cart2 = applicationContext.getBean("shopingCart",ShopingCart.class);
		cart2.addItem(dvdrw);
		
		
		System.out.println("Shopping cart 2 contains " +cart2.getItems());

	}

}
