package Pages.SignInPage;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class ErrorMessage {
    @ToString.Include
    public String invalidAddress(){return "Invalid email address try again or Get a Free Trial";}

}
