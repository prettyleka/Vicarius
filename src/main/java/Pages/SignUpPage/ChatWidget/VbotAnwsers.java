package Pages.SignUpPage.ChatWidget;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VbotAnwsers {
    @ToString.Include
    public String freeTrial(){return "Amazing \uD83E\uDD29\n" +
            "You can get your free trial here: https://www.vicarius.io/sign/up";}
    @ToString.Include
    public String demo(){return "You can book a meeting here: https://meetings.hubspot.com/roi3/vicarius-row";}
    @ToString.Include
    public String talk(){return "Sure, I'll try to connect you right away! Before doing so, what's best to describe you?";}
}
