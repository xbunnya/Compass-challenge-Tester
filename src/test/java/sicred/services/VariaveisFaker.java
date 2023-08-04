package sicred.services;

import com.github.javafaker.Faker;
import lombok.Getter;

//// armazena variaveis faker que serão utilizadas nos testes
@Getter
public class VariaveisFaker {
    final Faker faker = new Faker();
    public String nome = faker.name().fullName();
    public String email = faker.internet().emailAddress();
    public String cpf = faker.number().digits(11);
    public long valor = faker.number().numberBetween(1000L, 40001L);
    public boolean seguro = faker.bool().bool();
    public String nomeProduto = faker.book().title();
    public int parcelas = faker.number().numberBetween(2, 48);

}
