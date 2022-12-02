# Cadastro-Alunos
Programa Java para cadastro de alunos

São dois programas diferentes criados em Eclipse

-----------------------------------------------------------  

	Cadastro de Alunos 01

  	-Código não modularizado
 	-Código com Menu de seleção numérica
  	-Código utiliza biblioteca JOptionPane
  	-Código utiliza vetores e matrizez
  
 	-É possível cadastrar novos alunos
  	-Exibir lista de alunos cadastrados
  	-Exibir percentual de alunos por sexo
  	-Exibir média das idades dos alunos
  	-Exibir lista de alunos por sexo
  	-Exibir lista de alunos por idade
  
-----------------------------------------------------------  
  
Cadastro de Alunos 02

 	 Código Modularizado
  Código com menu de seleção númerica
  Código utiliza biblioteca JOptionPane
  Código utiliza ArrayList
  
  	PrincipalAluno:
    	Parte principal do código
			Menu de seleção
    		Cadastro de alunos
    		Listagem de alunos
  			Listagem por média
    		Listagem por idade
    		Filtro por situação (Reprovado, aprovado e recuperação)
    		Busca por sexo
    		Busca por cidade
    		Busca excludente por cidade
    		Busca por nome
   
	
	Aluno:
 		Cadastro do aluno na array:
			String nome;
			char sexo;
			int idade;
			double nota1;
			double nota2;
			double nota3;
      		double media;
      		String cidade;
      		String situacao;
