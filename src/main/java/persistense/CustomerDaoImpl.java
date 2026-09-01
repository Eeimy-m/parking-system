package persistense;

import customer.CustomerDAO;
import customer.CustomerDTO;

import java.util.Optional;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public void save(CustomerDTO customer) {

    }

    @Override
    public Optional<CustomerDTO> findOne(CustomerDTO customer) {
        return Optional.empty();
    }
}
