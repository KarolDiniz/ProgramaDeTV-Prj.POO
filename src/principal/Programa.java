package principal;

import java.util.List;
import java.util.Scanner;

import agencias.CentralDeInformacoes;
import agencias.GeradorDeRelatorios;
import agencias.Mensageiro;
import agencias.Persistencia;
import enums.DiaDaSemana;
import enums.TipoDePrograma;
import transmissao.Canal;
import transmissao.ProgramaDeTV;


public class Programa {
	
	public static void main(String[] args) throws Exception {
		
		Scanner ler = new Scanner(System.in);
		Persistencia p = new Persistencia();
		CentralDeInformacoes c = p.recuperarCentral();
		boolean sair = false;
		
		while(sair == false) {
			System.out.println("");
			System.out.println(" O QUE DESEJA FAZER: ");		
			System.out.println(" 1 - CADASTRAR NOVO PROGRAMA. ");
			System.out.println(" 2 - LISTAR TODOS OS PROGRAMAS. ");
			System.out.println(" 3 - LISTAR TODOS OS PROGRAMAS DE UM MESMO TIPO. ");
			System.out.println(" 4 - NOVO CANAL DE TELEVIS�O. ");
			System.out.println(" 5 - LISTAR TODOS OS CANAIS DE TELEVIS�O. ");
			System.out.println(" 6 - GERAR RELAT�RIO. ");
			System.out.println(" 7 - ENVIAR PROGRAMA��O DE HOJE POR E-MAIL. ");
			System.out.println(" S - SAIR ");
			System.out.println("");
			System.out.println("DIGITE O NUM�RO DA OP��O OU S CASO QUEIRA SAIR: ");
			String opc = ler.nextLine();
			
			if (opc.equals("1")) {
					
					System.out.println("DIGITE O NOME DO PROGRAMA DE TV: ");
					String nomeDoPrograma = ler.nextLine();
					
					TipoDePrograma tipoDePrograma = null;
					boolean tipoDeProgramaInicia = true;
					Canal canal = null;
					while(tipoDeProgramaInicia == true) {
					
					System.out.println("QUAL O TIPO DO PROGRAMA: ");
					System.out.println("1 - SERIE REGULAR. ");
					System.out.println("2 - REALITY SHOW. ");
					System.out.println("3 - PROGRAMA CONTINUO. ");
					System.out.println("DIGITE UMA DAS OP��ES: ");
					String opcaoPrograma = ler.nextLine();
					
						if(opcaoPrograma.equals("1")) {
							tipoDePrograma = TipoDePrograma.SERIES_REGULARES; 
							tipoDeProgramaInicia = false;
							
						}else if(opcaoPrograma.equals("2")) {
							tipoDePrograma = TipoDePrograma.REALITY_SHOWS;
							tipoDeProgramaInicia = false;
							
						}else if(opcaoPrograma.equals("3")) {
							tipoDePrograma = TipoDePrograma.PROGRAMAS_CONTINUOS;
							tipoDeProgramaInicia = false;
							
						}else {
						
							System.out.println("OP��O INV�LIDA.");
						}
						
					}

					DiaDaSemana[] diaDaSemana = new DiaDaSemana[7];
					boolean diaDaSemanaIniciar = true;
					
					while(diaDaSemanaIniciar == true) {
						System.out.println("ESSE PROGRAMA DE TV � TRANSMITIDO EM QUANTOS DIAS NA SEMANA? ");
						int qtdDeDias = Integer.parseInt(ler.nextLine());
						boolean confirmacaoDoDia = true;
						
						while(confirmacaoDoDia == true) {
							if(qtdDeDias == 1) {
								System.out.println("QUAL O DIA DE SEMANA QUE ELE PASSA? (DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA OU SABADO). ");
								String diaDaSemanaInformado = ler.nextLine().toUpperCase();
								if(diaDaSemanaInformado.equals("SEGUNDA")) {
									diaDaSemana[0] = DiaDaSemana.SEGUNDA;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
									
								}else if(diaDaSemanaInformado.equals("TERCA")) {
									diaDaSemana[0] = DiaDaSemana.TERCA;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
								
								}else if(diaDaSemanaInformado.equals("QUARTA")) {
									diaDaSemana[0] = DiaDaSemana.QUARTA;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
								
								}else if(diaDaSemanaInformado.equals("QUINTA")) {
									diaDaSemana[0] = DiaDaSemana.QUINTA;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
								
								}else if(diaDaSemanaInformado.equals("SEXTA")) {
									diaDaSemana[0] = DiaDaSemana.SEXTA;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
								
								}else if(diaDaSemanaInformado.equals("SABADO")) {
									diaDaSemana[0] = DiaDaSemana.SABADO;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
								
								}else if(diaDaSemanaInformado.equals("DOMINGO")) {
									diaDaSemana[0] = DiaDaSemana.DOMINGO;
									confirmacaoDoDia = false;
									diaDaSemanaIniciar = false;
								
								}else {
									System.out.println("OP��O INV�LIDA:");
								}	
							}else {
									System.out.println("ESSE PROGRAMA PASSA EM MAIS DE UMA DIA NA SEMANA. ");
									
									for(int i = 0; i < qtdDeDias; i++) {
										System.out.println("QUAL � O "+ (i +1) + "� DIA QUE ESSE PROGRAMA PASSA?(DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA OU SABADO)");
										String diaDaSemanaInformado = ler.nextLine().toUpperCase();
										while(confirmacaoDoDia == true) {
											if(diaDaSemanaInformado.equals("SEGUNDA")) {
												diaDaSemana[i] = DiaDaSemana.SEGUNDA;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
										
											}else if(diaDaSemanaInformado.equals("TERCA")) {
												diaDaSemana[i] = DiaDaSemana.TERCA;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
									
											}else if(diaDaSemanaInformado.equals("QUARTA")) {
												diaDaSemana[i] = DiaDaSemana.QUARTA;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
									
											}else if(diaDaSemanaInformado.equals("QUINTA")) {
												diaDaSemana[i] = DiaDaSemana.QUINTA;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
									
											}else if(diaDaSemanaInformado.equals("SEXTA")) {
												diaDaSemana[i] = DiaDaSemana.SEXTA;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
												
											}else if(diaDaSemanaInformado.equals("SABADO")) {
												diaDaSemana[i] = DiaDaSemana.SABADO;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
									
											}else if(diaDaSemanaInformado.equals("DOMINGO")) {
												diaDaSemana[i] = DiaDaSemana.DOMINGO;
												confirmacaoDoDia = false;
												diaDaSemanaIniciar = false;
									
											}else {
										
												System.out.println("OP��O INV�LIDA:");
											}
										}
									}	
								}
							}					
						}
						
					boolean canalIniciar = true;
					boolean testeDeConfirmacao = false;
					while(canalIniciar == true) {
						
						System.out.println("#####CANAIS CADASTRADOS#####/n");
						for(Canal canalExistente: c.getTodosOsCanais()) {
							System.out.println(canalExistente.toString());
						}
						System.out.println("");
						System.out.println("ESSE PROGRAMA PASSA EM QUAL CANAL DE TV? ");
						System.out.println("SE O CANAL QUE DESEJA CADASTRAR N�O ESTIVER NA LISTA DE CANAIS, DIGITE 'S':  ");
						String canalPassado = ler.nextLine().toUpperCase();
						
						if (canalPassado.equals("S")){
							System.out.println("VOC� DEVE CADASTRAR UM CANAL PRIMEIRO. " );
							canalIniciar = false;
						}else {
							
							for(Canal canalExistente: p.recuperarCentral().getTodosOsCanais()) {
								if(canalExistente.getNome().equals(canalPassado)) {
									canal = canalExistente; 
									canalIniciar = false;
									testeDeConfirmacao = true;
									break;
								}
							}
							if(testeDeConfirmacao == false) {
								System.out.println("OP��O INV�LIDA.");
							}
						}
					}	
				if(testeDeConfirmacao == true) {		
					ProgramaDeTV programa = new ProgramaDeTV( nomeDoPrograma, tipoDePrograma, diaDaSemana, canal);
					c.adicionarProgramaDeTV(programa);
					p.salvarCentral(c);
					System.out.println("");	
					System.out.println("PROGRAMA CADASTRADO COM SUCESSO!");
					System.out.println("");
				}else {
					System.out.println("CADASTRO DE PROGRAMA INCOMPLETO.");
				}
			}else if(opc.equals("2")){
				List<ProgramaDeTV> programasDeTV = c.getTodosOsProgramas();
				System.out.println("###### PROGRAMAS DE TV #####");
				
				for(ProgramaDeTV programaPassado: programasDeTV) {
					System.out.println(programaPassado.toString());
				}
			}else if(opc.equals("3")) {
				List<ProgramaDeTV> programasDeTV = c.getTodosOsProgramas();
				System.out.println("###### PROGRAMAS DE TV DO TIPO S�RIE REGULAR #####");
				
				for(ProgramaDeTV programaPassado: programasDeTV) {
					if(programaPassado.getTipo().equals(TipoDePrograma.SERIES_REGULARES)) {
						System.out.println(programaPassado.toString());
					}
				}
				System.out.println("");
				System.out.println("###### PROGRAMAS DE TV DO TIPO PROGRAMA CONT�NUO #####");
				
				for(ProgramaDeTV programaPassado: programasDeTV) {
					if(programaPassado.getTipo().equals(TipoDePrograma.PROGRAMAS_CONTINUOS)) {
						System.out.println(programaPassado.toString());
					}
				}
				System.out.println("");
				System.out.println("###### PROGRAMAS DE TV DO TIPO REALITY SHOW #####");
				for(ProgramaDeTV programaPassado: programasDeTV) {
					if(programaPassado.getTipo().equals(TipoDePrograma.REALITY_SHOWS)) {
						System.out.println(programaPassado.toString());
					}
				}
				System.out.println("");
				
			}else if(opc.equals("4")) {
				System.out.println("QUAL O NOME DO CANAL QUE DESEJA CADASTRAR? ");
				String nomeDoCanal = ler.nextLine();
				System.out.println("QUAL � O TIPO DESSE CANAL? (ABERTO OU PAGO). ");
				String tipoDoCanal = ler.nextLine();
				Canal canalInformado = new Canal(nomeDoCanal, tipoDoCanal);
				c.adicionarCanal(canalInformado);
				p.salvarCentral(c);
				
			}else if(opc.equals("5")) {
				List<Canal> canais = c.getTodosOsCanais();
				System.out.println("##### CANAIS CADASTRADOS #####");
				for(Canal canalPassado: canais) {
					System.out.println(canalPassado.toString());
				}
				
			}else if(opc.equals("6")) {
				List<Canal> canais = c.getTodosOsCanais();
				System.out.println("\n##### CANAIS CADASTRADOS #####\n");
				for(Canal canalPassado: canais) {
					System.out.println(canalPassado.toString());
					
				}
				System.out.println("DE QUAL CANAL DE TV DESEJA GERAR O RELAT�RIO DA PROGRAMA��O: ");
				String canalPassadoParaRelatorio = ler.nextLine().toUpperCase();
				for(Canal canalLista: c.getTodosOsCanais()) {
					if(canalLista.getNome().equals(canalPassadoParaRelatorio)) {
						GeradorDeRelatorios.obterProgramacaoDeUmCanal(canalLista);
						break;
					}
				}
			}else if(opc.equals("7")) {
				System.out.println("PARA QUAL E-MAIL DESEJA ENVIAR O RELATORIO DA PROGRAMACAO DE HOJE?");
				String destinatario = ler.nextLine();
				String assunto = "Relat�rio da programa��o do dia de hoje" ;  
				String mensagem = "Estamos quase";
				Mensageiro.enviarProgramacaoDeHoje(assunto, destinatario, mensagem);

			}else if(opc.equals("S")) {
				sair = true;
				
			}else {
				System.out.println("OP��O INV�LIDA.");
			}
		}		
	ler.close();

	}	
}