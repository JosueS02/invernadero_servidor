package servidor.invernadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 🟢 EL MAPA MAESTRO: Le decimos a Spring que escanee TODAS tus carpetas raíz
@SpringBootApplication(scanBasePackages = {
    "servidor.invernadero", 
    "config", 
    "controller", 
    "service", 
    "security", 
    "broker", 
    "websocket"
})
// 🟢 Le decimos dónde están las Entidades de la Base de Datos
@EntityScan(basePackages = {"model.entity"})
// 🟢 Le decimos dónde están todos tus Repositorios (el que estaba causando el error)
@EnableJpaRepositories(basePackages = {"repository"})
public class InvernaderoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvernaderoApplication.class, args);
    }
}