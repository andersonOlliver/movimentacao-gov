
import javax.persistence.Persistence;

public class CriarTabelas {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("movimentacaoPU");
        System.exit(0);
    }

}
    