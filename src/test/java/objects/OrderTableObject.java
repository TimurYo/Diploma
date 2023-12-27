package objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderTableObject {
    String id;
    String created;
    String credit_id;
    String payment_id;
}
