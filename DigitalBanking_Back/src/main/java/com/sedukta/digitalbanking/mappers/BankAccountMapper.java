package com.sedukta.digitalbanking.mappers;

import com.sedukta.digitalbanking.dto.AccountOperationDTO;
import com.sedukta.digitalbanking.dto.CurrentBankAccountDTO;
import com.sedukta.digitalbanking.dto.CustomerDTO;
import com.sedukta.digitalbanking.dto.SavingBankAccountDTO;
import com.sedukta.digitalbanking.entities.AccountOperation;
import com.sedukta.digitalbanking.entities.CurrentAccount;
import com.sedukta.digitalbanking.entities.Customer;
import com.sedukta.digitalbanking.entities.SavingAccount;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper( componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BankAccountMapper {

    CustomerDTO fromCustomerToDTO (Customer customer);
    Customer fromDTOToCustomer (CustomerDTO customerDTO);

    SavingBankAccountDTO fromSavingBankAccountToDTO (SavingAccount savingAccount);
    SavingAccount fromDTOToSavingBanckAccount (SavingBankAccountDTO savingBankAccountDTO);

    CurrentBankAccountDTO fromCurrentBankAccountToDTO (CurrentAccount currentAccount);
    CurrentAccount fromDTOToCurrentAccount(CurrentBankAccountDTO currentBankAccountDTO);

    AccountOperationDTO fromAccountOperationToDto(AccountOperation accountOperation);
    AccountOperation fromDTOToAccountOperation (AccountOperationDTO accountOperationDTO);

}
