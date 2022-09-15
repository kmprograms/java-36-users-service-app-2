package com.app;

import com.app.config.AppSpringConfig;
import com.app.model.dto.CreateUserDto;
import com.app.model.role.Role;
import com.app.service.UsersService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        try {
            var context = new AnnotationConfigApplicationContext(AppSpringConfig.class);

            var usersService = context.getBean("usersService", UsersService.class);

            var username1
                    = usersService.register(new CreateUserDto("u", "1234", Role.USER));
            System.out.println(usersService.login(username1, "1234"));

            var username2
                    = usersService.register(new CreateUserDto("a", "1234", Role.ADMIN));
            System.out.println(usersService.login(username2, "1234"));

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
