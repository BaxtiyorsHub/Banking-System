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
    private String card_id;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "card_type")
    private String card_type;

    @Column(name = "card_amount")
    private Double card_amount;

    @Column(name = "card_status")
    @Enumerated(EnumType.STRING)
    private CardStatus card_status;

    @Column(name = "card_owner")
    private String card_owner;

    @Column(name = "cvv")
    private Short cvv;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "expiry_date")
    private LocalDate expiry_date;

    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_date;
}
