package backend;

import entity.Department;
import java.util.List;

public interface IDep {
    List<Department> getAllDepartments();
    List<Department> getDepartmentsByName(String name);
}
