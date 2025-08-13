package br.com.desiree.saude;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraIMC_TMB {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Entrada de dados do usuário
		
		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
		
		System.out.print("Digite seu sexo (M/F): ");
		char sexo = sc.next().toUpperCase().charAt(0);
		
		System.out.println("Digite seu peso (kg): ");
		double peso = sc.nextDouble();
		
		System.out.println("Digite sua altura (m): ");
		double altura = sc.nextDouble();
		
		System.out.println("Nível de atividade física:");
		System.out.println("1 - Sedentário");
		System.out.println("2 - Ativo regularmente (pelo menos 3x na semana)");
		System.out.println("3 - Ativo frequentemente (4-5x na semana)");
		int nivelAtividade = sc.nextInt();
		
		// Cálculo IMC
		
		double imc = peso / (altura * altura);
		
		// Cálculo TMB 
		
		double alturaCm = altura * 100;
		double tmb;
		if (sexo == 'M') {
			tmb = 66 + (13.7 * peso) + (5 * alturaCm) - (6.8 * idade);
		} else {
			tmb = 655 + (9.6 *  peso) + (1.8 * alturaCm) - (4.7 * idade);
		}
		
		// Calorias recomendadas 
		
		double caloriasDiarias;
		String descricaoAtividade;
		switch (nivelAtividade) {
		
		case 1: 
			caloriasDiarias = tmb * 1.2;
			descricaoAtividade = "Sedentário";
			break;	
		case 2: 
			caloriasDiarias = tmb * 1.55;
			descricaoAtividade = "Ativo regularmente";
			break;
		case 3:
			caloriasDiarias = tmb * 1.725;
			descricaoAtividade = "Ativo frequentemente";
			break;
		default: 
			caloriasDiarias = tmb;
			descricaoAtividade = "Não informado";
		}
		
		// Saída dos Resultados 
		
		System.out.println("\n===== RESULTADOS =====");
		System.out.printf("Nome: %s%n", nome);
		System.out.printf("IMC: %.2f%n", imc);
		System.out.printf("TMB: %.2f kcal/dia%n", tmb);
		System.out.printf("Nível de Atividade: %s%n", descricaoAtividade);
		System.out.printf("Calorias recomendadas por dia: %.0f kcal%n", caloriasDiarias);
		
		// Classificação IMC 
		
		if (imc < 18.5) {
			System.out.println("Classificação IMC: Abaixo do peso");
		} else if (imc < 25) {
			System.out.println("Classificação IMC: Peso normal");
		} else if (imc < 30) {
			System.out.println("Classificação IMC: Sobrepeso");
		} else if (imc < 35) {
			System.out.println("Classificação IMC: Obesidade Grau I");
		} else if (imc < 40) { 
			System.out.println("Classificaçãp IMC: Obesidade Grau II");
		} else {
			System.out.println("Classificação IMC: Obesidade Grau III (mórbida)");
		}
		
		sc.close();
		

		
		
		
 
	}

}
