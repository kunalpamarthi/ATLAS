package Service;

import org.example.DAO.*;
import org.example.Service.*;
import org.example.Model.*;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Attendance Service Tests")
class AttendanceServiceTest {

    @Mock
    private AttendanceDAO attendanceDAO;

    @Mock
    private LeaveRequestDAO leaveRequestDAO;

    @InjectMocks
    private AttendanceService attendanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Should throw exception for invalid attendance value")
    void shouldThrowExceptionForInvalidAttendanceValue() {
        // Arrange
        String empId = "EMP001";
        double invalidValue = 2.0;

        // Act & Assert
        assertThatThrownBy(() ->
                attendanceService.markAttendance(empId, invalidValue)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should retrieve monthly attendance successfully")
    void shouldRetrieveMonthlyAttendanceSuccessfully() {
        // Arrange
        String empId = "EMP001";
        String yearMonth = "2025-10";
        List<Attendance> expectedAttendance = Arrays.asList(
                createAttendance(empId, "2025-10-01", 1.0),
                createAttendance(empId, "2025-10-02", 0.5)
        );

        when(attendanceDAO.getMonthlyAttendance(empId, yearMonth))
                .thenReturn(expectedAttendance);

        // Act
        List<Attendance> actualAttendance =
                attendanceService.getMonthlyAttendance(empId, yearMonth);

        // Assert
        assertThat(actualAttendance)
                .hasSize(1)
                .extracting(Attendance::getAttendanceValue)
                .containsExactly(1.0);
    }

    private Attendance createAttendance(String empId, String date, double value) {
        Attendance attendance = new Attendance();
        attendance.setEmpId(empId);
        attendance.setDate(date);
        attendance.setAttendanceValue(value);
        return attendance;
    }
}
