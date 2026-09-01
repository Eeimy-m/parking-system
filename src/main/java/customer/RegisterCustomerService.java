package customer;

import persistense.ConnectionFactory;

public class RegisterCustomerService {
    private CustomerDAO customerDAO;

    public RegisterCustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void register(String plate, String phone, VehicleType vehivleType) {
        ConnectionFactory.getConnection()
    }
}
