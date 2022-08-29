package com.sedukta.digitalbanking.web;

import com.sedukta.digitalbanking.dto.CustomerDTO;
import com.sedukta.digitalbanking.exceptions.DigitalBankException;
import com.sedukta.digitalbanking.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public Page<CustomerDTO> customers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "direction", defaultValue = "DESC") String sortDirection){
        return bankAccountService.listCustomers(PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
    @GetMapping("/customers/search")
    public Page<CustomerDTO> searchCustomers( @RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "size", defaultValue = "10") int size,
                                              @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                                              @RequestParam(name = "direction", defaultValue = "DESC") String sortDirection,
                                              @RequestParam(name = "fullName",defaultValue = "") String fullName,
                                              @RequestParam(name = "adress",defaultValue = "") String adress,
                                              @RequestParam(name = "email",defaultValue = "") String email,
                                              @RequestParam(name = "phoneNumber",defaultValue = "") String phoneNumber,
                                              @RequestParam(name = "birthday",defaultValue = "") String birthday){
        return bankAccountService.searchCustomers("%"+fullName+"%", "%"+adress+"%", "%"+email+"%", "%"+phoneNumber+"%", "%"+birthday+"%",PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws DigitalBankException {
        return bankAccountService.getCustomer(customerId);
    }
    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }
}
