package com.vivk.study.lambda;

import com.vivk.study.stream.Employee;

public class FilterEmployeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee t) {
        return t.getSalary()>=5000;
    }
}
