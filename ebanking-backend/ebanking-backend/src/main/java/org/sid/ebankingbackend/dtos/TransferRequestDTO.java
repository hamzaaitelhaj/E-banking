package org.sid.ebankingbackend.dtos;

import lombok.Data;

@Data
public class TransferRequestDTO {
    private String accountSource;
    private String accountDestinaton;
    private double amount;
    private String description;
}
