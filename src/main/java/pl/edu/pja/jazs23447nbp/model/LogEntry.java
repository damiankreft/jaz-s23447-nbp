package pl.edu.pja.jazs23447nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Currency;
    private Date RangeStart;
    private Date RangeEnd;
    private LocalDateTime ExecutionDate;

    public LogEntry() {
    }

    public LogEntry(Long id, String currency, Date rangeStart, Date rangeEnd, LocalDateTime executionDate) {
        Id = id;
        Currency = currency;
        RangeStart = rangeStart;
        RangeEnd = rangeEnd;
        ExecutionDate = executionDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public Date getRangeStart() {
        return RangeStart;
    }

    public void setRangeStart(Date rangeStart) {
        RangeStart = rangeStart;
    }

    public Date getRangeEnd() {
        return RangeEnd;
    }

    public void setRangeEnd(Date rangeEnd) {
        RangeEnd = rangeEnd;
    }

    public LocalDateTime getExecutionDate() {
        return ExecutionDate;
    }

    public void setExecutionDate(LocalDateTime executionDate) {
        ExecutionDate = executionDate;
    }
}
