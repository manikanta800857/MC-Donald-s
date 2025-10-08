package ServiceLayer;

import java.math.BigDecimal;

public interface BillingService {
    public void payViaCash(String id,BigDecimal amount);
    public void payViaCard(String id,BigDecimal amount);
}
