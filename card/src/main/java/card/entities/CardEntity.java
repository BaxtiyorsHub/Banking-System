package card.entities;

import card.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "card")
@Getter
@Setter
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private String cardId;

    @Column(name = "card_number", insertable = false, updatable = false)
    private String cardNumber;

    @Column(name = "card_type", updatable = false, insertable = false)
    private String cardType;

    @Column(name = "cardAmount")
    private Double cardAmount = 0.0;

    @Column(name = "cardStatus")
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus = CardStatus.ACTIVE;

    @Column(name = "card_owner", updatable = false, insertable = false)
    private String cardOwner;

    @Column(name = "cvv")
    private Short cvv;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "expiry_date", updatable = false, insertable = false)
    private LocalDate expiryDate = LocalDate.now().plusYears(5);

    @Column(name = "created_date", updatable = false, insertable = false)
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdDate;
}
