package br.com.letscode.cursosead.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorBcryptHash {
    public static void main(String[] args) {
        BCryptPasswordEncoder bcryp = new BCryptPasswordEncoder();
        System.out.println(bcryp.encode("aluno"));
    }
}
