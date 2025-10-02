package card.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDTO {
    private String card_id;
    private String card_number;
    private String card_type;
    private Double card_amount;
    private String card_owner;
    private String phone_number;
    private Short cvv;
    private String expiry_date;
    private String card_status;
    private String created_date;
}
