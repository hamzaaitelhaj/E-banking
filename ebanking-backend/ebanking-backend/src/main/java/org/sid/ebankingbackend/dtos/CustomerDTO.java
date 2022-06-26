package org.sid.ebankingbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.Customer;

import javax.persistence.*;
import java.util.List;

@Data
public class CustomerDTO extends Customer {
    private Long id;
    private String name;
    private String email;
}
