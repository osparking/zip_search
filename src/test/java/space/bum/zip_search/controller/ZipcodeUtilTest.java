package space.bum.zip_search.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import space.bum.zip_search.domain.FoundAddress;

class ZipcodeUtilTest {

  @Test
  void testFind() {
    List<FoundAddress> pageAddresses = new ArrayList<FoundAddress>();
    int[] counts = new int[2];
    ZipcodeUtil.find("미사강변서로", 6, 10, pageAddresses, counts);
    System.out.println("결과: " + pageAddresses);
  }

}
