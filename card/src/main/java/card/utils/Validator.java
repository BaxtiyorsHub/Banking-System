package card.utils;

import java.util.regex.Pattern;
import card.enums.CardType;

public class Validator {

    // Oʻzbekiston mobil raqami
    private static final String UZ_PHONE_REGEX = "^(?:\\+998|998|0)?9\\d{8}$";
    private static final Pattern UZ_PHONE_PATTERN = Pattern.compile(UZ_PHONE_REGEX);

    // Karta formatlari (Visa, MasterCard, AmEx, Discover, Uzcard, Humo)
    private static final String CARD_FORMAT_REGEX =
            "^(?:4[0-9]{12}(?:[0-9]{3})?" +          // Visa
                    "|5[1-5][0-9]{14}" +                     // MasterCard
                    "|3[47][0-9]{13}" +                      // American Express
                    "|6(?:011|5[0-9]{2})[0-9]{12}" +         // Discover
                    "|8600[0-9]{12}" +                       // UZCARD
                    "|9860[0-9]{12})$";                      // HUMO
    private static final Pattern CARD_FORMAT_PATTERN = Pattern.compile(CARD_FORMAT_REGEX);

    /** Oʻzbekiston telefon raqamini tekshiradi */
    public static boolean validateUzPhone(String phone) {
        if (phone == null) return false;
        return UZ_PHONE_PATTERN.matcher(phone.trim()).matches();
    }

    /** Karta raqamini tekshiradi (format + Luhn) */
    public static boolean validateCard(String cardNumber) {
        if (cardNumber == null) return false;
        String digits = cardNumber.replaceAll("\\D", "");
        if (!CARD_FORMAT_PATTERN.matcher(digits).matches()) return false;
        return luhnCheck(digits);
    }

    /** Karta turini aniqlash */
    public static CardType detectCardType(String cardNumber) {
        if (cardNumber == null) return CardType.UNKNOWN;
        String digits = cardNumber.replaceAll("\\D", "");

        if (digits.matches("^4[0-9]{12}(?:[0-9]{3})?$")) return CardType.VISA;
        if (digits.matches("^5[1-5][0-9]{14}$")) return CardType.MASTERCARD;
        if (digits.matches("^3[47][0-9]{13}$")) return CardType.AMEX;
        if (digits.matches("^6(?:011|5[0-9]{2})[0-9]{12}$")) return CardType.DISCOVER;
        if (digits.matches("^8600[0-9]{12}$")) return CardType.UZCARD;
        if (digits.matches("^9860[0-9]{12}$")) return CardType.HUMO;

        return CardType.UNKNOWN;
    }

    /** Luhn algoritmi */
    private static boolean luhnCheck(String number) {
        int sum = 0;
        boolean alternate = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = number.charAt(i) - '0';
            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }
}
