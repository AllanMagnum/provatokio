package br.com.tokiomarine.provatokio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tokiomarine.provatokio.listener.MessageListenerComponent;

@SpringBootApplication
public class ProvaTokioWebAppInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProvaTokioWebAppInitializer.class, args);
	
	}
}
