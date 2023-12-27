package objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditTableObject {
    String id;
    String bank_id;
    String created;
    String status;
}
