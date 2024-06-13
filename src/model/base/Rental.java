package model.base;

import java.time.LocalDate;

public abstract class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private Vehicle vehicle;
}
