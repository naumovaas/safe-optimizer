package ru.tsc.anaumova.optimizer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ru.tsc.anaumova.optimizer.component.ConverterJsonToItemList;
import ru.tsc.anaumova.optimizer.model.Safe;

@TestConfiguration
public class TestConfig {

    @Bean
    @Scope("prototype")
    public Safe safe() {
        return new Safe(10);
    }

    @Bean
    public ConverterJsonToItemList converter() {
        return new ConverterJsonToItemList();
    }

}