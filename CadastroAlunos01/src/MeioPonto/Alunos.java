package MeioPonto;

import javax.swing.JOptionPane;

public class Alunos {
		static int Max = 20, cont = 0, a = 0, Masc = 0, Fem = 0;
		static String aluno[] = new String[Max];
		static double notas[][] = new double[Max][3];
		static char sexo[] = new char[Max];
		static int idade[] = new int[Max];
		static double media[] = new double[Max];
		static String aprovado[] = new String[Max];
		static String reprovado[] = new String[Max];
		static String recuperacao[] = new String[Max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int Menu() {
		
		String menu = "1 - Cadastrar aluno \n"
					+ "2 - Exibir alunos \n"
					+ "3 - Percentual por sexo \n"
					+ "4 - Média de idades"
					+ "5 - Lista por sexo \n"
					+ "6 - Lista por idade \n";
			
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	
	private static void cadastro() {
		if (cont < 20) {
			
			aluno[cont] = JOptionPane.showInputDialog("Insira o nome do aluno");
			sexo[cont] = JOptionPane.showInputDialog("Insira o sexo do aluno\nF-Feminino M-Masculino").toUpperCase().charAt(0);
			idade[cont] = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade do aluno"));
			
			
			for (int i = cont; i == cont; i++) {
				for (int j = 0; j < 3; j++) {
					notas[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Insira a " + (i+1) + "° nota do aluno"));
				}
			}
			
			calculaMedia();
			cont++;
		}
		
	}
	
	private static void calculaMedia() {
		
		for (int j = 0; j < 3; j++) {
			
			media[a] += notas[cont][j];			
		}
		
		media[a] = media[a]/3;
		
		if (media[a] >= 7 ) {
			aprovado[a] = aluno[a];
		}else{
			if (media[a] > 3 ) {
				recuperacao[a] = aluno[a];
			}else{
				reprovado[a] = aluno[a];
			}
		}
			
		a++;
		
	}
		
	
	
	private static void PCsexo() {
		
		for (int i = 0; i < cont; i++) {
			if (sexo[i] == 'M') {
				Masc++;
			}else{
				Fem++;
			}
		}
		
			
		
		JOptionPane.showMessageDialog(null, "O percentual de homens reprovados é igual a: ");
		}
}
