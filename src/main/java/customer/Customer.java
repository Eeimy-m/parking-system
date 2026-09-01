package customer;

import java.util.Objects;

public class Customer {
    private VehicleType vehicleType;

    private String plate;
    private String phone;
    private String type;

    public Customer(VehicleType vehicleType, String plate, String phone, String type) {
        this.vehicleType = vehicleType;
        this.plate = plate;
        this.phone = phone;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(plate, customer.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plate);
    }

    @Override
    public String toString() {
        return String.format("| plate = %s | vehicle type = %s | phone = %s | type = %s |",
                plate, vehicleType, phone, type);
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }
}
