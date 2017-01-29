package kz.kaznitu.lessons.interfaces;


import kz.kaznitu.lessons.model.Customer;

public interface CustomerDao {
    public void insert(Customer customer) ;
    public Customer findCustomerById(int custId) ;
}
