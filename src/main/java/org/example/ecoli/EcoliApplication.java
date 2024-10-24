package org.example.ecoli;

import brave.handler.MutableSpan;
import zipkin2.reporter.BytesEncoder;
import zipkin2.reporter.otel.brave.OtlpProtoV1Encoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcoliApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcoliApplication.class, args);
	}

	@Bean
	BytesEncoder<MutableSpan> otlpMutableSpanBytesEncoder() {
		return OtlpProtoV1Encoder.create();
	}
}
