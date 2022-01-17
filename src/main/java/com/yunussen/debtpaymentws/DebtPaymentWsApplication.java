package com.yunussen.debtpaymentws;

import com.yunussen.debtpaymentws.configuration.WebApplicationConfiguration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication(scanBasePackageClasses = {WebApplicationConfiguration.class})
public class DebtPaymentWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtPaymentWsApplication.class, args);
	}
}
