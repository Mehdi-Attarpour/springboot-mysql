package io.learning.springbootmysql.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public Module vavrModule() {
        return new VavrModule();
    }

    @Bean
    public Module jdk8Module() {
        return new Jdk8Module();
    }

    @Bean
    public ObjectMapper objectMapper(@Qualifier("vavrModule") final Module vavrModule,
                                     @Qualifier("jdk8Module") final Module jdk8Module) {
        return new ObjectMapper()
                .registerModule(vavrModule)
                .registerModule(jdk8Module)
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
    }
}
