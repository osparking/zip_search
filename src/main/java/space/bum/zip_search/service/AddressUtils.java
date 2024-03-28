package space.bum.zip_search.service;

import java.util.ArrayList;
import java.util.List;

import space.bum.zip_search.domain.FoundAddress;

public class AddressUtils {

  public static List<FoundAddress> buildAddresses() {
    List<FoundAddress> addresses = new ArrayList<>();
    for (int i = 0; i < 500; i++) {
      addresses.add(new FoundAddress(Integer.toString(12300 + i),
          "서울시 종로구 관철동 134번지"));
      addresses.add(new FoundAddress(Integer.toString(57000 + i),
          "경기도 하남시 망월동 1050번지"));
    }
    return addresses;
  }
}
