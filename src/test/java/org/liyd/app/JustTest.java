package org.liyd.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JustTest {

  @Test
  public void test(){
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    System.out.println(integers.get(integers.size()-1));
  }
}
