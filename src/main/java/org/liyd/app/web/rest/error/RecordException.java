package org.liyd.app.web.rest.error;

import lombok.Data;

@Data
public class RecordException extends RuntimeException {

  private String message;
  private int code;

  public RecordException(String message, int code) {
    super(message);
    this.message = message;
    this.code = code;
  }
}
