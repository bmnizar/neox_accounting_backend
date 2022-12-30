package com.neoxiontechnologies.neoxAccounting.core;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.content.rest.config.RestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@Configuration
@EnableFilesystemStores
@Import(RestConfiguration.class)
public class EnableFilesystemStoresConfig {
	@Autowired
	private Environment env;

	@Bean
	File filesystemRoot() {
		return new File(env.getProperty("filesystemRoot"));

	}

	@Bean
	FileSystemResourceLoader fileSystemResourceLoader() {
		return new FileSystemResourceLoader(filesystemRoot().getAbsolutePath());
	}

}