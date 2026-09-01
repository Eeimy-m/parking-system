package persistense;

import customer.Customer;
import customer.CustomerDAO;
import customer.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public void save(CustomerDTO customer) {
        String sql = "INSERT INTO customer VALUES (?,?,?)";

        try  (var statement = ConnectionFactory.prepareStatement(sql)) {
            statement.setString(1, customer.plate());
            statement.setString(2, customer.phone());
            statement.setString(3, customer.type());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<CustomerDTO> findOne(CustomerDTO customer) {
        String sql = "SELECT * FROM customer WHERE plate = ?";

        try (PreparedStatement statement = ConnectionFactory.prepareStatement(sql)) {
            statement.setString(1, customer.plate());
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                CustomerDTO customerFound = new CustomerDTO(
                        rs.getString("plate"),
                        rs.getString("phone"),
                        rs.getString("type"));

                return Optional.of(customerFound);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
