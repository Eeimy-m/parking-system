package persistense;

import costs.PeriodCostsDAO;
import costs.PeriodCostsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodCostDaoImpl implements PeriodCostsDAO {
    @Override
    public List<PeriodCostsDTO> findAll() {
        String sql = "SELECT * FROM PERIOD_COSTS";
        List<PeriodCostsDTO> list = new ArrayList<>();

        try (var statement = ConnectionFactory.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                list.add(new PeriodCostsDTO(
                        rs.getInt("hours"),
                        rs.getDouble("fee")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
