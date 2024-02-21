package Pages.SignUpPage;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class ErrorMessage {
    @ToString.Include
    public String isRequired(){return "Field is required.";}
    @ToString.Include
    public String validEmail(){return "Must be valid email address.";}



}
