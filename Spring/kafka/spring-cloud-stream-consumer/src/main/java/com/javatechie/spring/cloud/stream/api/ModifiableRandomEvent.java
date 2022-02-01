package com.javatechie.spring.cloud.stream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Component
public final class ModifiableRandomEvent {
  private static final long INIT_BIT_ID = 0x1L;
  private static final long INIT_BIT_TYPE = 0x2L;
  private static final long INIT_BIT_NAME = 0x4L;
  private long initBits = 0x7L;

  private Long id;
  private String type;
  private String name;
  private @Nullable Long clusterId;
  private OffsetDateTime timestamp;
  private BigDecimal value;

  public ModifiableRandomEvent() {
  }

  @JsonCreator
  public ModifiableRandomEvent(long initBits, Long id, String type, String name, @Nullable Long clusterId, OffsetDateTime timestamp, BigDecimal value) {
    this.initBits = initBits;
    this.id = id;
    this.type = type;
    this.name = name;
    this.clusterId = clusterId;
    this.timestamp = timestamp;
    this.value = value;
  }
}
