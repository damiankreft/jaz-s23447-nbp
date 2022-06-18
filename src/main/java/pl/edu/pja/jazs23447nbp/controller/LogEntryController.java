package pl.edu.pja.jazs23447nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.jazs23447nbp.model.LogCommand;
import pl.edu.pja.jazs23447nbp.model.Root;
import pl.edu.pja.jazs23447nbp.service.LogEntryService;

import java.util.Date;

@RestController
@RequestMapping("/logging")
public class LogEntryController {
    private final LogEntryService logEntryService;

    public LogEntryController(LogEntryService logEntryService) {
        this.logEntryService = logEntryService;
    }

    @ApiOperation(value = "Returns rates of a currency within a given range.")
    @ApiResponses( value = { @ApiResponse(code = 200, message = "Successful response from NBP API."), @ApiResponse(code = 400, message = "Something went wrong. Invalid params or some other error occurred on the NBP's side.")})
    @GetMapping("/{table}/{currency}/{startDate}/{endDate}")
    public ResponseEntity<Root> getLogEntry(@PathVariable String table, @PathVariable String currency,
                                            @PathVariable Date startDate, @PathVariable Date endDate) {
        var command = new LogCommand();
        command.Table = table;
        command.Currency = currency;
        command.RangeStart = startDate;
        command.RangeEnd = endDate;

        var result = logEntryService.get(command);

        if (result.getStatusCode() == HttpStatus.OK)
            return result;
        else
            return ResponseEntity.badRequest().build();
    }
}
