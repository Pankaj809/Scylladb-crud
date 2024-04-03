//package com.example;
//
//import com.example.entity.Employee;
//import com.example.service.EmployeeService;
//import io.micronaut.context.ApplicationContext;
//import io.micronaut.runtime.server.EmbeddedServer;
//import io.micronaut.http.client.HttpClient;
//import io.micronaut.http.HttpRequest;
//import io.micronaut.http.HttpResponse;
//import jakarta.inject.Inject;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
////import static sun.security.pkcs11.wrapper.Functions.getId;
//
//public class EmployeeControllerTest {
//    private static EmbeddedServer server;
//    private static HttpClient client;
//
//    @BeforeAll
//    public static void setupServer(){
//        server = ApplicationContext.run(EmbeddedServer.class);
//        client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
//    }
//
//    @AfterAll
//    public static void stopServer(){
//        if(server != null){
//            server.stop();
//        }
//        if(client != null){
//            client.stop();
//        }
//    }
//
////    @Inject
////    private EmbeddedServer server;
//
//    @Test
//    public void testCreateEmployee(){
//        Employee employee = new Employee();
//        employee.setName("Pankaj Adhikari");
//        employee.setEmail("pankajadhikari809@gmail.com");
//        employee.setAddress("Chabahil");
////        employee.setEmployeeId(89);
//
//        HttpRequest<?> request = HttpRequest.POST("/controller/create", employee);
//        HttpResponse<Employee> response = client.toBlocking().exchange(request, Employee.class);
//
//        assertEquals(response.code(), 200);
//        assertEquals(response.body().getName(), "Pankaj Adhikari");
//        assertEquals(response.body().getEmail(), "pankajadhikari809@gmail.com");
//        assertEquals(response.body().getAddress(),"Chabahil");
////        assertEquals(response.body().getId(),89);
//    }
//}
