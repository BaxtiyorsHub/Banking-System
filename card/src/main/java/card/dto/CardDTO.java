package card.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDTO {

    private String card_id;

    @NotBlank(message = "Card number must not be empty")
    @Pattern(
            regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?" +
                    "|5[1-5][0-9]{14}" +
                    "|3[47][0-9]{13}" +
                    "|6(?:011|5[0-9]{2})[0-9]{12}" +
                    "|8600[0-9]{12}" +
                    "|9860[0-9]{12})$",
            message = "Card number format is invalid"
    )
    private String card_number;

    @NotBlank(message = "Card type must not be empty")
    private String card_type; // Bu avtomatik to‘ldiriladi (Validator.detectCardType)

    @NotNull(message = "Card amount must not be null")
    @PositiveOrZero(message = "Card amount cannot be negative")
    private Double card_amount;

    @NotBlank(message = "Card owner must not be empty")
    private String card_owner;

    @NotBlank(message = "Phone number must not be empty")
    @Pattern(
            regexp = "^(?:\\+998|998|0)?9\\d{8}$",
            message = "Phone number must be valid Uzbekistan format"
    )
    private String phone_number;

    @NotNull(message = "CVV must not be null")
    @Min(value = 100, message = "CVV must be more 3 digits")
    @Max(value = 9999, message = "CVV must be less 4 digits")
    private Short cvv;

    @NotNull(message = "Expiry date must not be null")
    @Future(message = "Expiry date must be in the future")
    private LocalDate expiry_date;

    private String card_status;
    private LocalDateTime created_date;
}
