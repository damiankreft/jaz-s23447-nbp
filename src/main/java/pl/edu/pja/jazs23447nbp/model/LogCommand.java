package pl.edu.pja.jazs23447nbp.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class LogCommand {
    @ApiModelProperty(value = "A", name = "Table selected to execute the query against.")
    public String Table;
    @ApiModelProperty(value = "USD", name = "Currency code")
    public String Currency;
    @ApiModelProperty(value = "2022-05-05", name = "Start of the date range")
    public Date RangeStart;
    @ApiModelProperty(value = "2022-06-17", name = "End of the date range")
    public Date RangeEnd;
}
