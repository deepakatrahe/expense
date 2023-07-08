package com.deepak.expensetrackerv1.service;

import com.deepak.expensetrackerv1.entities.Expense;
import com.deepak.expensetrackerv1.exception.ResourceNotFoundException;
import com.deepak.expensetrackerv1.repository.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Page<Expense> getAllExpense(Pageable page) {
        Page<Expense> expenses= expenseRepository.findAll(page);
        if(expenses.isEmpty()){
            throw new RuntimeException("No expense found");
        }
        return expenses;
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            return expense.get();
        }
        throw new ResourceNotFoundException("Expense not found for id "+id);
    }

    @Override
    public String deleteByExpenseId(Long id) {
        expenseRepository.deleteById(id);
        return null;
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Optional<Expense> expense1 = expenseRepository.findById(id);
        if(expense1.isPresent()){
            Expense expense2 = expense1.get();
            expense2.setName(expense.getName());
            expense2.setAmount(expense.getAmount());
            expense2.setDate(expense.getDate());
            expense2.setDescription(expense.getDescription());
            expenseRepository.save(expense2);
            return expense2;
        }
        throw new RuntimeException("Expense not found for id "+id);
    }

}
