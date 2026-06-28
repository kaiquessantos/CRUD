import java.util.ArrayList;

public class Service {

        private ArrayList<User> usuarios;
        public Service(ArrayList<User> usuarios) {
            this.usuarios = usuarios;
        }

        public boolean create(User usuario) {
            if (!Validador.validarNome(usuario.getNome())) {
                return false;
            }

            if (!Validador.validarIdade(usuario.getIdade())) {
                return false;
            }

            if (!Validador.validarEmail(usuario.getEmail())) {
                return false;
            }

            usuarios.add(usuario);

            return true;

        }

        public ArrayList<User> read() {
            return usuarios;
        }

        public boolean update(int id, String nomeNovo) {
            User usuarioEncontrado = buscaPorId(id);

            if (usuarioEncontrado == null) {
                return false;
            }

            if (!Validador.validarNome(nomeNovo)){
                return false;
            }

            usuarioEncontrado.setNome(nomeNovo);
            return true;

        }

        public boolean delete(int id) {
            User usuarioEncontrado = buscaPorId(id);

            if (usuarioEncontrado == null) {
                return false;
            }

            usuarios.remove(usuarioEncontrado);
            return true;
        }

        private User buscaPorId (int id ) {

            for (User usuario : usuarios) {
                if (usuario.getId() == id) {
                    return usuario;
                }
            }
            return null;

        }


}
