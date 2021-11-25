package design.callcenter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

enum RANK {
    RESPONDENT(0),
    MANAGER(1),
    DIRECTOR(2);

    private int val;

    RANK(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

public abstract class Employee {
    int empId;
    boolean onCall = false;
    Call call;
    RANK rank;

    public Employee(int empId, RANK rank) {
        this.empId = empId;
        call = null;
        this.rank = rank;
    }

    public int getEmpId() {
        return empId;
    }

    void assignCall(Call call) {
        this.call = call;
    }

    void setOnCall () {
        this.onCall = true;
    }

    void setOffCall () {
        this.onCall = false;
    }

    public RANK getRank() {
        return rank;
    }
}

class Respondent extends Employee {
    public Respondent(int empId) {
        super(empId, RANK.RESPONDENT);
    }

    void setOffCall () {
        this.onCall = false;
        //CallCenter updateCount for RESPONDENT
    }
}

class Manager extends Employee {
    public Manager(int empId) {
        super(empId, RANK.MANAGER);
    }
}

class Director extends Employee {
    public Director(int empId) {
        super(empId, RANK.DIRECTOR);
    }
}

class Call {
    int callId;
    int number;
    int callerName;
    Employee employee;

    public Call(int callId, int number, int callerName) {
        this.callId = callId;
        this.number = number;
        this.callerName = callerName;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}

class CallCenter {
    List<Employee> employees;

    private int respondentCount = 10;
    private int managerCount = 5;
    private int directorCount = 2;

    Queue<Call> callQueue;
    Queue<Employee> empQueue = new PriorityQueue<>((a, b) -> a.rank.getVal() - b.rank.getVal());

    public CallCenter(List<Employee> employees) {
        this.employees = employees;
        empQueue.addAll(employees);

        callQueue = new LinkedList<>();
    }

    Optional<Employee> getNextAvailableCallHandler() {
        Optional<Employee> employee;
        if (respondentCount > 0) {
            employee = employees.stream()
                .filter(e -> e instanceof Respondent)
                .filter(e -> !e.onCall)
                .findFirst();
            if(employee.isPresent()) {
                respondentCount--;
                return employee;
            }
        } else if (managerCount > 0) {
            employee = employees.stream()
                .filter(e -> e instanceof Manager)
                .filter(e -> !e.onCall)
                .findFirst();
            if(employee.isPresent()) {
                managerCount--;
                return employee;
            }
        } else if (directorCount > 0) {
            employee = employees.stream()
                .filter(e -> e instanceof Director)
                .filter(e -> !e.onCall)
                .findFirst();
            if(employee.isPresent()) {
                directorCount--;
                return employee;
            }
        }

        return Optional.empty();
    }

    void assignCall(Call call) {
        Optional<Employee> emp = getNextAvailableCallHandler();
        if(emp.isPresent()) {
            call.employee = emp.get();
            emp.get().assignCall(call);
        } else {
            callQueue.add(call);
        }
    }
}


