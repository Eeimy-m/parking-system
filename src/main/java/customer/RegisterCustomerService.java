package customer;

import exception.EntittyAlreadyExistsException;
import persistense.ConnectionFactory;

public class RegisterCustomerService {
    private CustomerDAO customerDAO;

    public RegisterCustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void register(String plate, String phone, VehicleType vehivleType) {
        CustomerDTO customer = new CustomerDTO(plate, phone, vehivleType.toString());
        if(plate == null || phone == null || vehivleType == null) {
            throw new IllegalArgumentException("Invalid values received");
        }

        if(customerDAO.findOne(customer).isPresent()) {
            throw new EntittyAlreadyExistsException("Customer already exists");
        }

        customerDAO.save(customer);
    }
}
