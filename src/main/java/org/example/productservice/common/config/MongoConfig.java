package org.example.productservice.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
	@Override
	protected String getDatabaseName() {
		return "product-service";
	}

	@Override
	protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter adapter) {
		adapter.registerConverter(new BinaryToStringConverter());
	}
}