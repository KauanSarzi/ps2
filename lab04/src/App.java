import java.sql.*;

public class App {
    static final String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.zcesyhesrgaysrlwrewz&password=C0UypOOwzBzOhfwE";


    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(URL);
            System.out.println("Conectado com sucesso!");
            
            listarContas(conexao);
            criarConta(conexao, 999, 1000.00);
            atualizarSaldo(conexao, 999, 1500.00);
            removerConta(conexao, 123);
            
            conexao.close();

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarContas(Connection conexao) throws SQLException {
        String sql = "SELECT * FROM contas";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        System.out.println("Contas cadastradas:");
        while (rs.next()) {
            long nroConta = rs.getLong("nro_conta");
            double saldo = rs.getDouble("saldo");
            System.out.println("Conta: " + nroConta + " | Saldo: R$ " + saldo);
        }
    }

    public static void criarConta(Connection conexao, long nroConta, double saldo) throws SQLException {
        String sql = "INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setLong(1, nroConta);
        stm.setDouble(2, saldo);
        stm.executeUpdate();
        System.out.println("Conta criada com sucesso.");
    }

    public static void atualizarSaldo(Connection conexao, long nroConta, double novoSaldo) throws SQLException {
        String sql = "UPDATE contas SET saldo = ? WHERE nro_conta = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setDouble(1, novoSaldo);
        stm.setLong(2, nroConta);
        stm.executeUpdate();
        System.out.println("Saldo atualizado com sucesso.");
    }

    public static void removerConta(Connection conexao, long nroConta) throws SQLException {
        String sql = "DELETE FROM contas WHERE nro_conta = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setLong(1, nroConta);
        stm.executeUpdate();
        System.out.println("Conta removida com sucesso.");
    }
}
