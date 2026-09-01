package ticket;

import java.util.Optional;

public interface TicketDAO {
    void save(EntryTicketDTO ticketDTO);
    void updateExit(ExitTicketDTO exitDTO);
    Optional<EntryTicketDTO> findOpenTicket();
}
