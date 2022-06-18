package pl.edu.pja.jazs23447nbp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Date RangeStart;
    private Date RangeEnd;

    private Date ExecutionDate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Date getExecutionDate() {
        return ExecutionDate;
    }

    public void setExecutionDate(Date executionDate) {
        ExecutionDate = executionDate;
    }
}
