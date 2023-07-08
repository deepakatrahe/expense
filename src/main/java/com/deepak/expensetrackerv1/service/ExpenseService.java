package com.deepak.expensetrackerv1.service;

import com.deepak.expensetrackerv1.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ExpenseService {
    Page<Expense> getAllExpense(Pageable page);
    Expense getExpenseById(Long id);
    String deleteByExpenseId(Long id);
    Expense saveExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
}
