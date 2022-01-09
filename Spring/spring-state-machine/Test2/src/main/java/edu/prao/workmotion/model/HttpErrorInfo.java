package edu.prao.workmotion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class HttpErrorInfo {
  private ZonedDateTime timestamp;
  private String path;
  private HttpStatus httpStatus;
  private String message;
}
