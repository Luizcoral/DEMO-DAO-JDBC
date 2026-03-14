package Application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws SQLException {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n==== TEST 1: Department findById ====");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n==== TEST 2: Department findAll ====");
        list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }


        System.out.println("\n==== TEST 3: Department insert ====");
        dep = new Department(null, "music");
        departmentDao.insert(dep);
        System.out.println("Inserted! new Id: " + dep.getId());

        System.out.println("\n==== TEST 4: Department update ====");
        dep = departmentDao.findById(5);
        dep.setName("Som");
        departmentDao.update(dep);
        System.out.println("Update Concluido");

        System.out.println("\n==== TEST 5: Department Delete ====");

        System.out.println("Enter the Id For Delete");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete");

    }
}
