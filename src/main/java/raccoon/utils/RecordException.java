package raccoon.utils;

import lombok.Getter;

@Getter
public class RecordException extends RuntimeException {

  private String message;
  private int code;

  public RecordException(String message, int code) {
    super(message);
    this.message = message;
    this.code = code;
  }
}
