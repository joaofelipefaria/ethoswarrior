package ethoswarrior.lu.apps.bandwarrior.database;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Properties;

public class DatabaseSetup {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Por favor, forneça um parâmetro válido: CREATE ou POPULATE.");
			return;
		}

		String operation = args[0].toUpperCase(); // Converte para maiúsculo para garantir que a entrada seja tratada
													// corretamente.
		System.out.println("*******************");
		System.out.println("********" + operation + "**********");
		System.out.println("*******************");
		// Verifica qual operação foi passada (CREATE ou POPULATE)
		if ("CREATE".equals(operation)) {
			executeSqlFile("scripts/create_tables.sql");
		} else if ("POPULATE".equals(operation)) {
			executeSqlFile("scripts/populate_tables.sql");
		} else {
			System.out.println("Operação inválida. Use 'CREATE' ou 'POPULATE'.");
		}
	}

	private static void executeSqlFile(String fileName) {
		// Carrega as propriedades do arquivo application.properties
		Properties properties = loadProperties();

		String url = properties.getProperty("spring.datasource.url");
		String username = properties.getProperty("spring.datasource.username");
		String password = properties.getProperty("spring.datasource.password");

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Conectado ao banco de dados.");

			// Lê o arquivo SQL e executa
			String sql = readSqlFile(fileName);
			try (Statement stmt = conn.createStatement()) {
				stmt.execute(sql);
				System.out.println("Arquivo SQL executado com sucesso: " + fileName);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private static String readSqlFile(String fileName) throws IOException {
		// Lê o arquivo SQL e retorna como String
		StringBuilder sql = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				DatabaseSetup.class.getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				sql.append(line).append("\n");
			}
		}
		return sql.toString();
	}

	private static Properties loadProperties() {
		// Carrega as propriedades do arquivo application.properties
		Properties properties = new Properties();
		try (InputStream input = DatabaseSetup.class.getClassLoader().getResourceAsStream("application.properties")) {
			if (input == null) {
				System.out.println("Desculpe, não foi possível encontrar o arquivo application.properties.");
				return properties;
			}
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return properties;
	}
}
