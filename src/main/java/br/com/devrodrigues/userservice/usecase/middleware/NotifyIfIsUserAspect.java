package br.com.devrodrigues.userservice.usecase.middleware;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.ports.StudentPort;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifyIfIsUserAspect {

    private final Logger logger = LoggerFactory.getLogger(NotifyIfIsUserAspect.class);
    private final StudentPort studentPort;

    public NotifyIfIsUserAspect(StudentPort studentPort) {
        this.studentPort = studentPort;
    }

    @Around("execution(* br.com.devrodrigues.userservice.usecase.CreateUserUseCase.execute(..))")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {

        var payload = (User) pjp.getArgs()[0];

        if (payload.getRole().equalsIgnoreCase("student")) {
            logger.info("User is a student - notify school about this user");
            studentPort.notifyStudentSchool(payload.getName());
        }

        return pjp.proceed();
    }
}
