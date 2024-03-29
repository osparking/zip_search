package space.bum.zip_search.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class FoundAddress {
  private String zipcode;
  /**
   * 도로명 주소
   */
  private String roadAddress;
  /**
   * 지번 주소
   */
  private String zBunAddress;
}
