package raccoon;

import org.junit.Test;

import java.time.LocalDateTime;

public class LocalDateTests {

  @Test
  public void test(){
    LocalDateTime time = LocalDateTime.now();
    System.out.println(time.getMonth());
    System.out.println(time.getMonth().getValue());
    System.out.println(time.toLocalDate().getMonth().maxLength());
    System.out.println(time.toLocalDate().lengthOfMonth());

  }

}
