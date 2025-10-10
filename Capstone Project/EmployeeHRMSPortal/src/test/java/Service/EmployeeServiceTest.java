package Service;

import org.example.DAO.*;
import org.example.Model.*;
import org.example.Service.*;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Employee Service Tests")
class EmployeeServiceTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @Mock
    private DepartmentDAO departmentDAO;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create employee successfully")
    void shouldCreateEmployeeSuccessfully() {
        // Arrange
        Employee employee = new Employee();
        employee.setEmpId("EMP001");
        employee.setEmpName("John Doe");
        employee.setMobileNum("1234567890");
        employee.setEmailId("john@example.com");
        employee.setStatus("ACTIVE");

        Department department = new Department();
        department.setDepartment("IT");
        department.setDesignation("Developer");
        department.setDayWage(1000.0);

        // Act
        employeeService.createEmployee(employee, department);

        // Assert
        assertThat(employee.getEmpId()).isNotNull();
    }

    @Test
    @DisplayName("Should throw exception when creating employee with invalid data")
    void shouldThrowExceptionForInvalidEmployeeData() {
        // Arrange
        Employee employee = new Employee();
        Department department = new Department();

        // Act & Assert
        assertThatThrownBy(() ->
                employeeService.createEmployee(employee, department)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should retrieve employee successfully")
    void shouldRetrieveEmployeeSuccessfully() {
        // Arrange
        String empId = "EMP001";
        Employee expected = new Employee();
        expected.setEmpId(empId);
        expected.setEmpName("John Doe");

        when(employeeDAO.getEmployee(empId)).thenReturn(expected);

        // Act
        Employee actual = employeeService.getEmployee(empId);

        // Assert
        assertThat(actual).isNotNull()
                .extracting(Employee::getEmpId, Employee::getEmpName)
                .containsExactly(empId, "John Doe");
    }
}
