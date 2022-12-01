package org.food.order.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(new BigDecimal(BigInteger.ZERO));
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = setScale(amount);
    }

    public boolean isGreaterThanZero(){
        // It's a best practice to use compareTo instead of equals method for comparing Decimal values
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money money){
        return this.amount != null && this.amount.compareTo(money.amount) > 0;
    }

    public Money add(Money money){
        return new Money(setScale(this.amount.add(money.getAmount())));
    }

    public Money subtract(Money money){
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }

    public Money multiply(int multiplier){
        return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }


    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private BigDecimal setScale(BigDecimal decimal){
        return decimal.setScale(2, RoundingMode.HALF_DOWN);
    }
}
