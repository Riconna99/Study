package com.vivk.study.javase.lambda;

import com.vivk.study.javase.stream.Employee;

public class FilterEmployeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee t) {
        return t.getSalary()>=5000;
    }
}
