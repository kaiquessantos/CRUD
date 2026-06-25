import java.util.ArrayList;

public class User {

    //O contador deve ser estático, pois ele pertence à CLASSE, não ao OBJETO
    private static int contador = 1;

    private int id;
    private String nome;
    private String email;
    private int idade;


    public User(String nome, String email, int idade) {
        this.id = contador++;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    //Get

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    //Set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nIdade: " + idade;

    }

    public static User buscaPorId (ArrayList<User>usuarios,int id ) {

        for (User usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.println(usuario);
                return usuario;
            }
        }
        return null;

    }



}
