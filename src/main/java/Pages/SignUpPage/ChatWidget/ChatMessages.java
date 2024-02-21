package Pages.SignUpPage.ChatWidget;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ChatMessages {
    @ToString.Include
    public String freeTrial(){return "Start a free trial";}
    @ToString.Include
    public String demo(){return "Schedule a demo";}
    @ToString.Include
    public String talk(){return "Talk with our team";}
    @ToString.Include
    public String existingCustomer(){return "I'm an existing customer";}
    @ToString.Include
    public String notCustomer(){return "Not a customer but want to learn more";}
    @ToString.Include
    public String existingPartner(){return "I'm an existing partner";}
    @ToString.Include
    public String explorePartnership(){return "Would like to explore potential partnership";}


}
