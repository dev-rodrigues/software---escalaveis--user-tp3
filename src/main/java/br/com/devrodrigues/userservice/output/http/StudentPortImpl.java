package br.com.devrodrigues.userservice.output.http;

import br.com.devrodrigues.userservice.output.http.client.SchoolClient;
import br.com.devrodrigues.userservice.output.http.entity.StudentityEntity;
import br.com.devrodrigues.userservice.ports.StudentPort;
import org.springframework.stereotype.Component;

@Component
public class StudentPortImpl implements StudentPort {

    private final SchoolClient client;

    public StudentPortImpl(SchoolClient client) {
        this.client = client;
    }

    @Override
    public void notifyStudentSchool(String studentName) {
        var payload = new StudentityEntity();
        payload.setName(studentName);
        client.saveStudent(
                payload
        );
    }
}
