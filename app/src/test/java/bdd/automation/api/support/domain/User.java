package bdd.automation.api.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

   @Builder.Default
   public int id = 10;

   @Builder.Default
   public String username = "rafalima";

   @Builder.Default
   public String firstName = "Rafael";

   @Builder.Default
   public String lastName = "Lima";

   @Builder.Default
   public String email = "rafael@gmail.com";

   @Builder.Default
   public String password = "12345";

   @Builder.Default
   public String phone = "81999999999";

   @Builder.Default
   public int userStatus = 1;
}
