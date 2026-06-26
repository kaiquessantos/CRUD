public class Validador {

    public static boolean validarNome(String nome) {
        if (nome.isBlank()) {
            System.out.println("Nome Inválido!");
            return false;
        }
        return true;
    }

    public static boolean validarIdade(int idade) {
        if (idade <= 0) {
            System.out.println("Idade Inválida!");
            return false;
        }
        return true;
    }

    public static boolean validarEmail(String email) {
        if (!email.contains("@")) {
            System.out.println("E-mail inválido!");
            return false;
        }
        return true;
    }

}
