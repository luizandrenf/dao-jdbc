package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;

import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Department> list = new ArrayList<>();


        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("=== TEST 1: findById ====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println();
        System.out.println("=== TEST 2: findAll ====");
        list = departmentDao.findAll();
        for (Department department : list) {
            System.out.println(department);
        }

        System.out.println();
        System.out.println("=== TEST 3: insert ====");
        Department newDep = new Department(null, "Music");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id: " + newDep.getId());

        System.out.println();
        System.out.println("=== TEST 4: update ====");
        newDep = departmentDao.findById(2);
        newDep.setName("Technology");
        departmentDao.update(newDep);
        System.out.println("Update completed");

        System.out.println();
        System.out.println("=== TEST 5: delete ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
    }
}
