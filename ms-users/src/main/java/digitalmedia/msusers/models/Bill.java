package digitalmedia.msusers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private String idBill;
    private String customerBill;
    private String productBill;
    private Double totalPrice;
}
