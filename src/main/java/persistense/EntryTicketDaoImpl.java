package persistense;

import ticket.EntryTicketDTO;
import ticket.ExitTicketDTO;
import ticket.TicketDAO;

import java.util.Optional;

public class EntryTicketDaoImpl implements TicketDAO {
    @Override
    public void save(EntryTicketDTO ticketDTO) {

    }

    @Override
    public void updateExit(ExitTicketDTO exitDTO) {

    }

    @Override
    public Optional<EntryTicketDTO> findOpenTicket() {
        return Optional.empty();
    }
}
