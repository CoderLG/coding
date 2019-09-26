package cn.com.geovis.data_import.data_import;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"cn.com.geovis.data_import.data_import.model"})
public class DataImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataImportApplication.class, args);
	}

}
