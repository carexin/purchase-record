package raccoon;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class LocalDateTests {

  @Test
  public void test() {
    LocalDateTime time = LocalDateTime.now();
    System.out.println(time.getMonth());
    System.out.println(time.getMonth().getValue());
    System.out.println(time.toLocalDate().getMonth().maxLength());
    System.out.println(time.toLocalDate().lengthOfMonth());

  }

  @Test
  public void test2() {
    System.out.println(UUID.randomUUID().toString());
    System.out.println(UUID.randomUUID().toString().length());

  }


  @Test
  public void test3() {
    for (int i = 0; i <= 10; i++) {
      System.out.println(i);
    }
  }

}
