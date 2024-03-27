package space.bum.zip_search.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SearchKey {
  @NotEmpty
  @Size(min = 3, max = 20)
  private String addrKey;  
}
