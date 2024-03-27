package space.bum.zip_search.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoundAddress {
  private String zipcode;
  private String address;
}
