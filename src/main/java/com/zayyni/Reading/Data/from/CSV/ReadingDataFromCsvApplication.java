package com.zayyni.Reading.Data.from.CSV;

import com.zayyni.Reading.Data.from.CSV.beans.CsvReader;
import com.zayyni.Reading.Data.from.CSV.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ReadingDataFromCsvApplication {

	public static void main(String[] args) throws IOException {
		 ConfigurableApplicationContext ctxt =SpringApplication.run(ReadingDataFromCsvApplication.class, args);
		  CsvReader csvReader=ctxt.getBean(CsvReader.class);
		  List<Product> filterProducts =csvReader.readAndFilterProductsData();
		  filterProducts.forEach(System.out::println);
	}

}
