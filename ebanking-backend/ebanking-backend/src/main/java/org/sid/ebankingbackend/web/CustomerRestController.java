package org.sid.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.exceptions.CustomerNotFoundException;
import org.sid.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<Customer> customers(){

        return bankAccountService.listCustomers();
    }
    @GetMapping("/customers/search")
    public List<Customer> searchCustomers(@RequestParam(name="keyword", defaultValue = "") String keyword){

        return bankAccountService.searchCustomers("%"+keyword+"%");
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable(name="id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.upadateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }
}
