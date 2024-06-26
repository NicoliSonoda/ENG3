package Strategy;

import Dominio.Categoria;
import Dominio.EntidadeDominio;
import Dominio.Livro;
import java.util.List;

public class AssociarCateg implements IStrategy {

    @Override
    public String processsar(EntidadeDominio entidade) {
        if (entidade instanceof Livro) {
            Livro livro = (Livro) entidade;
            List<Categoria> categorias = livro.getCategorias();

            if (categorias == null || categorias.isEmpty()) {
                return "O livro deve estar associado a pelo menos uma categoria.";
            }
        }
        return null;
    }


}
