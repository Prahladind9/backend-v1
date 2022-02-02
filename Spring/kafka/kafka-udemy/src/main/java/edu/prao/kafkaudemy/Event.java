package edu.prao.kafkaudemy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class Event {
    private Long id;
    private String type;
    private String name;
    private @Nullable Long clusterId;
    private OffsetDateTime timestamp;
    private BigDecimal value;

    @JsonCreator
    public Event(@JsonProperty("id") Long id,
                 @JsonProperty("type") String type,
                 @JsonProperty("name") String name,
                 @JsonProperty("clusterId") @Nullable Long clusterId,
                 @JsonProperty("timestamp") OffsetDateTime timestamp,
                 @JsonProperty("value") BigDecimal value) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.clusterId = clusterId;
        this.timestamp = timestamp;
        this.value = value;
    }
}
