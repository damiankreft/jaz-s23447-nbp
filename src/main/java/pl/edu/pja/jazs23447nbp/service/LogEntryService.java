package pl.edu.pja.jazs23447nbp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pja.jazs23447nbp.model.LogCommand;
import pl.edu.pja.jazs23447nbp.model.LogEntry;
import pl.edu.pja.jazs23447nbp.model.Root;
import pl.edu.pja.jazs23447nbp.repository.LogRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogEntryService {
    private final LogRepository logEntryRepository;
    private final RestTemplate rest;

    public LogEntryService(LogRepository logEntryRepository, RestTemplate rest) {
        this.logEntryRepository = logEntryRepository;
        this.rest = rest;
    }

    public Root get(LogCommand log) {
        var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        var executionDate = LocalDateTime.now();
        var pattern = "yyyy-MM-dd";
        var simpleDateFormat = new SimpleDateFormat(pattern);

        // "http://api.nbp.pl/api/exchangerates/rates/A/{code}/{startDate}/{endDate}/";
        var uri = "http://api.nbp.pl/api/exchangerates/rates/" + log.Table + "/"
                + log.Currency + "/"
                + simpleDateFormat.format(log.RangeStart) + "/"
                + simpleDateFormat.format(log.RangeEnd) + "/";
        var request = rest.getForEntity(uri, Root.class);
        if (request.getStatusCode() == HttpStatus.OK) {
            var logEntry = new LogEntry();
            logEntry.setCurrency(log.Currency);
            logEntry.setRangeStart(log.RangeStart);
            logEntry.setRangeEnd(log.RangeEnd);
            logEntry.setExecutionDate(executionDate);
            logEntryRepository.save(logEntry);
        }

        return request.getBody();
    }
}
