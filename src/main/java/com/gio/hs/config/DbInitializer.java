package com.gio.hs.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.gio.hs.entity.Employed;
import com.gio.hs.repo.EmployedRepo;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
	private EmployedRepo bankAccountRepository;

	public DbInitializer(EmployedRepo bankAccountRepository) {
		this.bankAccountRepository = bankAccountRepository;
	}
	@Override
	public void run(String... strings) throws Exception {
		this.bankAccountRepository.deleteAll();
		Employed bankAccount1 = new Employed(1,"freddy", "123456",true);
		this.bankAccountRepository.save(bankAccount1);
		System.out.println(" -- Database has been initialized");
	}
}