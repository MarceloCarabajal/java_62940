package com.coderhouse.finalEcommerce;

import com.coderhouse.finalEcommerce.dao.DaoFactory;
import com.coderhouse.finalEcommerce.models.Comprador;
import com.coderhouse.finalEcommerce.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalEcommerceApplication implements CommandLineRunner {

	@Autowired
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(FinalEcommerceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		try{

			Producto producto1 = new Producto("Teclado","Teclado Redragon", 100000, 20);
			Producto producto2 = new Producto("Mouse","Mouse Redragon", 70000, 25);
			Producto producto3 = new Producto("Monitor","Monitor IPS Samsung 24 pulgadas", 250000, 10);
			Producto producto4 = new Producto("Monitor 2","Monitor IPS Noblex 24 pulgadas", 200000, 10);

			Comprador comprador1 = new Comprador("Marcelo", "Carabajal", 34, "mcarabajal@email.com", "11111111", 1000);
			Comprador comprador2 = new Comprador("Martin", "Carabajal", 32, "martincarabajal@email.com", "22222222", 1002);
			Comprador comprador3 = new Comprador("Dario", "Lencina", 34, "dlencina@email.com", "33333333", 1003);
			Comprador comprador4 = new Comprador("Sebastian", "Quesada", 35, "squesada@email.com", "44444444", 1004);

			dao.persisirComprador(comprador1);
			dao.persisirComprador(comprador2);
			dao.persisirComprador(comprador3);
			dao.persisirComprador(comprador4);

			dao.persisirProducto(producto1);
			dao.persisirProducto(producto2);
			dao.persisirProducto(producto3);
			dao.persisirProducto(producto4);

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
