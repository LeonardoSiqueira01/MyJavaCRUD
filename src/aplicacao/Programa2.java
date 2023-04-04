package aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelo.dao.ConsultaDao;
import modelo.dao.DaoFactory;
import modelo.dao.PacienteDao;
import modelo.entidade.Consulta;
import modelo.entidade.Paciente;

public class Programa2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConsultaDao consultaDao = DaoFactory.criarNovaConsultaDao();
		PacienteDao pacientedao = DaoFactory.criarPacienteDao();
		Paciente Paciente = new Paciente();

		System.out.println("Deseja ver a lista de pacientes ? (S/N)");
		char opcao = sc.next().charAt(0);
		if (opcao == 's' || opcao == 'S') {
			List<Paciente> lista = new ArrayList<>();
			lista = pacientedao.findAll();
			for (Paciente list : lista) {
				System.out.println(list);

			}}

			System.out.println("Informe o id do paciente que ira se consultar:");
			int id = sc.nextInt();
			Paciente = pacientedao.findById(id);
			Consulta consulta = new Consulta(null, new Date(), new Date(), 300.0, Paciente);

			consultaDao.insert(consulta);
			System.out.println("Nova consulta. Id da Consulta = " + consulta.getIdConsulta());

			sc.close();

	}
}