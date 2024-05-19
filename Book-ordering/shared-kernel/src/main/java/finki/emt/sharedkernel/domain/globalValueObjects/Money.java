package finki.emt.sharedkernel.domain.globalValueObjects;

import finki.emt.sharedkernel.domain.enums.Currency;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;


@Embeddable
@Getter
public class Money {

    @Enumerated(value = EnumType.STRING)
    private final Currency currency;

    private final double amount;

    protected Money() {
        this.currency = null;
        this.amount = 0.0;
    }

    public Money(Currency currency, double amount)
    {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, double amount) { return  new Money(currency,amount);}

    public Money add(Money money){
        if(!currency.equals(money.currency))
        {
            throw new IllegalArgumentException("Not the same currency");
        }
        return new Money(currency,this.amount+money.amount);
    }

    public Money subtract(Money money){
        if(!currency.equals(money.currency))
        {
            throw new IllegalArgumentException("Not the same currency");
        }
        return new Money(currency,this.amount-money.amount);
    }

    public Money subtract(int m){
        return new Money(currency,this.amount*m);
    }
}
