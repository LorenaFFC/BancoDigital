package com.project.DigitalBank;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankApplication.class, args);

		String nome = "38400-750";
		String CNH_Number = nome.substring(0, 5);
		String CNH_SEP = nome.substring(5, 6);
		String CNH_DV = nome.substring(6, 9);
		System.out.println("NOME IMP: " + nome);
		System.out.println("PRIMEIROS NUMEROS: " + CNH_Number);
		System.out.println("ULTIMOS NUMEROS: " + CNH_DV);
		System.out.println("SEPARADOR: " + CNH_SEP);
		System.out.println("TAMANHO: " + nome.length());

		if(CNH_Number.matches("[0-9]+")) {
			System.out.println("PRIMEIROS DIGITOS NUMERO");
		}
		if(CNH_DV.matches("[0-9]+")) {
			System.out.println("ULTIMOS DIGITOS NUMERO");
		}
		if(CNH_SEP.matches("-")) {
			System.out.println("SEPARADOR CORRETO");
		}
		else{
			System.out.println("SEPARADOR INCORRETO");

	}
	}



}
