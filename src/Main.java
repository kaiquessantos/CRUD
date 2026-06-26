import java.util.Scanner;
import java.util.ArrayList;

    public static void main (String[] args) {


        ArrayList<User> usuarios = new ArrayList<>();
        User usuarioEncontrado = null;
        int buscaID = 0;

        boolean sair = false;
        while (!sair) {

            System.out.println("Welcome");
            System.out.println("""
                    Digite 1 - Cadastro
                    Digite 2 - Listar Usuários
                    Digite 3 - Editar Usuário
                    Digite 4 - Deletar Usuário
                    Digite 0 - Sair""");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                //Create
                case 1:

                        System.out.println("Para começar, vamos criar o seu Usuário!");

                        boolean nomeUser = false;
                        String nome = null;

                        while (!nomeUser) {
                            System.out.print("Primeiramente digite o seu nome:");
                            nome = scanner.nextLine();

                            nomeUser = Validador.validarNome(nome);

                        }

                        boolean emailUser = false;
                        String email = null;

                        while (!emailUser) {
                            System.out.print("Seu e-mail:");
                            email = scanner.nextLine();

                            emailUser = Validador.validarEmail(email);
                        }

                        boolean idadeUser = false;
                        int idade = 0;

                        while (!idadeUser) {
                            System.out.print("Sua idade:");
                            idade = scanner.nextInt();
                            scanner.nextLine();

                            idadeUser = Validador.validarIdade(idade);

                        }

                        User novoUsuario = new User(nome,email,idade);
                        usuarios.add(novoUsuario);

                    break;

                //Read
                case 2:

                    if(usuarios.isEmpty()){
                        System.out.println("Nenhum usuário cadastrado!");
                    }
                    else {

                        for (User usuario : usuarios) {
                            System.out.println(usuario);
                            System.out.println();
                        }

                    }

                    break;

                //Update
                case 3:

                    boolean update = false;
                    while (!update) {

                        System.out.println("Para alterar o nome digite 1!" + "\nPara alterar o e-mail digite 2!" +
                                 "\nPara alterar a idade digite 3!" + "\nDigite 0 para sair.");
                        int upChoice = scanner.nextInt();
                        switch (upChoice){

                            case 1:

                                System.out.print("Digite o ID de usuário para alteração do nome:");
                                buscaID = scanner.nextInt();
                                scanner.nextLine();
                                usuarioEncontrado = User.buscaPorId(usuarios, buscaID);


                                        if (usuarioEncontrado == null) {

                                            System.out.println("Usuário não encontrado!");

                                            }
                                        else {

                                            boolean trocaNome = false;
                                            while (!trocaNome) {
                                                String nomeNovo = null;
                                                System.out.print("Digite sua alteração:");
                                                nomeNovo = scanner.nextLine();
                                                if (nomeNovo.isEmpty()) {
                                                    System.out.println("Nome Inválido!");
                                                }
                                                else {
                                                    usuarioEncontrado.setNome(nomeNovo);
                                                    System.out.println("Alteração bem sucedida!");
                                                    update = true;
                                                    trocaNome = true;
                                                }

                                            }
                                        }

                                break;

                            case 2:

                                System.out.print("Digite o ID de usuário para alteração do e-mail:");
                                buscaID = scanner.nextInt();
                                scanner.nextLine();
                                usuarioEncontrado = User.buscaPorId(usuarios, buscaID);

                                        boolean trocaEmail = false;
                                        while (!trocaEmail) {

                                            String emailNovo = null;
                                            System.out.print("Digite sua alteração:");
                                            emailNovo = scanner.nextLine();
                                            if (!emailNovo.contains("@")) {
                                                System.out.println("E-mail inválido!");
                                            }
                                            else {
                                                usuarioEncontrado.setEmail(emailNovo);
                                                System.out.println("Alteração bem sucedida!");
                                                update = true;
                                                trocaEmail = true;
                                            }

                                        }

                                break;

                            case 3:

                                System.out.print("Digite o ID de usuário para alteração da idade:");
                                buscaID = scanner.nextInt();
                                scanner.nextLine();
                                usuarioEncontrado = User.buscaPorId(usuarios, buscaID);

                                        boolean trocaIdade = false;
                                        while (!trocaIdade) {

                                            int idadeNova = 0;
                                            System.out.print("Digite sua alteração:");
                                            idadeNova = scanner.nextInt();
                                            scanner.nextLine();
                                            if (idadeNova <= 0) {
                                                System.out.println("Idade Inválida!");
                                            }
                                            else {
                                                usuarioEncontrado.setIdade(idadeNova);
                                                System.out.println("Alteração bem sucedida!");
                                                update = true;
                                                trocaIdade = true;
                                            }

                                        }

                                break;

                            case 0:
                                update = true;
                                break;

                        }

                    }

                    break;

                //Delete
                case 4:

                    boolean deleteUsuario = false;
                    while (!deleteUsuario) {

                        System.out.print("Digite o ID do Usuário a ser deletado:");
                        buscaID = 0;
                        buscaID = scanner.nextInt();
                        scanner.nextLine();
                        usuarioEncontrado = User.buscaPorId(usuarios, buscaID);

                                if (usuarioEncontrado != null) {

                                    boolean deleting = false;
                                    while (!deleting) {
                                        int deletingUser = 0;

                                        System.out.println("Deseja realmente deletar este usuário?" +
                                                "\nDigite 1 para SIM." + "\nDigite 0 para CANCELAR OPERAÇÃO.");
                                        deletingUser = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (deletingUser) {

                                            case 1:

                                                usuarios.remove(usuarioEncontrado);
                                                deleting = true;
                                                deleteUsuario = true;
                                                System.out.println("Usuário deletado com sucesso.");

                                                break;

                                            case 0:
                                                deleting = true;
                                                deleteUsuario = true;
                                                break;

                                        }

                                    }



                                }

                                else {
                                    System.out.println("Usuário não encontrado tente novamente.");
                                }

                    }

                    break;

                //Back
                case 0:
                    sair = true;
                    break;


            }

            System.out.println();

        }




}