package edu.prao.kafkaudemy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Jacksonized
public class ModifiableRandomEvent {
    //https://howtodoinjava.com/lombok/lombok-builder-read-write-json/

    //ModifiableRandomEvent{id=1, type=TEMPERATURE, name=Living Room Temp, clusterId=1, timestamp=2022-02-02T09:49:50.135343Z, value=68.58411896745562}
    private Long id;
    private String type;
    private String name;
    private @Nullable Long clusterId;
    private OffsetDateTime timestamp;
    private BigDecimal value;

    @JsonCreator
    public ModifiableRandomEvent(@JsonProperty("id") Long id,
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
