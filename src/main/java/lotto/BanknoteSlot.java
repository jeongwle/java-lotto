package lotto;

import static lotto.enums.Messages.ERROR_MESSAGE_PREFIX;
import static lotto.enums.Messages.PRICE_ERROR_MESSAGE;
import static lotto.enums.Messages.PRICE_RANGE_ERROR_MESSAGE;
import static lotto.enums.Numbers.LOTTO_PRICE;
import static lotto.enums.Numbers.LOTTO_PRICE_MAX;
import static lotto.enums.Numbers.LOTTO_PRICE_MIN;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class BanknoteSlot {

    // TODO: enum으로 분리
    private static final String MONEY_REGEX = "^[0-9]+$";
    private int money;

    public BanknoteSlot() {
    }

    public void receiveMoney() {
        String money = Console.readLine();
        validate(money);
        setMoney(money);
    }

    public int getMoney() {
        return money;
    }

    private void validate(String money) {
        String prefix = ERROR_MESSAGE_PREFIX.toString();
        if (!isValidateRegex(money)) {
            throw new IllegalArgumentException(prefix + PRICE_ERROR_MESSAGE);
        }
        if (!isValidateRange(money)) {
            throw new IllegalArgumentException(prefix + PRICE_RANGE_ERROR_MESSAGE);
        }
        if (!isValidateUnit(money)) {
            throw new IllegalArgumentException(prefix + PRICE_ERROR_MESSAGE);
        }
    }

    private boolean isValidateRegex(String money) {
        return (Pattern.matches(MONEY_REGEX, money));
    }

    private boolean isValidateUnit(String money) {
        int inputMoney = toInt(money);
        return inputMoney % LOTTO_PRICE.getValue() == 0;
    }

    private boolean isValidateRange(String money) {
        long moneyTemp = Long.parseLong(money);
        return moneyTemp >= LOTTO_PRICE_MIN.getValue() && moneyTemp < LOTTO_PRICE_MAX.getValue();
    }

    private void setMoney(String money) {
        this.money = toInt(money);
    }

    private int toInt(String money) {
        return Integer.parseInt(money);
    }
}
