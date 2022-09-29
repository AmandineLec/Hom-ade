package fil.rouge.sécurité;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import fil.rouge.service.RoleService;

@Component
public class RoleListener implements ApplicationListener<ApplicationContextEvent> {

    @Autowired
    RoleService rService;

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        // rService.createRoleIfNotExists("licorne");
    }
}
