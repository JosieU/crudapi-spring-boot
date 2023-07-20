package com.jojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/customers")
public class Main {

    private final Customer_Repository customerRepository;
    public Main(Customer_Repository customerRepository){

        this.customerRepository = customerRepository;
    }

    public static void main(String []args){

        SpringApplication.run(Main.class,args);
    }
    public List<Customer> getCustomers(){
        return  customerRepository.findAll();
    }
    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){

    }
    public void addCustomer( @RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);


    }
    @DeleteMapping("{customerId}")
    public  void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }


}


