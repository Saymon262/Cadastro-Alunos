package saymon;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class principalAluno {
	
	private static ArrayList<aluno> alunos = new ArrayList<>();
	

	public static void main(String[] args) {

		int op = 1;
		
		while (op != 0) {
			
			op = menu();
			
			if(op == 1) Cadastro();
			if(op == 2) VerAlunos();
			if(op == 3) OrdemMedia();
			if(op == 4) OrdemIdade();
			if(op == 5) Situacao();
			if(op == 6) BuscaSexo();
			if(op == 7) BuscaCidade();
			if(op == 8) BuscaCidadeInversa();
			if(op == 9) BuscaNome();
		}
	}
	
	
	
	private static int menu() {
		
		String menu = "1 - Cadastrar aluno             \n"
					+ "2 - Ver lista de alunos         \n"
					+ "3 - Ordernar alunos por média   \n"
					+ "4 - Ordernar alunos por idade   \n"
					+ "5 - Buscar por situação         \n"
					+ "6 - Buscar por sexo             \n"
					+ "7 - Buscar por cidade           \n"
					+ "8 - Exclusão por cidade         \n"
					+ "9 - Buscar por nome           \n\n"
					+ "0 - SAIR";
		
		return Integer.parseInt(JOptionPane.showInputDialog(menu).trim());
	}
	
	
	
	private static void Cadastro() {
		
		aluno a = new aluno();
		
		a.nome = JOptionPane.showInputDialog("Nome do aluno");
		ValidaNome(a);
		
		a.sexo = JOptionPane.showInputDialog("Sexo do aluno\nM para masculino\nF para feminino").toUpperCase().charAt(0);
		ValidaSexo(a);
		
		a.idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do aluno"));
		ValidaIdade(a);
		
		a.nota1 = Double.parseDouble(JOptionPane.showInputDialog("Primeira nota do aluno"));
		ValidaNota1(a);
		
		a.nota2 = Double.parseDouble(JOptionPane.showInputDialog("Segunda nota do aluno"));
		ValidaNota2(a);
		
		a.nota3 = Double.parseDouble(JOptionPane.showInputDialog("Terceira nota do aluno"));
		ValidaNota3(a);
		
		CalculaMedia(a);
		
		a.cidade = JOptionPane.showInputDialog("Cidade onde o aluno reside");
		
		alunos.add(a);
	}
	
	private static void CalculaMedia(aluno a) {
		
		a.media = ((a.nota1 + a.nota2 + a.nota3)/3)*10;
		a.media = (Math.ceil(a.media))/10;

		
		if (a.media > 7) {
			a.situacao = "Aprovado";
		}else{
			if (a.media > 2) {
				a.situacao = "Recuperação";
			}else{
				a.situacao = "Reprovado";
			}
		}
	}
		
	private static void VerAlunos() {
		
		
		String resultado = "";
		
		for (int i = 0; i < alunos.size(); i++) {
			resultado += ("\n\nNome: " + alunos.get(i).nome + "\nMedia: " + alunos.get(i).media + "\nSituação: " + alunos.get(i).situacao);
		}
		
		JOptionPane.showMessageDialog(null, "Alunos cadastrados: " + resultado);
		
	}
	
	private static void Situacao() {
		
		int op2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções para buscar alunos:"
															+ "\n1 - Aprovados\n2 - Recuperaçâo\n3 - Reprovados"));
		
		String Resultado = "";
		
		OrdemMedia();
		
		if (op2 == 1) {
			for(int i = 0; i < alunos.size(); i++) {
				if ( alunos.get(i).situacao.equals("Aprovado")) {
					Resultado += alunos.get(i).nome + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, Resultado);
		}
		
		if (op2 == 2) {
			for(int i = 0; i < alunos.size(); i++) {
				if ( alunos.get(i).situacao.equals("Recuperação")) {
					Resultado += alunos.get(i).nome + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, Resultado);
		}
		
		if (op2 == 3) {
			for(int i = 0; i < alunos.size(); i++) {
				if ( alunos.get(i).situacao.equals("Reprovado")) {
					Resultado += alunos.get(i).nome + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, Resultado);
		}
		
		
	}

	
	private static void BuscaSexo() {
		
		if (VerificaArrayVazia() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado");
		}
		else {
			
			
		OrdemIdade();
			
		
		char opSexo = JOptionPane.showInputDialog("Escolha uma das opções para buscar alunos:"
						           + "\nM - Masculino\nF - Feminino").toUpperCase().charAt(0);
		
		
		String Resultado = "";
		
		
		if (opSexo == 'M') {
		    for (int i = 0; i < alunos.size(); i++) {
				if (alunos.get(i).sexo == ('M')) {
					Resultado += alunos.get(i).nome + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, "Alunos do sexo masculino: \n\n" + Resultado);
		}
		
		
		if (opSexo == 'F') {
			for (int i = 0; i < alunos.size(); i++) {
				if (alunos.get(i).sexo == ('F')) {
					Resultado += alunos.get(i).nome + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, "Alunos do sexo feminino: \n\n" +  Resultado);
			}
		}
	}
	
	private static void BuscaCidade() {
				
		
		if (VerificaArrayVazia() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado");
		}
		else {
		
			
		int contador = 0;
		
		String BuscaCidade = JOptionPane.showInputDialog("Insira o nome da cidade que deseja buscar");
		String Resultado = "";
		
		
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).cidade.equals(BuscaCidade)) {
				Resultado += "\nNome: " + alunos.get(i).nome + "\nCidade: " + alunos.get(i).cidade + "\n\n";
				contador++;
			}
		}
		
		
		if (contador == 0) {
			JOptionPane.showMessageDialog(null, "Cidade não encontrada");
		}
		else {
			JOptionPane.showMessageDialog(null, "Alunos da cidade pesquisada: " + Resultado);
		}
		
		
		}
	}
	
	private static void BuscaCidadeInversa() {
		
		
		if (VerificaArrayVazia() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado");
		}
		else {
			
		int contador = 0;
		String BuscaCidade = JOptionPane.showInputDialog("Insira o nome da cidade que deseja buscar");
		String Resultado = "";
		
		
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).cidade.equals(BuscaCidade)) {
			}
			else {
				Resultado += "Aluno: " + alunos.get(i).nome + "\nCidade: " + alunos.get(i).cidade + "\n\n";
				contador++;
			}
		}
		
		
		if (contador == 0) {
			JOptionPane.showMessageDialog(null, "Nenhuma cidade encontrada");
		}
		else {
		JOptionPane.showMessageDialog(null, "Alunos encontrados: \n\n" + Resultado);
		}
		
		
		}
	}

	private static void BuscaNome() {
		
		
		OrdemNome();
		
		
		String BuscaNome = JOptionPane.showInputDialog("Insira o nome do aluno que deseja buscar");
		int p = 0;
		int u = alunos.size()-1;
		int m = (p+u)/2;
		
		
		if (alunos.get(p).nome.equals(BuscaNome)) {
			JOptionPane.showMessageDialog(null, alunos.get(p).nome);
		} 
		else {
			if (alunos.get(u).nome.equals(BuscaNome)) {
				JOptionPane.showMessageDialog(null, alunos.get(u).nome);
			}
			else {
				if (alunos.get(m).nome.equals(BuscaNome)) {
					JOptionPane.showMessageDialog(null, alunos.get(m).nome);
				}
				else {
		
					while  ( p!=u && m!=u ) {		    
						if (alunos.get(m).nome.charAt(0) < BuscaNome.charAt(0)) {
							p = m;
							m = (p+u)/2;
						}
			
						if (alunos.get(m).nome.charAt(0) > BuscaNome.charAt(0)) {
							u = m;
							m = (p+u)/2;
						}
						
						if (alunos.get(m).nome.equals(BuscaNome)) {
							JOptionPane.showMessageDialog(null, alunos.get(m).nome);
							p = u;
						}
					}
				}
			}	
		}
	}

	
	private static void OrdemMedia() {
		
		int pos = 0;
		int ultima = alunos.size()-1;
		aluno aux = new aluno();
		while(ultima != 0) {
			while(pos != ultima) {
				if(alunos.get(pos).media > alunos.get(pos+1).media) {
					aux = alunos.get(pos);
					alunos.set(pos, alunos.get(pos+1));
					alunos.set(pos+1, aux);
				}
				pos++;
			}
			pos = 0;
			ultima --;
		}
	JOptionPane.showMessageDialog(null, "Alunos ordernados por média\nVer listagem\n[Opção 1]");
	}

	private static void OrdemIdade() {
		
		int pos = 0;
		int ultima = alunos.size()-1;
		aluno aux = new aluno();
		while(ultima != 0) {
			while(pos != ultima) {
				if(alunos.get(pos).idade > alunos.get(pos+1).idade) {
					aux = alunos.get(pos);
					alunos.set(pos, alunos.get(pos+1));
					alunos.set(pos+1, aux);
				}
				pos++;
			}
			pos = 0;
			ultima --;
		}
	}
	
	private static void OrdemNome() {
		
		int pos = 0;
		int ultima = alunos.size()-1;
		aluno aux = new aluno();
		while(ultima != 0) {
			while(pos != ultima) {
				if(alunos.get(pos).nome.charAt(0) > alunos.get(pos+1).nome.charAt(0)) {
					aux = alunos.get(pos);
					alunos.set(pos, alunos.get(pos+1));
					alunos.set(pos+1, aux);
				}
				pos++;
			}
			pos = 0;
			ultima --;
		}
	}

	
	private static String ValidaNome(aluno a) {
		
		String nome = a.nome;
		
		if(nome.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome precisa ser preenchido");
			a.nome = JOptionPane.showInputDialog("Insira um nome");
			
			ValidaNome(a);		
		}
		
	 // if (Character.isDigit(nome.trim().charAt(0)) == true) {
		  //JOptionPane.showMessageDialog(null, "Nome inválido\nDeve iniciar com letras");
		  //a.nome = JOptionPane.showInputDialog("Nome do aluno");
		
		  //ValidaNome(a);	
	 // }	 

		return nome;
	}

	private static char   ValidaSexo(aluno a) {
		
		char sexo = a.sexo;
		
		if(sexo != 'M' && sexo != 'F') {
			JOptionPane.showMessageDialog(null, "Sexo inválido - apenas M ou F");
			a.sexo = JOptionPane.showInputDialog("Sexo").toUpperCase().charAt(0);
			
			ValidaSexo(a);
		}
		
		return sexo;
	}

	private static void  ValidaIdade(aluno a) {
		
		int idade = a.idade;
		if(idade<18 || idade > 99) {
			JOptionPane.showMessageDialog(null, "Idade inválida\nApenas idades entre 18 e 99");
			a.idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
			ValidaIdade(a);
		}
	}

	
	private static double ValidaNota1(aluno a) {
		
		double nota1 = a.nota1;
		
		if(nota1 < 0 || nota1 > 10) {
			JOptionPane.showMessageDialog(null, "Nota inválida\nApenas notas entre 0 e 10");
			a.nota1 = Double.parseDouble(JOptionPane.showInputDialog("nota"));
			ValidaNota1(a);
		}
		return nota1;
	}

	private static double ValidaNota2(aluno a) {
		
		double nota2 = a.nota2;
		
		if(nota2 < 0 || nota2 > 10) {
			JOptionPane.showMessageDialog(null, "Nota inválida\nApenas notas entre 0 e 10");
			a.nota2 = Double.parseDouble(JOptionPane.showInputDialog("nota"));
			ValidaNota2(a);
		}
		return nota2;
	}
	
	private static double ValidaNota3(aluno a) {
		
		double nota3 = a.nota3;
		
		if(nota3 < 0 || nota3 > 10) {
			JOptionPane.showMessageDialog(null, "Nota inválida\nApenas notas entre 0 e 10");
			a.nota3 = Double.parseDouble(JOptionPane.showInputDialog("nota"));
			ValidaNota3(a);
		}
		return nota3;
	}

	
	private static int VerificaArrayVazia() {
		
		int contagem = 0;
		
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).sexo == 'M' || alunos.get(i).sexo == 'F') {
				contagem++;
			}
		}
		
		return contagem;
		
	}	
}
