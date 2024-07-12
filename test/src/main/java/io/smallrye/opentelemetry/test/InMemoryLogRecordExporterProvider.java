package io.smallrye.opentelemetry.test;

import jakarta.enterprise.inject.spi.CDI;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.logs.ConfigurableLogRecordExporterProvider;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;
import io.opentelemetry.sdk.testing.exporter.InMemoryLogRecordExporter;

public class InMemoryLogRecordExporterProvider implements ConfigurableLogRecordExporterProvider {
    @Override
    public LogRecordExporter createExporter(final ConfigProperties config) {
        return CDI.current().select(InMemoryLogRecordExporter.class).get();
    }

    @Override
    public String getName() {
        return "in-memory";
    }
}
