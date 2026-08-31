package customer;

import java.util.Optional;

public interface CustomerDAO {
    void save(CustomerDTO customer);
    Optional<CustomerDTO> findOne(CustomerDTO customer);
}
