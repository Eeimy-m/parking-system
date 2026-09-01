package ticket;

import customer.Customer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private Customer customer;
    private LocalDateTime entry;
    private LocalDateTime exit;

    public Ticket(Customer customer) {
        this.id = UUID.randomUUID();
        this.entry = LocalDateTime.now();
        this.customer = customer;
    }

    public Ticket(UUID id, Customer customer, LocalDateTime entry) {
        this.id = id;
        this.customer = customer;
        this.entry = entry;
    }

    public void exit() {
        this.exit = LocalDateTime.now();
    }

    public long parkingDuration() {
        return (long) Math.ceil(Duration.between(entry,exit).toMinutes());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("| id = %s | customer = %s | entry = %s | exit = %s |",
                id, customer, entry, exit);
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getEntry() {
        return entry;
    }

    public LocalDateTime getExit() {
        return exit;
    }
}
