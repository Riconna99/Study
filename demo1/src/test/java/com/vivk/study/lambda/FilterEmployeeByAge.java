package com.vivk.study.lambda;

import com.vivk.study.stream.Employee;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>=35;
    }
}
