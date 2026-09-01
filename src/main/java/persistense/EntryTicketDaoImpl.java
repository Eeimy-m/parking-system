package persistense;

import ticket.EntryTicketDTO;
import ticket.ExitTicketDTO;
import ticket.TicketDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EntryTicketDaoImpl implements TicketDAO {
    @Override
    public void save(EntryTicketDTO ticketDTO) {
        String sql = "INSERT INTO ENTRY_TICKET VALUES (?,?,?,?,?)";

        try (PreparedStatement statement = ConnectionFactory.prepareStatement(sql)) {
            statement.setString(1, ticketDTO.id());
            statement.setString(2, ticketDTO.plate());
            statement.setString(3, ticketDTO.entry());
            statement.setString(4, null);
            statement.setDouble(5, 0.0);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateExit(ExitTicketDTO exitDTO) {
        String sql = "UPDATE TICKET SET EXIT = ?, FEE = ? WHERE ID = ?";

        try (PreparedStatement statement = ConnectionFactory.prepareStatement(sql)) {
            statement.setString(1, exitDTO.exit());
            statement.setDouble(2, exitDTO.fee());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<EntryTicketDTO> findOpenTicket(String plate) {
        String sql = "SELECT * FROM TICKET WHERE PLATE = ?";

        try (PreparedStatement statement = ConnectionFactory.prepareStatement(sql)) {
            statement.setString(1, plate);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return Optional.of(new EntryTicketDTO(
                        rs.getString("id"),
                        rs.getString("plate"),
                        rs.getString("entry")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
