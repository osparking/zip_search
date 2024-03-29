package space.bum.zip_search.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class OpenApiControllerTest {

  @Test
  void testFind() {
    List<String> vector = new ArrayList<String>();
    int[] counts = new int[2];
    OpenApiController.find("미사강변동로", 1, 10, vector, counts);
  }

}
