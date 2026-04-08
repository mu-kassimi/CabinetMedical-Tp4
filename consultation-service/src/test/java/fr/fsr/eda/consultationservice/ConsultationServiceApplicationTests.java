package fr.fsr.eda.consultationservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest(properties = { "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}" })
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:0" })
class ConsultationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
