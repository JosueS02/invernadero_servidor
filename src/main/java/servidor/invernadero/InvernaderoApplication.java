package servidor.invernadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 🟢 EL CAMBIO ESTÁ AQUÍ: Agregamos scanBasePackages para que lea la carpeta "config"
@SpringBootApplication(scanBasePackages = {"servidor.invernadero", "config", "controller"})
@EntityScan(basePackages = {"model.entity"})
@EnableJpaRepositories(basePackages = {"repository"})
public class InvernaderoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvernaderoApplication.class, args);
    }

}