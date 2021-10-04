package com.vivk.study.javase.lambda;

import com.vivk.study.javase.stream.Employee;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>=35;
    }
}
